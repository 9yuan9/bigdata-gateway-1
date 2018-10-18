package com.weein.bigdata.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.weein.bigdata.base.contants.MiniPConstant;
import com.weein.bigdata.base.contants.MiniPRedisKeys;
import com.weein.bigdata.base.enumtype.ResultCodeEnum;
import com.weein.bigdata.base.session.SessionData;
import com.weein.bigdata.base.vo.UserDataVo;
import com.weein.bigdata.base.vo.result.Result;
import com.weein.bigdata.core.utils.UserDataUtils;
import com.weein.wcommon.cache.RedisClient;

public class InterfaceInterceptor implements HandlerInterceptor {

	private static final Logger LOG = LoggerFactory.getLogger(InterfaceInterceptor.class);
	@Resource
	private RedisClient redisClient;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		/*LOG.info("[请求] url:{},params:{}",new Object[]{request.getRequestURI(),JSON.toJSONString(request.getParameterMap())});
		Object object = request.getParameter("session");
		if(object==null){
			Result<String> result = new Result();
			result.setSuccess(false);
			result.setErrCode(ResultCodeEnum.PARAMS_ERROR.getCode());
			response.getWriter().write(JSON.toJSONString(result));
			return false;
		}
		String sessionDataJson = redisClient.getString(MiniPRedisKeys.getMiniPSessionCacheKey(object+""));
		if(StringUtils.isEmpty(sessionDataJson)){
			if(request.getRequestURI().endsWith("getActivities.do")){
				return true;
			}
			Result<String> result = new Result();
			result.setSuccess(false);
			result.setErrCode(ResultCodeEnum.USER_NOT_LOGIN.getCode());
			response.getWriter().write(JSON.toJSONString(result));
			return false;
		}
		redisClient.expire(MiniPRedisKeys.getMiniPSessionCacheKey(object+""),  (int)MiniPConstant.SESSION_TIME_OUT);
		SessionData sessionData = JSON.parseObject(sessionDataJson, SessionData.class);
		//待完善 查询缓存
		String UserDataVoJson = redisClient.getString(MiniPRedisKeys.getMiniPUserByMiniPOpenidCacheKey(sessionData.getOpenid()));
		if(StringUtils.isNotEmpty(UserDataVoJson)){
			UserDataVo userDataVo = JSON.parseObject(UserDataVoJson, UserDataVo.class);
			if(userDataVo.getMinipUserBindDO()==null){//未绑定
				LOG.error("[{}]用户未绑定",request.getRequestURI() );
				return false;
			}
			UserDataUtils.setUserData(userDataVo.getMinipUserDO(), userDataVo.getMinipUserBindDO(),sessionData);
		}else{
			LOG.error("[{}]用户未绑定 ",request.getRequestURI() );
			return false;
		}*/
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		UserDataUtils.clear();
	}

}
