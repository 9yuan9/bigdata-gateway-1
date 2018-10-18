package com.weein.bigdata.core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weein.bigdata.base.contants.MiniPRedisKeys;
import com.weein.bigdata.base.entity.BigdataGroupInfoDO;
import com.weein.bigdata.base.entity.BigdataGroupProductConfigurationDO;
import com.weein.bigdata.base.vo.ProductsOfGroupVo;
import com.weein.bigdata.base.vo.UserGroupProductsVo;
import com.weein.bigdata.base.vo.UserParamReqVo;
import com.weein.bigdata.base.vo.result.Result;
import com.weein.bigdata.core.configuration.BigDataJoinWxxclProperties;
import com.weein.bigdata.core.service.IBigdataGroupProductConfigurationService;
import com.weein.bigdata.core.service.ProductService;
import com.weein.bigdata.core.service.UserDataDisposeService;
import com.weein.bigdata.core.utils.NetUtil;
import com.weein.wcommon.cache.RedisClient;

@Service
public class ProductServiceImpl implements ProductService {
	private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

	@Resource
	private RedisClient redisClient;
	@Resource
	private BigDataJoinWxxclProperties bigDataJoinWxxclProperties;
	@Resource
	private UserDataDisposeService userDataDisposeService;
	@Resource
	private IBigdataGroupProductConfigurationService bigdataGroupProductConfigurationService;
	

	@Override
	public Result<String> setHolidaysAndFestivals() {
		Result<String> result = new Result<>();
		List<String> dateList = new ArrayList<String>();
		
		//测试
		dateList.add("20180925");
		
		//国庆节假日
		dateList.add("20181001");
		dateList.add("20181002");
		dateList.add("20181003");
		dateList.add("20181004");
		dateList.add("20181005");
		dateList.add("20181006");
		dateList.add("20181007");
		
		//春节假日
		dateList.add("20190101");
		dateList.add("20190202");
		dateList.add("20190203");
		dateList.add("20190204");
		dateList.add("20190205");
		dateList.add("20190206");
		dateList.add("20190207");
		dateList.add("20190208");
		
		//元宵假日
		dateList.add("20190219");
		try {
			
			redisClient.setString(MiniPRedisKeys.getHolidaysAndFestivals(), dateList.toString(), -1);
			result.setSuccess(true);
			LOG.info("[缓存节假日成功:{}", new Object[] { dateList });
			return result;

		} catch (Exception e) {
			result.setSuccess(false);
			LOG.error("发生异常{}", new Object[] { e });
			return result;
		}
	}
	
	@Override
	public Result<UserGroupProductsVo> getProductIdList(UserParamReqVo userParamReqVo) throws Exception{
		Result<UserGroupProductsVo> result = new Result<>();
		List<List<String>> userData = null;
		if(userParamReqVo.getPhone() != null){
			
			userData = userDataDisposeService.getUserData1(userParamReqVo.getPhone());
		}else{
			userData = userDataDisposeService.getUserData2(userParamReqVo.getOpenId());
		}
		
		//System.out.println("userParamReqVo:"+JSON.toJSONString(userParamReqVo));
		//System.out.println("userData"+userData.get(0));
		if(userData != null  && userData.size() > 0){
			if(userParamReqVo.getPhone() == null || userParamReqVo.getPhone().equals("")) {
				if(userData.get(0).get(0) !=null){
					userParamReqVo.setPhone(userData.get(0).get(0));
				}
			}
			if(userParamReqVo.getOpenId() == null || userParamReqVo.getOpenId().equals("")) {
				if(userData.get(0).get(1) !=null){
					userParamReqVo.setOpenId(userData.get(0).get(1));
				}
			}
			if(userParamReqVo.getCity() == null || userParamReqVo.getCity().equals("")) {
				if(userData.get(0).get(11) !=null){
					userParamReqVo.setCity(userData.get(0).get(11));
				}
			}
			if(userParamReqVo.getGender() == null || userParamReqVo.getGender().equals("")) {
				if(userData.get(0).get(2) !=null){
					userParamReqVo.setGender(userData.get(0).get(2));
				}
				
			}
			if(userParamReqVo.getAge() == null || userParamReqVo.getAge().equals("")) {
				if(userData.get(0).get(2) !=null){
					userParamReqVo.setAge(userData.get(0).get(3));
				}
			}
		}
		try {
			
			
			//System.out.println("userParamReqVo:"+JSON.toJSONString(userParamReqVo));
			// 获取用户第一维度用户组编号（省份运营商）
			String groupTye1Code = getGroupTye1Code(userParamReqVo);
			//System.out.println("groupTye1Code:"+groupTye1Code);
			//获取用户第一维度用户组编号对应的所有产品
			if(groupTye1Code.equals("unknownPhone")){
				groupTye1Code = "LTS001";
			}
			List<BigdataGroupProductConfigurationDO> groupTye1Products = JSON.parseArray(redisClient.getString(MiniPRedisKeys.getGroupProductConfigurationCacheByGroupId(groupTye1Code)), BigdataGroupProductConfigurationDO.class);
			ProductsOfGroupVo productsOfGroupTye1 = new ProductsOfGroupVo();
			productsOfGroupTye1.setGroupId(groupTye1Code);
			List<String> productIDsOfGroupTye1 = new ArrayList<>();
			if(groupTye1Products != null){
				for (BigdataGroupProductConfigurationDO bigdataGroupProductConfigurationDO : groupTye1Products) {
					if(bigdataGroupProductConfigurationDO.getStatus() == 1){
						if(!bigdataGroupProductConfigurationDO.getProductId().equals("")){
							productIDsOfGroupTye1.add(bigdataGroupProductConfigurationDO.getProductId());
						}
					}
				}
				productsOfGroupTye1.setProductIdList(productIDsOfGroupTye1);
			}
			
			
			
			// 获取用户第二维度用户组编号（特征）
			String groupTye2Code = getGroupTye2Code(userParamReqVo);
			//System.out.println("groupTye2Code:"+groupTye2Code);
			//获取用户第二维度用户组编号对应的所有产品
			List<BigdataGroupProductConfigurationDO> groupTye2Products = JSON.parseArray(redisClient.getString(MiniPRedisKeys.getGroupProductConfigurationCacheByGroupId(groupTye2Code)), BigdataGroupProductConfigurationDO.class);
			ProductsOfGroupVo productsOfGroupTye2 = new ProductsOfGroupVo();
			productsOfGroupTye2.setGroupId(groupTye2Code);
			List<String> productIDsOfGroupTye2 = new ArrayList<>();
			if(groupTye2Products != null){
				for (BigdataGroupProductConfigurationDO bigdataGroupProductConfigurationDO : groupTye2Products) {
					if(bigdataGroupProductConfigurationDO.getStatus() == 1){
						//System.out.println(bigdataGroupProductConfigurationDO.getProductId());
						if(bigdataGroupProductConfigurationDO.getProductId() != null && !bigdataGroupProductConfigurationDO.getProductId().equals("")){
							productIDsOfGroupTye2.add(bigdataGroupProductConfigurationDO.getProductId());
						}
					}
				}
				productsOfGroupTye2.setProductIdList(productIDsOfGroupTye2);
			}
			
			UserGroupProductsVo userGroupProductsVo = new UserGroupProductsVo();
			userGroupProductsVo.setGroupTye1Products(productsOfGroupTye1);
			userGroupProductsVo.setGroupTye2Products(productsOfGroupTye2);
			
			List<String> productIdList = new ArrayList<>();
			if(productsOfGroupTye1.getProductIdList() != null){
				for (String productId : productsOfGroupTye1.getProductIdList()) {
					if(!productId.equals("")){
						productIdList.add(productId);
					}
				}
			}
			if(productsOfGroupTye2.getProductIdList() != null){
				for (String productId : productsOfGroupTye2.getProductIdList()) {
					if(!productId.equals("")){
						productIdList.add(productId);
					}
					
				}
			}
			
			userGroupProductsVo.setProductIdList(productIdList);
			
			result.setSuccess(true);
			result.setBody(userGroupProductsVo);
			return result;
		} catch (Exception e) {
			result.setSuccess(false);
			System.out.println(e);
			LOG.error("发生异常{}", new Object[] { e });
			return result;
		}

	}
	

	@Override
	public Boolean isMobikeCity(String userCity) {
		String cityArr = "上海、北京、天津、广州、深圳、成都、宁波、厦门、福州、武汉、昆明、南京、东莞、济南、佛山、珠海、"
				+ "长沙、合肥、汕头、海口、西安、南宁、南昌、德阳、泉州、枝江";
		Boolean flag = false;

		String[] cityList = cityArr.split("、");
		for (String city : cityList) {
			if (userCity.equals(city)) {
				flag = true;
			}
		}
		if (flag) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	@Override
	public String getGroupTye1Code(UserParamReqVo userParamReqVo) {
		//System.out.println(bigDataJoinWxxclProperties.getUrl());
		if(userParamReqVo.getPhone() != null){
			String phoneOperatorData = NetUtil.get(bigDataJoinWxxclProperties.getUrl()+"?phone="+userParamReqVo.getPhone());
			//System.out.println(phoneOperatorData);
			JSONObject phoneOperator = JSONObject.parseObject(phoneOperatorData);
			String phoneOperatorString = phoneOperator.getString("body");
			//System.out.println("phoneOperatorString:"+phoneOperatorString);
			
			String groupData = redisClient.getString(MiniPRedisKeys.getBigdataUserGroupCache(phoneOperatorString));
			if(groupData != null){
				String groupId = JSON.parseObject(groupData, BigdataGroupInfoDO.class).getGroupId();
				return groupId;
			}else{
				return null;
			}
		}else{
			return "unknownPhone";
		}
		
		
		
	}


	@Override
	public String getGroupTye2Code(UserParamReqVo userParamReqVo) {
		
		String isMobikeCityCode = getIsMobikeCityCode(userParamReqVo);
		String genderCode = getGenderCode(userParamReqVo);
		String periodOfTimeCode = getPeriodOfTimeCode(userParamReqVo);
		String ageCode = getAgeCode(userParamReqVo);
		
		String groupTye2Code = null;
		
		if(genderCode.equals("g0")){
			if(isMobikeCityCode.equals("c1")){
				groupTye2Code = isMobikeCityCode+genderCode+periodOfTimeCode;
			}else{
				groupTye2Code = isMobikeCityCode+genderCode;
			}
			
		}else if(genderCode.equals("g2")){
			if(isMobikeCityCode.equals("c1")){
				groupTye2Code = isMobikeCityCode+genderCode+periodOfTimeCode;
			}else{
				groupTye2Code = isMobikeCityCode+genderCode;
			}
		}else{
			groupTye2Code = isMobikeCityCode+genderCode+periodOfTimeCode+ageCode;
		}
		
		String groupData = redisClient.getString(MiniPRedisKeys.getBigdataUserGroupCache(groupTye2Code));
		//System.out.println("groupData:"+groupData);
		if(groupData != null){
			String groupId = JSON.parseObject(groupData, BigdataGroupInfoDO.class).getGroupId();
			return groupId;
		}else{
			return null;
		}
		
		
		
		
	}
	

	

	@Override
	public String getIsMobikeCityCode(UserParamReqVo userParamReqVo) {
		String isMobikeCityCode = null;
		//System.out.println("userParamReqVo.getCity():"+userParamReqVo.getCity());
			if(userParamReqVo.getCity() == null || userParamReqVo.getCity().equals("")) {
				isMobikeCityCode = "c0";
			}else {
				if(isMobikeCity(userParamReqVo.getCity())) {
					isMobikeCityCode = "c1";
				}else {
					isMobikeCityCode = "c2";
				}
			}
			return isMobikeCityCode;
	}

	@Override
	public String getGenderCode(UserParamReqVo userParamReqVo) {
		String genderCode = null;
		if(userParamReqVo.getGender() == null || userParamReqVo.getGender().equals("")) {
			genderCode = "g0";
		}else {
			if(userParamReqVo.getGender().equals("男")) {
				genderCode = "g1";
			}else {
				genderCode = "g2";
			}
		}
		return genderCode;
	}

	@Override
	public String getPeriodOfTimeCode(UserParamReqVo userParamReqVo) {
		String periodOfTimeCode = null;
		String status = redisClient.getString(MiniPRedisKeys.getDateBooleanCache());
		Boolean index = Boolean.parseBoolean(status);
		if (index) {
			//节假日
			periodOfTimeCode = "t2";
		} else {
			//平时
			periodOfTimeCode = "t1";
		}	
		return periodOfTimeCode;
	}

	@Override
	public String getAgeCode(UserParamReqVo userParamReqVo) {
		String ageCode = null;
		if(userParamReqVo.getAge() == null || userParamReqVo.getAge().equals("")) {
			ageCode = "a0";
		}else {
			int ageNumber = Integer.parseInt(userParamReqVo.getAge().substring(0,userParamReqVo.getAge().length()-2));
			if(ageNumber <= 30) {
				ageCode = "a1";
			}else {
				ageCode = "a2";
			}
		}
		return ageCode;
	}

	@Override
	public boolean cacheProductByGroupType() {
		try{
			LOG.info("[千人千面应用，开始执行缓存根据所有用户组id分类缓存产品服务]");
			Map< String, Object> map = new HashMap<>();
			List<BigdataGroupProductConfigurationDO> groupInfoDOs = bigdataGroupProductConfigurationService.selectList(map);
			Map<String,List<BigdataGroupProductConfigurationDO>> indexMap = new HashMap<>();
			for (BigdataGroupProductConfigurationDO bigdataGroupProductConfigurationDO : groupInfoDOs) {
				List<BigdataGroupProductConfigurationDO> list = indexMap.get(bigdataGroupProductConfigurationDO.getGroupId());
				if(list==null){
					list = new ArrayList<>();
					indexMap.put(bigdataGroupProductConfigurationDO.getGroupId(),list);
				}
				list.add(bigdataGroupProductConfigurationDO);
				//redisClient.setString(MiniPRedisKeys.getBigdataUserGroupCache(bigdataGroupProductConfigurationDO.getGroupId()), JSON.toJSONString(bigdataGroupProductConfigurationDO), -1);
			}
			
			Set<String> keys=indexMap.keySet();
			for(String groupId:keys){
				List<BigdataGroupProductConfigurationDO> list = indexMap.get(groupId);
				redisClient.setString(MiniPRedisKeys.getGroupProductConfigurationCacheByGroupId(groupId), JSON.toJSONString(list),86400*30); // 86400*30缓存30天
			}
			return true;
		}catch (Exception e) {
			LOG.error("[千人千面应用，执行缓存所有用户组id发生异常] .....", new Object[] { e });
			return false;
		}
	}

}
