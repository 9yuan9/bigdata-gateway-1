package com.weein.bigdata.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weein.bigdata.base.vo.result.Result;
import com.weein.wcommon.utils.DateUtils;
import com.weein.wcommon.utils.MD5;


@RestController
@RequestMapping("/v1/api")
public class ApiController {

	private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);
	
	
	@RequestMapping(value = "/sendRecord.do", method = RequestMethod.POST)
	public Result<String> getBalances(HttpServletRequest request, HttpServletResponse response, String pass,String date) {
		Result<String> result = new Result<String>();
		return result;
	}
	
	
}
