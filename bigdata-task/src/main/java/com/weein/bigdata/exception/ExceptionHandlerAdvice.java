package com.weein.bigdata.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weein.bigdata.base.vo.result.Result;


@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);
	
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
    	LOG.error("[异常处理] error:{}",e.toString());
    	Result<String> result = new Result<String>();
		result.setErrCode("500");
        return result;
    }

}