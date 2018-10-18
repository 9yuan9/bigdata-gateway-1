package com.weein.bigdata.core.service;

import java.util.List;

import com.weein.bigdata.base.entity.BigdataGroupInfoDO;
import com.weein.bigdata.base.vo.ProductInfoDOVo;
import com.weein.bigdata.base.vo.result.Result;

public interface ConfigurateGroupProductService {
	/**
	 * 获取第一维度省份运营商的所有用户组
	 * @return
	 */
	 Result<List<BigdataGroupInfoDO>> queryAllGroupByType1();
	 
	 /**
	  * 获取第二维度特征所有用户组
	  * @return
	  */
	 Result<List<BigdataGroupInfoDO>> queryAllGroupByType2();
	 
	 /**
	  * 根据第一维度用户组id和三大运营商字码获取该用户组的话费流量产品
	  * @param code
	  * @param groupId
	  * @return
	  */
	 Result<List<ProductInfoDOVo>> queryAllProductIdByGroupType1(String code, String groupId);
	 
	 /**
	  * 根据第二维度用户组id获取该用户组的权益产品
	  * @param groupId
	  * @return
	  */
	 Result<List<ProductInfoDOVo>> queryAllProductIdByGroupType2(String groupId);
	 
	 /**
	  * 配置用户组所对应的所有匹配产品
	  * @param groupId
	  * @param list
	  * @return
	  */
	 Result<String> addGroupProductConfiguration(String groupId, String list);
}
