package com.weein.redis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.weein.wcommon.cache.RedisClient;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootSampleApplication.class)
@WebAppConfiguration
public class RedisTest {
	@Resource
	private RedisClient redisClient;
	@Test
	public void test(){
		redisClient.setString("a", "b", 0);
		System.out.println(redisClient.getString("a"));
		System.out.println("a");
	}
}
