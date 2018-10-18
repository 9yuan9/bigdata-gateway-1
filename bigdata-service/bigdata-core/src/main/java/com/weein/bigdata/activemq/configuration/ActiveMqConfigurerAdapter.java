package com.weein.bigdata.activemq.configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActiveMqConfigurerAdapter {
private static final Logger LOG = LoggerFactory.getLogger(ActiveMqConfigurerAdapter.class);
	
	@Bean
	public ActiveMQQueue orderChangeMQQueue() {
		return new ActiveMQQueue("ORDER_CHANGE_MQ_QUEUE");
	}
	
	@Bean
	public ActiveMQQueue messageNotificationMQQueue() {
		return new ActiveMQQueue("MESSAGE_NOTIFICATION_MQ_QUEUE");
	}
}
