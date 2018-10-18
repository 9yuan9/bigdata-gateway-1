package com.weein.bigdata.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.weein.bigdata.base.contants.MiniPRedisKeys;
import com.weein.bigdata.base.entity.BigdataGroupInfoDO;
import com.weein.bigdata.core.service.IBigdataGroupInfoService;
import com.weein.wcommon.cache.RedisClient;

@Service
public class UserGroupCache {
	private static final Logger LOG = LoggerFactory.getLogger(UserGroupCache.class);
	@Resource
	private RedisClient redisClient;
	@Resource
	private IBigdataGroupInfoService bigdataGroupInfoService;
	
	
	@Scheduled(cron = "30 * * * * ?")  // 每天30秒执行一次缓存所有第一维度用户组id和所有第一维度用户组id的List列表
	public void cacheGroupType1() {
		try{
			LOG.info("[千人千面应用，开始执行缓存所有第一维度用户组id服务]");
			Map< String, Object> map = new HashMap<>();
			map.put("type", 1);
			List<BigdataGroupInfoDO> groupInfoDOs = bigdataGroupInfoService.selectList(map);
			//redisClient.setString(MiniPRedisKeys.getBigdataUserAllGroupByType1Cache(), JSON.toJSONString(groupInfoDOs), 86400*30); // （86400*30）缓存30天
			for (BigdataGroupInfoDO bigdataGroupInfoDO : groupInfoDOs) {
				if(bigdataGroupInfoDO.getStatus() == 0){
					redisClient.del(MiniPRedisKeys.getBigdataUserGroupCache(bigdataGroupInfoDO.getDescription()));
				}else{
					redisClient.setString(MiniPRedisKeys.getBigdataUserGroupCache(bigdataGroupInfoDO.getDescription()), JSON.toJSONString(bigdataGroupInfoDO), 86400*30); // （86400*30）缓存30天
				}			}
		}catch (Exception e) {
			LOG.error("[千人千面应用，执行缓存所有用户组id发生异常] .....", new Object[] { e });
		}
	}
	
	@Scheduled(cron = "30 * * * * ?")  // 每天30秒执行一次缓存所有第二维度用户组id和所有第二维度用户组id的List列表
	public void cacheGroupType2() {
		try{
			LOG.info("[千人千面应用，开始执行缓存所有第二维度用户组id服务]");
			Map< String, Object> map = new HashMap<>();
			map.put("type", 2);
			List<BigdataGroupInfoDO> groupInfoDOs = bigdataGroupInfoService.selectList(map);
			//redisClient.setString(MiniPRedisKeys.getBigdataUserAllGroupByType2Cache(), JSON.toJSONString(groupInfoDOs), 86400*30); // （86400*30）缓存30天
			for (BigdataGroupInfoDO bigdataGroupInfoDO : groupInfoDOs) {
				if(bigdataGroupInfoDO.getStatus() == 0){
					redisClient.del(MiniPRedisKeys.getBigdataUserGroupCache(bigdataGroupInfoDO.getGroupId()));
				}else{
					redisClient.setString(MiniPRedisKeys.getBigdataUserGroupCache(bigdataGroupInfoDO.getGroupId()), JSON.toJSONString(bigdataGroupInfoDO), 86400*30); // （86400*30）缓存30天
				}
			}
		}catch (Exception e) {
			LOG.error("[千人千面应用，执行缓存所有用户组id发生异常] .....", new Object[] { e });
		}
	}
	
}
