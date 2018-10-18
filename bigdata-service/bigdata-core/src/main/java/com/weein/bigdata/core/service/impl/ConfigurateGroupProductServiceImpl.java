package com.weein.bigdata.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.weein.bigdata.base.entity.BigdataGroupInfoDO;
import com.weein.bigdata.base.entity.BigdataGroupProductConfigurationDO;
import com.weein.bigdata.base.entity.ProductInfoDO;
import com.weein.bigdata.base.vo.ProductInfoDOVo;
import com.weein.bigdata.base.vo.result.Result;
import com.weein.bigdata.core.service.ConfigurateGroupProductService;
import com.weein.bigdata.core.service.IBigdataGroupInfoService;
import com.weein.bigdata.core.service.IBigdataGroupProductConfigurationService;
import com.weein.bigdata.core.service.IProductInfoService;
import com.weein.bigdata.core.service.ProductService;
import com.weein.wcommon.utils.UUIDGenerator;
@Service
public class ConfigurateGroupProductServiceImpl implements ConfigurateGroupProductService {
	private static final Logger LOG = LoggerFactory.getLogger(ConfigurateGroupProductService.class);
	@Resource
	private IBigdataGroupInfoService bigdataGroupInfoService;
	@Resource
	private IProductInfoService productInfoService;
	@Resource
	private IBigdataGroupProductConfigurationService bigdataGroupProductConfigurationService;
	@Resource
	private ProductService productService;
	@Override
	public Result<List<BigdataGroupInfoDO>> queryAllGroupByType1() {
		Map<String, Object> map = new HashMap<>();
		Result<List<BigdataGroupInfoDO>> result = new Result<>();

		try {
			map.put("type", 1);
			List<BigdataGroupInfoDO> bigdataGroupInfoDOs = bigdataGroupInfoService.selectList(map);
			result.setSuccess(true);
			result.setBody(bigdataGroupInfoDOs);
			LOG.info("[查询产品id结果]{}", new Object[] { JSON.toJSONString(bigdataGroupInfoDOs) });
		} catch (Exception e) {
			result.setSuccess(false);
			LOG.error("[查询产品id发生异常]{}", new Object[] { e });
		}
		return result;
	}

	@Override
	public Result<List<BigdataGroupInfoDO>> queryAllGroupByType2() {
		Map<String, Object> map = new HashMap<>();
		Result<List<BigdataGroupInfoDO>> result = new Result<>();

		try {
			map.put("type", 2);
			List<BigdataGroupInfoDO> bigdataGroupInfoDOs = bigdataGroupInfoService.selectList(map);
			result.setSuccess(true);
			result.setBody(bigdataGroupInfoDOs);
			LOG.info("[查询产品id结果]{}", new Object[] { JSON.toJSONString(bigdataGroupInfoDOs) });
		} catch (Exception e) {
			result.setSuccess(false);
			LOG.error("[查询产品id发生异常]{}", new Object[] { e });
		}
		return result;
	}

	@Override
	public Result<List<ProductInfoDOVo>> queryAllProductIdByGroupType1(String code, String groupId) {
		Map<String, Object> map = new HashMap<>();
		Result<List<ProductInfoDOVo>> result = new Result<>();
		try {
			map.put("productType", 1);
			List<ProductInfoDO> productInfoDOs1 = productInfoService.selectList(map);
			map.put("productType", 2);
			List<ProductInfoDO> productInfoDOs2 = productInfoService.selectList(map);
			productInfoDOs1.addAll(productInfoDOs2);

			List<ProductInfoDOVo> productInfoDOs = new ArrayList<>();
			for (ProductInfoDO productInfoDO : productInfoDOs1) {
				ProductInfoDOVo productInfoDOVo = new ProductInfoDOVo();
				if (productInfoDO.getProductId().substring(0, 2).equals(code)) {
					productInfoDOVo.setProductInfoDO(productInfoDO);

					BigdataGroupProductConfigurationDO configurationDO = new BigdataGroupProductConfigurationDO();
					configurationDO.setGroupId(groupId);
					configurationDO.setProductId(productInfoDO.getProductId());
					configurationDO = bigdataGroupProductConfigurationService.selectOne(configurationDO);
					if (configurationDO != null) {
						productInfoDOVo.setIndex(1);
					} else {
						productInfoDOVo.setIndex(0);
					}
					productInfoDOs.add(productInfoDOVo);
				}
			}

			result.setBody(productInfoDOs);
			result.setSuccess(true);
			LOG.info("[查询产品id结果]{}", new Object[] { JSON.toJSONString(productInfoDOs) });
			//System.out.println(JSON.toJSONString(productInfoDOs));
		} catch (Exception e) {
			result.setSuccess(false);
			LOG.error("[查询产品id发生异常]{}", new Object[] { e });
		}
		return result;
	}

	@Override
	public Result<List<ProductInfoDOVo>> queryAllProductIdByGroupType2(String groupId) {
		Map<String, Object> map = new HashMap<>();
		Result<List<ProductInfoDOVo>> result = new Result<>();

		try {
			map.put("productType", 3);
			List<ProductInfoDO> productInfoDOs3 = productInfoService.selectList(map);
			map.put("productType", 5);
			List<ProductInfoDO> productInfoDOs5 = productInfoService.selectList(map);
			map.put("productType", 6);
			List<ProductInfoDO> productInfoDOs6 = productInfoService.selectList(map);
			map.put("productType", 7);
			List<ProductInfoDO> productInfoDOs7 = productInfoService.selectList(map);
			productInfoDOs3.addAll(productInfoDOs5);
			productInfoDOs3.addAll(productInfoDOs6);
			productInfoDOs3.addAll(productInfoDOs7);

			List<ProductInfoDOVo> productInfoDOs = new ArrayList<>();
			for (ProductInfoDO productInfoDO : productInfoDOs3) {
				ProductInfoDOVo productInfoDOVo = new ProductInfoDOVo();

				productInfoDOVo.setProductInfoDO(productInfoDO);

				BigdataGroupProductConfigurationDO configurationDO = new BigdataGroupProductConfigurationDO();
				configurationDO.setGroupId(groupId);
				configurationDO.setProductId(productInfoDO.getProductId());
				configurationDO = bigdataGroupProductConfigurationService.selectOne(configurationDO);
				if (configurationDO != null) {
					productInfoDOVo.setIndex(1);
				} else {
					productInfoDOVo.setIndex(0);
				}
				productInfoDOs.add(productInfoDOVo);

			}

			result.setSuccess(true);
			result.setBody(productInfoDOs);
			LOG.info("[查询产品id结果]{}", new Object[] { JSON.toJSONString(productInfoDOs) });
		} catch (Exception e) {
			result.setSuccess(false);
			LOG.error("[查询产品id发生异常]{}", new Object[] { e });
		}
		return result;
	}

	@Override
	public Result<String> addGroupProductConfiguration(String groupId, String list) {
		Result<String> result = new Result<>();
		try {
			String[] productIdList = list.split(",");
			List<String> productIds = new ArrayList<>();
			for (String productId : productIdList) {
				if (!productId.equals("")) {
					productIds.add(productId);
				}
			}

			int number = 0;
			int index = bigdataGroupProductConfigurationService.deleteByGroupId(groupId);
			BigdataGroupProductConfigurationDO recordNull = new BigdataGroupProductConfigurationDO();
			recordNull.setGroupId(groupId);
			recordNull.setProductId("");
			recordNull.setCreateTime(new Date());
			recordNull.setStatus(1);
			recordNull.setId(UUIDGenerator.getUUID());
			bigdataGroupProductConfigurationService.insert(recordNull);
			for (String productId : productIds) {
				/*
				 * BigdataGroupProductConfigurationDO configurationDO = new
				 * BigdataGroupProductConfigurationDO();
				 * configurationDO.setGroupId(groupId);
				 * configurationDO.setProductId(productId); configurationDO =
				 * bigdataGroupProductConfigurationService.selectOne(
				 * configurationDO);
				 */

				BigdataGroupProductConfigurationDO record = new BigdataGroupProductConfigurationDO();
				record.setGroupId(groupId);
				record.setProductId(productId);
				record.setCreateTime(new Date());
				record.setStatus(1);
				record.setId(UUIDGenerator.getUUID());
				index = bigdataGroupProductConfigurationService.insert(record);
				if (index == 1) {
					number += 1;
				}

			}
 
			result.setSuccess(true);
			//System.out.println("用户组配置产品成功" + number + "个产品" + "[" + list + "]");
			result.setBody("用户组配置产品成功" + number + "个产品" + "[" + list + "]");
			productService.cacheProductByGroupType();

			LOG.info("[查询产品id结果]{}", new Object[] { JSON.toJSONString(result) });
		} catch (Exception e) {
			result.setSuccess(false);
			LOG.error("[查询产品id发生异常]{}", new Object[] { e });
		}
		return result;
	}

}
