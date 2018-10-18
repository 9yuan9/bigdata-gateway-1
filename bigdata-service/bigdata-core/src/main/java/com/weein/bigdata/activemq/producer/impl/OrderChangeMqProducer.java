package com.weein.bigdata.activemq.producer.impl;

import javax.annotation.Resource;
import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.weein.bigdata.activemq.producer.IOrderChangeMqProducer;
import com.weein.bigdata.base.entity.MyOrderDO;


@Service
public class OrderChangeMqProducer implements IOrderChangeMqProducer {
	private static final Logger LOG = LoggerFactory.getLogger(OrderChangeMqProducer.class);
	
	@Autowired(required=false)
    private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Resource(name="orderChangeMQQueue")
	private Queue orderChangeMQQueue;
	
	@Override
	public void sendOrderChangeMessage(MyOrderDO myOrderDO) {
		if(jmsMessagingTemplate!=null) {
			jmsMessagingTemplate.convertAndSend(orderChangeMQQueue,JSON.toJSONString(myOrderDO));	
		}else {
			
		}
		
	}

}
