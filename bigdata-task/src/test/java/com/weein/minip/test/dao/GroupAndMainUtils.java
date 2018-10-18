package com.weein.minip.test.dao;


import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weein.bigdata.base.vo.result.Result;



public class GroupAndMainUtils extends BaseTest{
	private static final Logger LOG = LoggerFactory.getLogger(GroupAndMainUtils.class);
	
	/*@Resource
	private IGroupBonusRecordService groupBonusRecordService;*/
	
	@Test
	public void a() throws InterruptedException {
		//Result<String> result = groupBonusRecordService.loadRecord("2018-05-04");
		while(true) {
			Thread.sleep(1000);
		}
	}
}
