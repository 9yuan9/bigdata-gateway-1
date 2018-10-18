package com.weein.bigdata.activemq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Component
public class ActiveMQConsumer {
	private static final Logger LOG = LoggerFactory.getLogger(ActiveMQConsumer.class);

	@JmsListener(destination = "ORDER_CHANGE_MQ_QUEUE")
	public void receivedMessage(String message) {
		LOG.info("[千人千面应用收到的订单变更消息为]{}"+ new Object[]{message});
		System.out.println("千人千面应用收到的订单变更消息为" + message);
	}
	
	
	/*@JmsListener(destination = "MESSAGE_NOTIFICATION_MQ_QUEUE")
	public void receivedMessageNotification(String message) {
		JSONObject jsonObject = JSONObject.parseObject(message);
		LOG.info("[千人千面应用收到的服务通知消息模板为]{}"+ new Object[]{JSON.toJSONString(jsonObject)});
		System.out.println("千人千面应用收到的服务通知消息模板为" + JSON.toJSONString(jsonObject));
	}*/

}
