package com.weein.bigdata.task;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.weein.bigdata.activemq.producer.IMessageNotificationMqProducer;
import com.weein.bigdata.core.service.BigDataQueryService;
import com.weein.bigdata.core.utils.MessageTemplateUtils;

@Service
public class SendMessageMqWork {
	private static final Logger LOG = LoggerFactory.getLogger(SendMessageMqWork.class);
	@Resource
	private IMessageNotificationMqProducer messageNotificationMqProducer;
	@Resource
	private BigDataQueryService bigDataQueryService;
	
	@Scheduled(cron = "20 * 10 * * ?")  // 每天10点执行一次
	public void sendNotifyMessageContext() {
		try {
			LOG.info("[千人千面应用，开始执行发送mq服务消息模板服务]");
			List<List<String>> dataList = null; //调用大数据平台接口查数据
			
			/*//查询3天用户
			String sql = "select * from weeintest.T_THREE_USER_LIST" ; 
			dataList = bigDataQueryService.getBigDataQueryResult(sql,1000);
			LOG.info("[千人千面应用查询3天用户T_THREE_USER_LIST的消息列表结果为]{}"+ new Object[]{dataList});

			for(int i=0;i<dataList.size();i++)
			{
				//System.out.println("3天用户"+dataList.get(i));
				JSONObject object = MessageTemplateUtils.getMessageTemplateOfRecommended(dataList.get(i).get(0), "2PCwCfjpooiBcPuHanc0x7JbP30bEUh41QUUSFcNiw8",
						"pages/index/index", dataList.get(i).get(1),  String.format("尊敬的用户您好，您日前在我们平台购买了%s，现有更多优惠等你来抢，点击立即前往！", dataList.get(i).get(1)), "#000000", "keyword1.DATA");
				messageNotificationMqProducer.sendMessageNotificationMessage(object);
			}
			
			//查询7天用户
			sql="select * from weeintest.T_SEVEN_USER_LIST" ; 
			dataList = bigDataQueryService.getBigDataQueryResult(sql,1000);
			LOG.info("[千人千面应用查询7天用户T_SEVEN_USER_LIST的消息列表结果为]{}"+ new Object[]{dataList});
			for(int i=0;i<dataList.size();i++)
			{
				//System.out.println("7天用户"+dataList.get(i));
				JSONObject object = MessageTemplateUtils.getMessageTemplateOfRecommended(dataList.get(i).get(0), "2PCwCfjpooiBcPuHanc0x7JbP30bEUh41QUUSFcNiw8",
						"pages/index/index", "心意有礼小程序",  String.format("尊敬的用户您好，您日前在我们平台购买了%s，现有更多优惠等你来抢，点击立即前往！", dataList.get(i).get(1)), "#000000", "keyword1.DATA");
				messageNotificationMqProducer.sendMessageNotificationMessage(object);
			}
			
			//查询30天用户
			sql="select * from weeintest.T_OTHER_DAYS" ;
			dataList = bigDataQueryService.getBigDataQueryResult(sql,1000);
			LOG.info("[千人千面应用查询30天用户T_OTHER_DAYS的消息列表结果为]{}"+ new Object[]{dataList});
			for(int i=0;i<dataList.size();i++)
			{
				//System.out.println("30天用户"+dataList.get(i));
				JSONObject object = MessageTemplateUtils.getMessageTemplateOfExpire(dataList.get(i).get(0), "Bxk31YkLWirAjOR4tZ-4XOZPXmmlxR50L1QPdwe2-Fo",
						"pages/index/index", dataList.get(i).get(1), dataList.get(i).get(2),  String.format("您的%s即将到期，请尽快使用！更多超值优惠正在进行中，点击立即续费。", dataList.get(i).get(1)), "#000000", "keyword1.DATA");
				messageNotificationMqProducer.sendMessageNotificationMessage(object);
			}*/
			
			
			
			//查询3天用户
			/*String sql = "select * from weeintest.T_OTHER_DAYS" ; //T_THREE_USER_LIST
			dataList = bigDataQueryService.getBigDataQueryResult(sql,1000);
			LOG.info("[千人千面应用查询3天用户T_THREE_USER_LIST的消息列表结果为]{}"+ new Object[]{dataList});

			int i = 0;
			
				//System.out.println("3天用户"+dataList.get(i));
				JSONObject object = MessageTemplateUtils.getMessageTemplateOfRecommended("ocqQM0YiRXf485lD5mS6tO_Com68", "2PCwCfjpooiBcPuHanc0x7JbP30bEUh41QUUSFcNiw8",
						"pages/index/index", dataList.get(i).get(1),  String.format("尊敬的用户您好，您日前在我们平台购买了%s，现有更多优惠等你来抢，点击立即前往！", dataList.get(i).get(1)), "#000000", "keyword1.DATA");
				messageNotificationMqProducer.sendMessageNotificationMessage(object);
			
			
			//查询7天用户
			sql="select * from weeintest.T_OTHER_DAYS" ;  // T_SEVEN_USER_LIST
			dataList = bigDataQueryService.getBigDataQueryResult(sql,1000);
			LOG.info("[千人千面应用查询7天用户T_SEVEN_USER_LIST的消息列表结果为]{}"+ new Object[]{dataList});
			
				//System.out.println("7天用户"+dataList.get(i));
				object = MessageTemplateUtils.getMessageTemplateOfRecommended("ocqQM0YiRXf485lD5mS6tO_Com68", "2PCwCfjpooiBcPuHanc0x7JbP30bEUh41QUUSFcNiw8",
						"pages/index/index", "心意有礼小程序",  String.format("尊敬的用户您好，您日前在我们平台购买了%s，现有更多优惠等你来抢，点击立即前往！", dataList.get(i).get(1)), "#000000", "keyword1.DATA");
				messageNotificationMqProducer.sendMessageNotificationMessage(object);

			
			//查询30天用户
			sql="select * from weeintest.T_OTHER_DAYS" ;
			dataList = bigDataQueryService.getBigDataQueryResult(sql,1000);
			LOG.info("[千人千面应用查询30天用户T_OTHER_DAYS的消息列表结果为]{}"+ new Object[]{dataList});
			
				//System.out.println("30天用户"+dataList.get(i));
				object = MessageTemplateUtils.getMessageTemplateOfExpire("ocqQM0YiRXf485lD5mS6tO_Com68", "Bxk31YkLWirAjOR4tZ-4XOZPXmmlxR50L1QPdwe2-Fo",
						"pages/index/index", dataList.get(i).get(1), dataList.get(i).get(2),  String.format("您的%s即将到期，请尽快使用！更多超值优惠正在进行中，点击立即续费。", dataList.get(i).get(1)), "#000000", "keyword1.DATA");
				messageNotificationMqProducer.sendMessageNotificationMessage(object);*/

			
		}catch (Exception e) {
			LOG.error("[千人千面应用，执行发送mq服务消息模板发生异常] .....", new Object[] { e });
		}
		  	
	}
}
