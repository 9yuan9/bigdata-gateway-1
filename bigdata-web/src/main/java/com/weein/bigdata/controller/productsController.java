package com.weein.bigdata.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.weein.bigdata.base.entity.BigdataGroupInfoDO;
import com.weein.bigdata.base.vo.ProductInfoDOVo;
import com.weein.bigdata.base.vo.UserGroupProductsVo;
import com.weein.bigdata.base.vo.UserParamReqVo;
import com.weein.bigdata.base.vo.result.Result;
import com.weein.bigdata.core.service.ConfigurateGroupProductService;
import com.weein.bigdata.core.service.ProductService;

@RestController
@RequestMapping("/v1/productFromBigdata")
public class productsController {
	private static final Logger LOG = LoggerFactory.getLogger(productsController.class);
	@Resource
	private ProductService productService;
	
	@Resource
	private ConfigurateGroupProductService configurateGroupProductService;

	@RequestMapping(value = "/getProductIds.do", method = RequestMethod.GET)
	public Result<UserGroupProductsVo> getProductShow(HttpServletRequest request, HttpServletResponse response,
			UserParamReqVo userParamReqVo) throws Exception {
		LOG.info("[收到请求参数]{}", new Object[]{JSON.toJSONString(userParamReqVo)});
		Result<UserGroupProductsVo> result = null;
		try {
			result = productService.getProductIdList(userParamReqVo);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		
		
	}

	@RequestMapping(value = "/queryAllGroupByType1.do", method = RequestMethod.GET)
	public Result<List<BigdataGroupInfoDO>> queryAllGroupByType1(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return configurateGroupProductService.queryAllGroupByType1();
	}

	@RequestMapping(value = "/queryAllGroupByType2.do", method = RequestMethod.GET)
	public Result<List<BigdataGroupInfoDO>> queryAllGroupByType2(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return configurateGroupProductService.queryAllGroupByType2();
	}

	@RequestMapping(value = "/queryAllProductIdByGroupType1.do", method = RequestMethod.GET)
	public Result<List<ProductInfoDOVo>> queryAllProductIdByGroupType1(HttpServletRequest request,
			HttpServletResponse response, String code, String groupId) throws IOException {
		return configurateGroupProductService.queryAllProductIdByGroupType1(code, groupId);
	}

	@RequestMapping(value = "/queryAllProductIdByGroupType2.do", method = RequestMethod.GET)
	public Result<List<ProductInfoDOVo>> queryAllProductIdByGroupType2(HttpServletRequest request,
			HttpServletResponse response, String groupId) throws IOException {
		return configurateGroupProductService.queryAllProductIdByGroupType2(groupId);
	}

	@RequestMapping(value = "/groupProductConfiguration.do", method = RequestMethod.GET)
	public Result<String> addGroupProductConfiguration(HttpServletRequest request, HttpServletResponse response,
			String groupId, String list) throws IOException {
		return configurateGroupProductService.addGroupProductConfiguration(groupId, list);
	}

}
