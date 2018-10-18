package com.weein.minip.test.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.scheduling.annotation.Scheduled;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weein.bigdata.activemq.consumer.ActiveMQConsumer;
import com.weein.bigdata.activemq.producer.IMessageNotificationMqProducer;
import com.weein.bigdata.activemq.producer.IOrderChangeMqProducer;
import com.weein.bigdata.base.contants.MiniPRedisKeys;
import com.weein.bigdata.base.entity.BigdataGroupInfoDO;
import com.weein.bigdata.base.entity.BigdataGroupProductConfigurationDO;
import com.weein.bigdata.base.entity.MyOrderDO;
import com.weein.bigdata.base.vo.UserParamReqVo;
import com.weein.bigdata.core.configuration.BigDataJDBCProperties;
import com.weein.bigdata.core.service.BigDataQueryService;
import com.weein.bigdata.core.service.IBigdataGroupInfoService;
import com.weein.bigdata.core.service.IBigdataGroupProductConfigurationService;
import com.weein.bigdata.core.service.ProductService;
import com.weein.bigdata.core.service.UserDataDisposeService;
import com.weein.bigdata.core.utils.JdbcUtils;
import com.weein.bigdata.core.utils.MessageTemplateUtils;
import com.weein.bigdata.core.utils.NetUtil;
import com.weein.mp.api.IMpBroker;
import com.weein.wcommon.cache.RedisClient;

public class RedisTest extends BaseTest{
	
	@Resource
	private RedisClient redisClient;
	
	@Resource
	private IMpBroker mpBroker;
	
	@Resource
	private ProductService productService;
	
	@Resource
	private UserDataDisposeService userDataDisposeService;
	
	@Resource
	private ActiveMQConsumer activeMQConsumer;
	
	@Resource
	private IOrderChangeMqProducer orderChangeMqProducer;
	
	@Resource
	private IMessageNotificationMqProducer messageNotificationMqProducer;
	
	@Resource
	private BigDataQueryService bigDataQueryService;
	@Resource
	private IBigdataGroupInfoService bigdataGroupInfoService;
	@Resource
	private IBigdataGroupProductConfigurationService bigdataGroupProductConfigurationService;
	@Resource
	private BigDataJDBCProperties bigDataJDBCProperties;
	
	@Test
	public void bill() {
		mpBroker.getBillRecordByMp("20180722", "ALL");
	}
	
	@Test
	public void test() throws InterruptedException {
		System.out.println("节假日缓存结果"+JSON.toJSONString(productService.setHolidaysAndFestivals()));
		System.out.println("节假日列表"+redisClient.getString(MiniPRedisKeys.getHolidaysAndFestivals()));
		
	}
	
	@Test
	public void test1() {
		System.out.println(productService.isMobikeCity("上海"));
	}
	
	@Test
	public void test2() {
		UserParamReqVo userParamReqVo = new UserParamReqVo();
		userParamReqVo.setPhone("13001699052");
		userParamReqVo.setCity("");
		
		try {
			productService.getProductIdList(userParamReqVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		System.out.println(userDataDisposeService.getUserData1("13001699052"));
	}
	
	
	
	@Test
	public void test5() {
		MyOrderDO myOrderDO = new MyOrderDO();
		myOrderDO.setMinipOpenId("111111");
		myOrderDO.setNumber("15279106130");
		myOrderDO.setProductName("流量");
		orderChangeMqProducer.sendOrderChangeMessage(myOrderDO);
	}
	
	@Test
	public void test6() {
		JSONObject object = new JSONObject();
		JSONObject object1 = new JSONObject();
		JSONObject object11 = new JSONObject();
		object11.put("value", "XXX（腾讯视频VIP）");
		object1.put("keyword1", object11);
		
		
		JSONObject object22 = new JSONObject();
		object22.put("value", "2018.10.22");
		object1.put("keyword2", object22);
		
		JSONObject object33 = new JSONObject();
		object33.put("value", "您的×××即将到期，请尽快使用！更多超值优惠正在进行中，点击立即续费。");
		object1.put("keyword3", object33);
		
		object.put("touser", "OPENID");
		object.put("template_id", "Bxk31YkLWirAjOR4tZ-4XOZPXmmlxR50L1QPdwe2-Fo");
		object.put("page", "跳转到首页该产品小程序购买链接（需要具体链接地址）");
		object.put("form_id", "FORMID");
		object.put("data", object1);
		messageNotificationMqProducer.sendMessageNotificationMessage(object);
	}
	
	@Test
	public void test7() {
		JSONObject object = MessageTemplateUtils.getMessageTemplateOfExpire("OPENID", "Bxk31YkLWirAjOR4tZ-4XOZPXmmlxR50L1QPdwe2-Fo",
				"跳转到首页该产品小程序购买链接（需要具体链接地址）","XXX（腾讯视频VIP）", "2018.10.22",  "您的×××即将到期，请尽快使用！更多超值优惠正在进行中，点击立即续费。", "#000000", "keyword1.DATA");
		messageNotificationMqProducer.sendMessageNotificationMessage(object);
	}
	
	@Test
	public void test8() {
		System.out.println(NetUtil.get("https://tatcgateway2.weein.cn/v2/product/telAttribution.do?phone=13011652482"));
	}
	
	@Test
	public void test9() {
		List<List<String>> userData = userDataDisposeService.getUserData1("13001699052");
		System.out.println(userData.get(0).get(3));
		
	}
	@Test
	public void test10() {
		System.out.println(bigDataQueryService.getBigDataQueryResult("SELECT * FROM WEEINTEST.T_USER_TEST where phone =13011652482", 2));
	}
	
	
	@Test
	public void testSendMessage(){
		List<List<String>> dataList = null; //调用大数据平台接口查数据
		
		//查询3天用户
		String sql = "select * from weeintest.T_THREE_USER_LIST" ;
		dataList = bigDataQueryService.getBigDataQueryResult(sql,1000);
		for(int i=0;i<dataList.size();i++)
		{
			System.out.println(dataList.get(i));
			JSONObject object = MessageTemplateUtils.getMessageTemplateOfExpire(dataList.get(i).get(0), "2PCwCfjpooiBcPuHanc0x7JbP30bEUh41QUUSFcNiw8",
					"跳转到首页该产品小程序购买链接（需要具体链接地址）", dataList.get(i).get(1), dataList.get(i).get(2),  String.format("尊敬的用户您好，您日前在我们平台购买了%s，现有更多优惠等你来抢，点击立即前往！", dataList.get(i).get(1)), "#000000", "keyword1.DATA");
			messageNotificationMqProducer.sendMessageNotificationMessage(object);
		}
		
		//查询7天用户
		sql="select * from weeintest.T_SEVEN_USER_LIST" ;
		dataList = bigDataQueryService.getBigDataQueryResult(sql,1000);
		for(int i=0;i<dataList.size();i++)
		{
			System.out.println(dataList.get(i));
			JSONObject object = MessageTemplateUtils.getMessageTemplateOfExpire(dataList.get(i).get(0), "2PCwCfjpooiBcPuHanc0x7JbP30bEUh41QUUSFcNiw8",
					"跳转到首页该产品小程序购买链接（需要具体链接地址）", dataList.get(i).get(1), dataList.get(i).get(2),  String.format("尊敬的用户您好，您日前在我们平台购买了%s，现有更多优惠等你来抢，点击立即前往！", dataList.get(i).get(1)), "#000000", "keyword1.DATA");
			messageNotificationMqProducer.sendMessageNotificationMessage(object);
		}
		
		//查询30天用户
		sql="select * from weeintest.T_OTHER_DAYS" ;
		dataList = bigDataQueryService.getBigDataQueryResult(sql,1000);
		for(int i=0;i<dataList.size();i++)
		{
			System.out.println(dataList.get(i));
			JSONObject object = MessageTemplateUtils.getMessageTemplateOfExpire(dataList.get(i).get(0), "Bxk31YkLWirAjOR4tZ-4XOZPXmmlxR50L1QPdwe2-Fo",
					"跳转到首页该产品小程序购买链接（需要具体链接地址）", dataList.get(i).get(1), dataList.get(i).get(2),  String.format("您的%s即将到期，请尽快使用！更多超值优惠正在进行中，点击立即续费。", dataList.get(i).get(1)), "#000000", "keyword1.DATA");
			messageNotificationMqProducer.sendMessageNotificationMessage(object);
		}
	}
	
	@Test
	public void testcahce(){
		try{
			List<BigdataGroupInfoDO> groupInfoDOs = bigdataGroupInfoService.selectList(null);
			System.out.println(JSON.toJSONString(groupInfoDOs));
			for (BigdataGroupInfoDO bigdataGroupInfoDO : groupInfoDOs) {
				redisClient.setString(MiniPRedisKeys.getBigdataUserGroupCache(bigdataGroupInfoDO.getGroupId()), JSON.toJSONString(bigdataGroupInfoDO), -1);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testGetcahce(){
		//String data = redisClient.getString(MiniPRedisKeys.getBigdataUserGroupCache("c1g1t3a2"));
		Map< String, Object> map = new HashMap<>();
		map.put("type", 1);
		List<BigdataGroupInfoDO> groupInfoDOs = bigdataGroupInfoService.selectList(map);
		for (BigdataGroupInfoDO bigdataGroupInfoDO : groupInfoDOs) {
			if(bigdataGroupInfoDO.getStatus() == 0){
				redisClient.del(MiniPRedisKeys.getBigdataUserGroupCache(bigdataGroupInfoDO.getDescription()));
			}else{
				redisClient.setString(MiniPRedisKeys.getBigdataUserGroupCache(bigdataGroupInfoDO.getDescription()), JSON.toJSONString(bigdataGroupInfoDO), -1);
			}		
		System.out.println(redisClient.getString(MiniPRedisKeys.getBigdataUserGroupCache("等我")));
	}
	}
	
	
	@Test
	public void testSetKey(){
		try{
			Map< String, Object> map = new HashMap<>();
			List<BigdataGroupProductConfigurationDO> groupInfoDOs = bigdataGroupProductConfigurationService.selectList(map);
			Map<String,List<BigdataGroupProductConfigurationDO>> indexMap = new HashMap<>();
			for (BigdataGroupProductConfigurationDO bigdataGroupProductConfigurationDO : groupInfoDOs) {
				List<BigdataGroupProductConfigurationDO> list = indexMap.get(bigdataGroupProductConfigurationDO.getGroupId());
				if(list==null){
					list = new ArrayList<>();
					indexMap.put(bigdataGroupProductConfigurationDO.getGroupId(),list);
				}
				list.add(bigdataGroupProductConfigurationDO);
				//redisClient.setString(MiniPRedisKeys.getBigdataUserGroupCache(bigdataGroupProductConfigurationDO.getGroupId()), JSON.toJSONString(bigdataGroupProductConfigurationDO), -1);
			}
			
			Set<String> keys=indexMap.keySet();
			for(String groupId:keys){
				List<BigdataGroupProductConfigurationDO> list = indexMap.get(groupId);
				redisClient.setString(MiniPRedisKeys.getGroupProductConfigurationCacheByGroupId(groupId), JSON.toJSONString(list),0);
			}
			List<BigdataGroupProductConfigurationDO> ss = JSON.parseArray(redisClient.getString(MiniPRedisKeys.getGroupProductConfigurationCacheByGroupId("c1g1t3a0")), BigdataGroupProductConfigurationDO.class);
			System.out.println(JSON.toJSONString(ss.get(1)));
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	
	
	@Test
	public void getTest(){
		//System.out.println("1234".substring(0, 2));
		String driver = bigDataJDBCProperties.getDriver();
        String url = bigDataJDBCProperties.getUrl();
        String user = bigDataJDBCProperties.getUser();
        String password = bigDataJDBCProperties.getPassword();
        Properties properties = new Properties();
        properties.setProperty("driver", driver);
		System.out.println(JSON.toJSONString(properties));
		//System.out.println(redisClient.getString(MiniPRedisKeys.getBigdataUserGroupCache("c0g0t1a0")));
	}
	
	@Test
	public void getTestr(){
		String driver = bigDataJDBCProperties.getDriver();
        String url = bigDataJDBCProperties.getUrl();
        String user = bigDataJDBCProperties.getUser();
        String password = bigDataJDBCProperties.getPassword();
		Properties properties = new Properties();
        properties.setProperty("driver", driver);
        properties.setProperty("url", url);
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        List<List<String>> resultList = null;
        String sql = "SELECT * FROM WEEINTEST.T_USER_TEST where OPEN_ID ='oN3YS0bqgs1R7zNGxY88aAltc1qg'";
        
        try {
        	resultList = JdbcUtils.readFirstRows(driver, url, properties, sql, 5);
        	System.out.println(resultList );
        }catch (Exception e) {
        	System.out.println( e );
		}
	}
	
	@Test
	public void testDelredis(){
		System.out.println(redisClient.getString(MiniPRedisKeys.getBigdataUserGroupCache("c1g1t1a1")));
	}
	
	@Test
	public void testActivemq(){
		try {
			/*List<List<String>> dataList = null; //调用大数据平台接口查数据
			
			//查询3天用户
			String sql = "select * from weeintest.T_THREE_USER_LIST" ;
			dataList = bigDataQueryService.getBigDataQueryResult(sql,1000);
			System.out.println("[千人千面应用查询3天用户T_THREE_USER_LIST的消息列表结果为]{}"+ dataList);

			for(int i=0;i<dataList.size();i++)
			{
				//System.out.println("3天用户"+dataList.get(i));
				JSONObject object = MessageTemplateUtils.getMessageTemplate(dataList.get(i).get(0), "2PCwCfjpooiBcPuHanc0x7JbP30bEUh41QUUSFcNiw8",
						"pages/index/index", dataList.get(i).get(1), dataList.get(i).get(2),  String.format("尊敬的用户您好，您日前在我们平台购买了%s，现有更多优惠等你来抢，点击立即前往！", dataList.get(i).get(1)), "#000000", "keyword1.DATA");
				messageNotificationMqProducer.sendMessageNotificationMessage(object);
			}
			
			//查询7天用户
			sql="select * from weeintest.T_SEVEN_USER_LIST" ;
			dataList = bigDataQueryService.getBigDataQueryResult(sql,1000);
			System.out.println("[千人千面应用查询7天用户T_SEVEN_USER_LIST的消息列表结果为]{}"+ dataList);
			for(int i=0;i<dataList.size();i++)
			{
				//System.out.println("7天用户"+dataList.get(i));
				JSONObject object = MessageTemplateUtils.getMessageTemplate(dataList.get(i).get(0), "2PCwCfjpooiBcPuHanc0x7JbP30bEUh41QUUSFcNiw8",
						"pages/index/index", dataList.get(i).get(1), dataList.get(i).get(2),  String.format("尊敬的用户您好，您日前在我们平台购买了%s，现有更多优惠等你来抢，点击立即前往！", dataList.get(i).get(1)), "#000000", "keyword1.DATA");
				messageNotificationMqProducer.sendMessageNotificationMessage(object);
			}
			
			//查询30天用户
			sql="select * from weeintest.T_OTHER_DAYS" ;
			dataList = bigDataQueryService.getBigDataQueryResult(sql,1000);
			System.out.println("[千人千面应用查询30天用户T_OTHER_DAYS的消息列表结果为]{}"+ dataList);
			for(int i=0;i<dataList.size();i++)
			{
				//System.out.println("30天用户"+dataList.get(i));
				JSONObject object = MessageTemplateUtils.getMessageTemplate(dataList.get(i).get(0), "Bxk31YkLWirAjOR4tZ-4XOZPXmmlxR50L1QPdwe2-Fo",
						"pages/index/index", dataList.get(i).get(1), dataList.get(i).get(2),  String.format("您的%s即将到期，请尽快使用！更多超值优惠正在进行中，点击立即续费。", dataList.get(i).get(1)), "#000000", "keyword1.DATA");
				messageNotificationMqProducer.sendMessageNotificationMessage(object);
			}*/
			String sql="select * from weeintest.T_OTHER_DAYS" ;
			List<List<String>> dataList = bigDataQueryService.getBigDataQueryResult(sql,1000);
			JSONObject object = MessageTemplateUtils.getMessageTemplateOfExpire(dataList.get(0).get(0), "ocqQM0YiRXf485lD5mS6tO_Com68",
					"pages/index/index", dataList.get(0).get(1), dataList.get(0).get(2),  String.format("您的%s即将到期，请尽快使用！更多超值优惠正在进行中，点击立即续费。", dataList.get(0).get(1)), "#000000", "keyword1.DATA");
			System.out.println(JSON.toJSONString(object));
			
			messageNotificationMqProducer.sendMessageNotificationMessage(object);
			
		}catch (Exception e) {
			System.out.println("[千人千面应用，执行发送mq服务消息模板发生异常] ....."+e );
		}
	}
	
	
	@Test
	public void cacheGroupType1() {
		try{
			Map< String, Object> map = new HashMap<>();
			map.put("type", 1);
			List<BigdataGroupInfoDO> groupInfoDOs = bigdataGroupInfoService.selectList(map);
			redisClient.setString(MiniPRedisKeys.getBigdataUserAllGroupByType1Cache(), JSON.toJSONString(groupInfoDOs), 86400*30); // （86400*30）缓存30天
			for (BigdataGroupInfoDO bigdataGroupInfoDO : groupInfoDOs) {
				if(bigdataGroupInfoDO.getStatus() == 0){
					redisClient.del(MiniPRedisKeys.getBigdataUserGroupCache(bigdataGroupInfoDO.getDescription()));
				}else{
					redisClient.setString(MiniPRedisKeys.getBigdataUserGroupCache(bigdataGroupInfoDO.getDescription()), JSON.toJSONString(bigdataGroupInfoDO), 86400*30); // （86400*30）缓存30天
				}			}
		}catch (Exception e) {
		}
		
		List<BigdataGroupInfoDO> groupInfoDOs1 = JSONObject.parseArray(redisClient.getString(MiniPRedisKeys.getBigdataUserAllGroupByType1Cache()), BigdataGroupInfoDO.class);
		System.out.println(JSON.toJSONString(groupInfoDOs1));
	}
	
	@Test
	public void cacheGroupType2() {
		try{
			Map< String, Object> map = new HashMap<>();
			map.put("type", 2);
			List<BigdataGroupInfoDO> groupInfoDOs = bigdataGroupInfoService.selectList(map);
			redisClient.setString(MiniPRedisKeys.getBigdataUserAllGroupByType2Cache(), JSON.toJSONString(groupInfoDOs), 86400*30); // （86400*30）缓存30天
			for (BigdataGroupInfoDO bigdataGroupInfoDO : groupInfoDOs) {
				if(bigdataGroupInfoDO.getStatus() == 0){
					redisClient.del(MiniPRedisKeys.getBigdataUserGroupCache(bigdataGroupInfoDO.getGroupId()));
				}else{
					redisClient.setString(MiniPRedisKeys.getBigdataUserGroupCache(bigdataGroupInfoDO.getGroupId()), JSON.toJSONString(bigdataGroupInfoDO), 86400*30); // （86400*30）缓存30天
				}
			}
		}catch (Exception e) {
		}
		
		List<BigdataGroupInfoDO> groupInfoDOs2 = JSONObject.parseArray(redisClient.getString(MiniPRedisKeys.getBigdataUserAllGroupByType2Cache()), BigdataGroupInfoDO.class);
		System.out.println(JSON.toJSONString(groupInfoDOs2));
	}
	
	
	@Test
	public void TestTimeOut(){
		
		userDataDisposeService.getUserData1("13011652482");
		//System.out.println(userDataDisposeService.getUserData2("oN3YS0bqgs1R7zNGxY88aAltc1qg"));
	}
	 
    
}
