package com.weein.minip.test.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.weein.mp.constant.ConstantUrls;
import com.weein.mp.utils.MpPaySignatureUtils;
import com.weein.mp.vo.red.req.MinipRedPackRequest;
import com.weein.mp.vo.red.req.MinipRedSelectReq;
import com.weein.mp.vo.red.res.RedSelectRes;
import com.weein.wcommon.utils.MD5;
import com.weein.wcommon.utils.UUIDGenerator;
import com.weein.wcommon.utils.UrlUtils;
import com.weein.wcommon.utils.XmlBeanUtils;

public class RedTest {
	@Test
	public void giveRed() {
		MinipRedPackRequest redPackRequest = new MinipRedPackRequest();
		redPackRequest.setAct_name("测试活动");
		redPackRequest.setClient_ip("123.119.236.111");
		redPackRequest.setMch_billno("test3");
		redPackRequest.setMch_id("1480631902");
		redPackRequest.setNonce_str(UUIDGenerator.getUUID());
		redPackRequest.setRe_openid("ocqQM0R_nx5AKHTb_PHTLj-HUiPQ");
		redPackRequest.setRemark("remark");
		redPackRequest.setSend_name("send_name");
		redPackRequest.setTotal_amount(30);
		redPackRequest.setTotal_num(1);
		redPackRequest.setWishing("wishing");
		redPackRequest.setNotify_way("JSAPI");
		redPackRequest.setWxappid("wx1a74e3dfe30a3067");
		redPackRequest.setScene_id("PRODUCT_2");
		redPackRequest.setSign(createWeixinSign(redPackRequest.getTreeMap(), "7aaad4b363fc0c3fa810d8eebc776af4"));
		String xml = XmlBeanUtils.getXmlByBean(redPackRequest, "xml");
		System.out.println(xml);
		String resultXml = HttpWxPayUtils.sendPost(ConstantUrls.SEND_MINIP_RED_PACK_URL,xml);//l,""/*PropertyConstant.CERT_PATH*/,mpApiProperties.getMchId());
//		String resultXml = "<xml>\n" + 
//				"<return_code><![CDATA[SUCCESS]]></return_code>\n" + 
//				"<return_msg><![CDATA[发放成功]]></return_msg>\n" + 
//				"<result_code><![CDATA[SUCCESS]]></result_code>\n" + 
//				"<err_code><![CDATA[SUCCESS]]></err_code>\n" + 
//				"<err_code_des><![CDATA[发放成功]]></err_code_des>\n" + 
//				"<mch_billno><![CDATA[test2]]></mch_billno>\n" + 
//				"<mch_id><![CDATA[1480631902]]></mch_id>\n" + 
//				"<wxappid><![CDATA[wx1a74e3dfe30a3067]]></wxappid>\n" + 
//				"<re_openid><![CDATA[ocqQM0R_nx5AKHTb_PHTLj-HUiPQ]]></re_openid>\n" + 
//				"<total_amount>30</total_amount>\n" + 
//				"<send_listid><![CDATA[1000041701201803093000060671352]]></send_listid>\n" + 
//				"<package><![CDATA[sendid=9556ffe6c845cb083cf82bc0009d1f4191ac1799fd2c0cc95a87fc16f69eeb45&ver=8&sign=aa41df7ed58b14f614317a0779febb6acb780628c286ee6dc4944a75c98bb3758755e3faea2b67d0762fb2495bffeed67fb7ec4043bc5762aa904caa027614bc&mchid=28431892&spid=1480631902]]></package>\n" + 
//				"</xml>";
		System.out.println(resultXml);
Map<String, Object> resultMap =XmlBeanUtils.xmlStrToMap(resultXml);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("timeStamp", System.currentTimeMillis()/1000+"");
		map.put("nonceStr", UUIDGenerator.getUUID());
		map.put("package", UrlUtils.encode(resultMap.get("package")+""));
		map.put("appId", "wx1a74e3dfe30a3067");
		
		String sign = MpPaySignatureUtils.getSign(map,"7aaad4b363fc0c3fa810d8eebc776af4");
//		map.put("package", resultMap.get("package")+"");
		map.put("signType", "MD5");
		map.put("paySign", sign);
//		map.remove("appId");
		System.out.println(JSON.toJSONString(map));
	}
	
	@Test
	public void selectRed() {
		MinipRedSelectReq minipRedSelectReq = new MinipRedSelectReq();
		minipRedSelectReq.setAppid("wx1a74e3dfe30a3067");
		minipRedSelectReq.setBill_type("MCHT");
		minipRedSelectReq.setMch_billno("1480631902201803090000000016");
		minipRedSelectReq.setMch_id("1480631902");
		minipRedSelectReq.setNonce_str(UUIDGenerator.getUUID());
		String sign = MpPaySignatureUtils.getSign(minipRedSelectReq, "7aaad4b363fc0c3fa810d8eebc776af4");
		minipRedSelectReq.setSign(sign);
		String xml = XmlBeanUtils.getXmlByBean(minipRedSelectReq, "xml");
		long start = System.currentTimeMillis();
		String resultXml = HttpWxPayUtils.sendPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo", xml);
		RedSelectRes redSelectRes = (RedSelectRes) XmlBeanUtils.xmlStrToBean(resultXml, RedSelectRes.class);
		System.out.println(System.currentTimeMillis()-start+"____"+xml+"____"+resultXml+"___"+JSON.toJSONString(redSelectRes));
	}
	
	/**
	 * 支付签名
	 * 
	 * @param map
	 * @param key
	 * @return
	 */
	public String createWeixinSign(TreeMap<String, String> map, String key) {
		map.remove("sign");
		StringBuilder signKey = new StringBuilder(createLinkString(map));
		if (signKey.length() > 0) {
			signKey.append("&key=" + key);// 去除最后一个&
			String sign = null;
			sign = MD5.crypto(signKey.toString()).toUpperCase();
			if (sign != null) {
				return sign;
			}
		}
		return null;
	}
	private static String createLinkString(TreeMap<String, String> map) {
		StringBuilder string = new StringBuilder();
		Set<String> keys = map.keySet();
		for (String key : keys) {
			Object value= map.get(key);
			if (value!=null) {
				string.append(key + "=" + value + "&");
			}
		}
		if (string.length() > 0) {
			string.deleteCharAt(string.length() - 1);
		}
		return string.toString();
	}
}
