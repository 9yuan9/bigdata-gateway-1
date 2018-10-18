package com.weein.bigdata.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weein.mp.configuration.MpApiProperties;
import com.weein.wcommon.cache.RedisClient;
import com.weein.wcommon.utils.DateUtils;
import com.weein.wcommon.utils.HttpUtils;
import com.weein.wcommon.utils.MD5;
import com.weein.wcommon.utils.UUIDGenerator;

@RestController
@RequestMapping("/wxxcl/api")
public class ApiController {

	private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);
	
	@Resource
	private MpApiProperties mpApiProperties;

//	@RequestMapping(value = "/refund.do", method = RequestMethod.POST)
//	public Result<BalancesResVo> getBalances(HttpServletRequest request, HttpServletResponse response,String pass) {
//		String key = MD5.crypto("weein.cn.md5key"+DateUtils.formatAdvance(new Date(), DateUtils.FORMAT_DATE_01));
//		if(key.equals(pass)) {
//			Result<BalancesResVo> result = unicomUserService.getUserBalancesToPerformanceTest(phone);
//			return result;
//		}
//		return null;
//	}
	
	@Resource
	private RedisClient redisClient;
	
	

	@ResponseBody
	@RequestMapping(value = "/getMpAccessToken.do", method = RequestMethod.POST)
	public String getMpAccessToken(String appid,String sign) throws InterruptedException, ExecutionException, SQLException {
		
		String mpAppid = mpApiProperties.getMpAppid();
		
		return "error";
	}
	
	
	public static void main(String[] args) {
		System.out.println(MD5.crypto("weein" + DateUtils.formatAdvance(new Date(), DateUtils.FORMAT_DATE_01)));
	}
}
