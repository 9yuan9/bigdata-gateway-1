package com.weein.bigdata.task;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.weein.bigdata.core.service.ProductService;
import com.weein.wcommon.cache.RedisClient;

@Service
public class GroupProductConfigurationCache {
	private static final Logger LOG = LoggerFactory.getLogger(GroupProductConfigurationCache.class);
	@Resource
	private RedisClient redisClient;
	@Resource
	private ProductService productService;
	
	@Scheduled(cron = "30 * * * * ?")  // 每天30秒执行一次
	public void cacheProductByGroupType() {
		productService.cacheProductByGroupType();
	}
}
