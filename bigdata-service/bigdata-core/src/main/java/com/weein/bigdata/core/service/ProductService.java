package com.weein.bigdata.core.service;

import java.util.List;

import com.weein.bigdata.base.vo.UserGroupProductsVo;
import com.weein.bigdata.base.vo.UserParamReqVo;
import com.weein.bigdata.base.vo.result.Result;

public interface ProductService {
	/**
	 * 缓存节假日日期列表格式如[20180925,20180926,...]
	 * @param year
	 * @param dateList
	 * @return
	 */
	Result<String> setHolidaysAndFestivals();
	
	/**
	 * 判断用户所在城市是否为膜拜入驻城市
	 * @param userCity
	 * @return
	 */
	Boolean isMobikeCity(String userCity);
	

	/**
	 * 获取第一维度省份运营商用户组编码（注意：此接口调用了本项目以外的心意有礼API接口telAttribution.do）
	 * @param userParamReqVo
	 * @return
	 */
	String getGroupTye1Code(UserParamReqVo userParamReqVo);
	
	/**
	 * 获取第二维度特用户组征编码
	 * @param userParamReqVo
	 * @return
	 */
	String getGroupTye2Code(UserParamReqVo userParamReqVo);
	
	/**
	 * 获取是否膜拜入驻城市特征编码
	 * @param userParamReqVo
	 * @return
	 */
	String getIsMobikeCityCode(UserParamReqVo userParamReqVo);
	
	/**
	 * 获取性别特征编码
	 * @param userParamReqVo
	 * @return
	 */
	String getGenderCode(UserParamReqVo userParamReqVo);
	
	/**
	 * 获取时间段特征编码
	 * @param userParamReqVo
	 * @return
	 */
	String getPeriodOfTimeCode(UserParamReqVo userParamReqVo);
	
	/**
	 * 获取年龄段特征编码
	 * @param userParamReqVo
	 * @return
	 */
	String getAgeCode(UserParamReqVo userParamReqVo);
	
	boolean cacheProductByGroupType();
	
	/**
	 * 根据用户信息获取主产品ID
	 * @param userParamReqVo
	 * @return
	 */
	Result<UserGroupProductsVo> getProductIdList(UserParamReqVo userParamReqVo) throws Exception;
	
	
}
