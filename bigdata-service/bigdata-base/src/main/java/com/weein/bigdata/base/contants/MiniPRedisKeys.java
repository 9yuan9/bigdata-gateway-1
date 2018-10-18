package com.weein.bigdata.base.contants;

import com.weein.wcommon.utils.MD5;

/**
 * 
 * 
 * 类名称：MiniPRedisKeys<br/>
 * 类描述：redis keys<br/>
 * 创建人：guoxin<br/>
 * 创建时间：2016年5月30日 下午4:17:07 <br/>
 * 
 * @version
 *
 */
public class MiniPRedisKeys {

	private static final String SEPARATER = "_";
	
	//缓存节假日日期
	private static final String HOLIAYS_AND_FESTIVALS = "HOLIAYS_AND_FESTIVALS";
	
	//缓存今日日期类型：true为节假日   false为非节假日
	private static final String DATE_BOOLEAN_CACHE = "DATE_BOOLEAN_CACHE";
	
	//缓存膜拜入驻的城市
	private static final String MOBIKE_CITY_CACHE = "MOBIKE_CITY_CACHE";
	
	//缓存所有用户组
	private static final String BIGDATA_USER_GROUP_CACHE = "BIGDATA_USER_GROUP_CACHE";
	
	//缓存第一维度的所有用户组List列表
	private static final String BIGDATA_USER_ALL_GROUP_BY_TYPE1_CACHE = "BIGDATA_USER_ALL_GROUP_BY_TYPE1_CACHE";
	
	//缓存第二维度的所有用户组List列表
	private static final String BIGDATA_USER_ALL_GROUP_BY_TYPE2_CACHE = "BIGDATA_USER_ALL_GROUP_BY_TYPE2_CACHE";
	
	//按groupId分类缓存所有用户组-产品配置
	private static final String GP_CONFIGURATION_BY_GROUPID = "GP_CONFIGURATION_BY_GROUPID";
	
	public static String getHolidaysAndFestivals() {
		return HOLIAYS_AND_FESTIVALS;
	}
	
	public static String getDateBooleanCache() {
		return DATE_BOOLEAN_CACHE;
	}
	
	public static String getMobikeCityCache() {
		return MOBIKE_CITY_CACHE;
	}
	public static String getBigdataUserGroupCache(String groupId) {
		return BIGDATA_USER_GROUP_CACHE+SEPARATER+groupId;
	}
	public static String getBigdataUserAllGroupByType1Cache() {
		return BIGDATA_USER_ALL_GROUP_BY_TYPE1_CACHE;
	}
	public static String getBigdataUserAllGroupByType2Cache() {
		return BIGDATA_USER_ALL_GROUP_BY_TYPE2_CACHE;
	}
	public static String getGroupProductConfigurationCacheByGroupId(String groupId) {
		return GP_CONFIGURATION_BY_GROUPID+SEPARATER+groupId;
	}
	
	
	
}