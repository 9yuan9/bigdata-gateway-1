package com.weein.bigdata.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.weein.bigdata.base.contants.MiniPRedisKeys;
import com.weein.wcommon.cache.RedisClient;

@Service
public class IsHolidaysAndFestivalsWorker {
	private static final Logger LOG = LoggerFactory.getLogger(IsHolidaysAndFestivalsWorker.class);
	@Resource
	private RedisClient redisClient;
	
	
	
	@Scheduled(cron = "0 0 0 * * ?")  // 每天0点执行一次
	public void cacheBooleanOfIsHolidaysAndFestivals() {
		try {
			Date now = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMdd");
			String date = formatter.format(now);
			
			String dateListData = redisClient.getString(MiniPRedisKeys.getHolidaysAndFestivals());
			List<String> dateList = JSON.parseArray(dateListData, String.class);
			Boolean flag = false;
			for (String dateString : dateList) {
				if(date.equals(dateString)) {
					flag = true;
				}
			}
			if(flag) {
				redisClient.setString(MiniPRedisKeys.getDateBooleanCache(), "true", -1);
			}else {
				redisClient.setString(MiniPRedisKeys.getDateBooleanCache(), "fase", -1);
			}
			
			LOG.info("[千人千面应用，缓存日期Boolean类型成功]");
		} catch (Exception e) {
			LOG.error("[千人千面应用，缓存日期Boolean类型发生异常].....", new Object[] { e });
		}
	}
}
