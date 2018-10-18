package com.weein.bigdata.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.weein.bigdata.base.exception.DBException;
import com.weein.wcommon.utils.JsonUtil;

@Aspect
@Configuration
public class DevApiLogHandler {

	private static final Logger LOG = LoggerFactory
			.getLogger(DevApiLogHandler.class);
	
	private final static PropertyFilter profilter = new PropertyFilter(){  
		  
        @Override  
        public boolean apply(Object object, String name, Object value) {  
            if(name.equalsIgnoreCase("noneField")){  
                //false表示last字段将被排除在外  
                return false;  
            }  
            return true;  
        }  
          
    };  
	// 定义切点Pointcut
    @Pointcut("execution(* com.weein.bigdata.controller.*.*(..))")
    public void excudeService() {
    }
	
	@Around("excudeService()")
	public Object filterMethod(ProceedingJoinPoint pjp) throws Throwable {
		Signature signature = pjp.getSignature();
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		
		long start = System.currentTimeMillis();
		
		Map<String, String[]> map = httpServletRequest.getParameterMap();
		try {
			Object obj = pjp.proceed();
			returnHandler(httpServletRequest!=null?httpServletRequest.getRequestURI():signature.toShortString(),map, obj,start);
//			returnHandler(signature.toShortString(),map, obj,start);
			return obj;
		} catch (Exception e) {
			throwHandler(httpServletRequest!=null?httpServletRequest.getRequestURI():signature.toShortString(),map, e,start);
//			throwHandler(signature.toShortString(),map, e,start);
			throw e;
		}

	}

	public void returnHandler(String methodName,Map<String, String[]> paramMap, Object returnValue,long start)
			throws Throwable {
		long handlerTime = System.currentTimeMillis()-start;
		String param = JSON.toJSONString(paramMap,profilter);
//		String returnJson = "";
		String returnJson = JsonUtil.obj2Json(returnValue);
//		if(handlerTime>1000){//大于1秒，则输出详细参数
//			param = JsonUtil.map2Json(paramMap);
//			if(returnValue instanceof Result){
//				returnJson = JsonUtil.obj2Json(returnValue);
//			}
//			if(StringUtils.isNotEmpty(returnJson)){
				LOG.info("[{}] 执行完成,使用时间:{}ms,param:{},return:{}",new Object[]{methodName,System.currentTimeMillis()-start,param,returnJson});
//			}else{
//				LOG.info("[{}] 执行完成,使用时间:{}ms,param:{}",new Object[]{methodName,System.currentTimeMillis()-start,param});
//			}
//		}else{
//			LOG.info("[{}] 执行完成,使用时间:{}ms",new Object[]{methodName,System.currentTimeMillis()-start});
//		}
	}

	public void throwHandler(String methodName,Map<String, String[]> paramMap, Throwable e,long start) {
		String param = JSON.toJSONString(paramMap,profilter);
		LOG.error("[{}] 执行异常,使用时间:{}ms,param:{},throwable:{}",new Object[]{methodName,System.currentTimeMillis()-start,param,(e  instanceof DBException)?e.toString():e});
	}

}
