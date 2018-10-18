package com.weein.bigdata.activemq.producer.impl;

import javax.annotation.Resource;
import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weein.bigdata.activemq.producer.IMessageNotificationMqProducer;
@Service
public class MessageNotificationMqProducerImpl implements IMessageNotificationMqProducer {
	private static final Logger LOG = LoggerFactory.getLogger(IMessageNotificationMqProducer.class);
	
	@Autowired(required=false)
    private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Resource(name="messageNotificationMQQueue")
	private Queue messageNotificationMQQueue;
	
	@Override
	public void sendMessageNotificationMessage(JSONObject object) {
		if(jmsMessagingTemplate!=null) {
			jmsMessagingTemplate.convertAndSend(messageNotificationMQQueue,JSON.toJSONString(object));	
		}else {
			
		}
		

	}

}
