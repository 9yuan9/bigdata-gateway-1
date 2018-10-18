package com.weein.bigdata.log;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Aspect
@Component
public class WorkderListenerAop  implements Ordered {

	private final String DEFAULT_SOURCE_NAME = "default";

	private final static Logger LOG = LoggerFactory.getLogger(WorkderListenerAop.class);

	// @Autowired
	// private DbSelectRuleConfig dbSelectRuleConfig;

	@Override
	public int getOrder() {
		return 1;
	}

	// 拦截所有的service操作
	@Pointcut("@annotation(org.springframework.scheduling.annotation.Scheduled)")
	public void workerMethod() {
	}

	/**
	 * mybatis生成的daoMapper类是com.sun.Proxy$代理类，注解被擦除
	 * 所以dao的aop切面在应用程序自己编写Pointcut->daoMethod()
	 */
	@Around("workerMethod() ")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		
		Method method = signature.getMethod();
		long start = System.currentTimeMillis();
		try {
			Object result = pjp.proceed();
			LOG.info("[定时任务] 执行完成 use:{}ms,method:{}",new Object[] {(System.currentTimeMillis()-start),pjp.getTarget().getClass()+"."+method.getName()});
			return result;
		}catch(Exception e) {
			LOG.error("[定时任务] 执行完成 use:{}ms,method:{}",new Object[] {(System.currentTimeMillis()-start),pjp.getTarget().getClass()+"."+method.getName(),e});
			throw e;
		}
		
	}
}
