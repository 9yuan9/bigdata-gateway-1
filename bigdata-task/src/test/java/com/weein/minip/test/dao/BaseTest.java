package com.weein.minip.test.dao;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.weein.bigdata.Application;
import com.weein.bigdata.activemq.producer.IMessageNotificationMqProducer;
import com.weein.bigdata.core.utils.MessageTemplateUtils;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class,webEnvironment=WebEnvironment.RANDOM_PORT)
@Rollback
//@SpringApplicationConfiguration(Application.class)
//@WebIntegrationTest({ "server.port=4004" })
//@TransactionConfiguration(defaultRollback=true)
public class BaseTest {
	@Resource
	private IMessageNotificationMqProducer messageNotificationMqProducer;
	@Test
	public void test7() {
		JSONObject object = MessageTemplateUtils.getMessageTemplateOfExpire("OPENID", "Bxk31YkLWirAjOR4tZ-4XOZPXmmlxR50L1QPdwe2-Fo",
				"跳转到首页该产品小程序购买链接（需要具体链接地址）", "XXX（腾讯视频VIP）", "2018.10.22",  "您的×××即将到期，请尽快使用！更多超值优惠正在进行中，点击立即续费。", "#000000", "keyword1.DATA");
		messageNotificationMqProducer.sendMessageNotificationMessage(object);
	}
}
