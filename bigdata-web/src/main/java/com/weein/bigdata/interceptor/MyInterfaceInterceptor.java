package com.weein.bigdata.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.weein.bigdata.core.utils.SessionUserDataUtils;
import com.weein.wcommon.cache.RedisClient;


public class MyInterfaceInterceptor implements HandlerInterceptor {

	private static final Logger LOG = LoggerFactory.getLogger(MyInterfaceInterceptor.class);
	@Resource
	private RedisClient redisClient;


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*LOG.info("[请求] url:{},params:{}",
				new Object[] { request.getRequestURI(), JSON.toJSONString(request.getParameterMap()) });
		Object object = request.getParameter("token");
		if (object == null) {
			Result<String> result = new Result();
			result.setSuccess(false);
			result.setErrCode(ResultCodeEnum.PARAMS_ERROR.getCode());
			response.getWriter().write(JSON.toJSONString(result));
			return false;
		}
		String tokenDataJson = redisClient.getString(MiniPRedisKeys.getMySelfMiniPTokenCacheKey(object + ""));
		if (StringUtils.isEmpty(tokenDataJson)) {
			Result<String> result = new Result();
			result.setSuccess(false);
			result.setErrCode(ResultCodeEnum.USER_NOT_LOGIN.getCode());
			response.getWriter().write(JSON.toJSONString(result));
			return false;
		}
		redisClient.expire(MiniPRedisKeys.getMySelfMiniPTokenCacheKey(object + ""),
				(int) MiniPConstant.SESSION_TIME_OUT);
		SessionData sessionData = JSON.parseObject(tokenDataJson, SessionData.class);
		// 待完善 查询缓存
		String UserDataVoJson = redisClient
				.getString(MiniPRedisKeys.getMySelfMiniPUserByUnionidCacheKey(sessionData.getOpenid()));
		Result<String> result = new Result();
		if (StringUtils.isNotEmpty(UserDataVoJson)) {
			MyUserDataVo myUserDataVo = JSON.parseObject(UserDataVoJson, MyUserDataVo.class);
//			if (request.getRequestURI().endsWith("autoBinding.do") || request.getRequestURI().endsWith("sendMSM.do")
//					|| request.getRequestURI().endsWith("binding.do")) {
				List<MinipOpenidDO> minipOpenidDOs = myUserDataVo.getMinipOpenidDOs();
				MinipOpenidDO minipOpenidDO = null;
				if (minipOpenidDOs != null) {
					minipOpenidDO = minipOpenidDOs.stream()
							.filter(w -> w.getMinipOpenId().equals(sessionData.getOpenid())).findFirst().get();
				}
				SessionUserDataUtils.setUserData(myUserDataVo.getMinipUserDO(), minipOpenidDO, minipOpenidDOs,
						myUserDataVo.getMinipUserMyselfBindDO(), myUserDataVo.getMinipThirdPartyBindDO(), sessionData);
				return true;
//			} else {
//				if (myUserDataVo.getMinipUserMyselfBindDO() == null) {// 未绑定
//					LOG.error("[{}]用户未绑定111", request.getRequestURI());
//					result.setMsg("用户未绑定");
//					return false;
//				}
//
//			}
//			List<MinipOpenidDO> minipOpenidDOs = myUserDataVo.getMinipOpenidDOs();
//			MinipOpenidDO minipOpenidDO = null;
//			if (minipOpenidDOs != null) {
//				minipOpenidDO = minipOpenidDOs.stream().filter(w -> w.getMinipOpenId().equals(sessionData.getOpenid()))
//						.findFirst().get();
//			}
//			SessionUserDataUtils.setUserData(myUserDataVo.getMinipUserDO(), minipOpenidDO, minipOpenidDOs,
//					myUserDataVo.getMinipUserMyselfBindDO(), myUserDataVo.getMinipThirdPartyBindDO(), sessionData);
		} else {
			LOG.error("[{}]用户未绑定222", request.getRequestURI());
			result.setMsg("用户未绑定");
			return false;
		}*/
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		SessionUserDataUtils.clear();
	}

}
