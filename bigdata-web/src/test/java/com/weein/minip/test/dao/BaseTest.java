package com.weein.minip.test.dao;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.weein.bigdata.Application;
import com.weein.bigdata.activemq.producer.IOrderChangeMqProducer;
import com.weein.bigdata.base.entity.MyOrderDO;
import com.weein.mp.api.IMpBroker;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class,webEnvironment=WebEnvironment.RANDOM_PORT)
@Rollback
//@SpringApplicationConfiguration(Application.class)
//@WebIntegrationTest({ "server.port=4004" })
//@TransactionConfiguration(defaultRollback=true)
public class BaseTest {
	@Resource
	private IMpBroker mpBroker;
	@Resource
	private com.weein.mp.configuration.MpApiProperties MpApiProperties;
	@Resource
	private IOrderChangeMqProducer iOrderChangeMqProducer;
	@Test
	public void kingCardController(){
		System.out.println(JSON.toJSONString(null));
	}
	
}
