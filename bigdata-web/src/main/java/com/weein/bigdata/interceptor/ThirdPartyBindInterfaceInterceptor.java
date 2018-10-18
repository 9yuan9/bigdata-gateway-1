package com.weein.bigdata.interceptor;

import java.util.List;

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
import com.weein.bigdata.base.entity.MinipOpenidDO;
import com.weein.bigdata.base.enumtype.ResultCodeEnum;
import com.weein.bigdata.base.session.SessionData;
import com.weein.bigdata.base.vo.MyUserDataVo;
import com.weein.bigdata.base.vo.result.Result;
import com.weein.bigdata.core.utils.SessionUserDataUtils;
import com.weein.wcommon.cache.RedisClient;

public class ThirdPartyBindInterfaceInterceptor implements HandlerInterceptor {

	private static final Logger LOG = LoggerFactory.getLogger(ThirdPartyBindInterfaceInterceptor.class);

	@Resource
	private RedisClient redisClient;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*LOG.info("[第三方绑定请求] url:{},params:{}",
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
			if (request.getRequestURI().endsWith("thirdPartyBinding.do")) {
				List<MinipOpenidDO> minipOpenidDOs = myUserDataVo.getMinipOpenidDOs();
				MinipOpenidDO minipOpenidDO = null;
				if (minipOpenidDOs != null) {
					minipOpenidDO = minipOpenidDOs.stream()
							.filter(w -> w.getMinipOpenId().equals(sessionData.getOpenid())).findFirst().get();
				}
				SessionUserDataUtils.setUserData(myUserDataVo.getMinipUserDO(), minipOpenidDO, minipOpenidDOs,
						myUserDataVo.getMinipUserMyselfBindDO(), myUserDataVo.getMinipThirdPartyBindDO(), sessionData);
				return true;
			} else {
				if (myUserDataVo.getMinipThirdPartyBindDO() == null) {
					LOG.error("[第三方绑定，请求]用户未绑定,不存在MinipThirdPartyBindDO，{}", request.getRequestURI());
					result.setMsg("用户未绑定");
					return false;
				}

			}
			List<MinipOpenidDO> minipOpenidDOs = myUserDataVo.getMinipOpenidDOs();
			MinipOpenidDO minipOpenidDO = null;
			if (minipOpenidDOs != null) {
				minipOpenidDO = minipOpenidDOs.stream().filter(w -> w.getMinipOpenId().equals(sessionData.getOpenid()))
						.findFirst().get();
			}
			SessionUserDataUtils.setUserData(myUserDataVo.getMinipUserDO(), minipOpenidDO, minipOpenidDOs,
					myUserDataVo.getMinipUserMyselfBindDO(), myUserDataVo.getMinipThirdPartyBindDO(), sessionData);
		} else {
			LOG.error("[{}]用户未绑定，不存在UserDataVoJson", request.getRequestURI());
			result.setMsg("用户未绑定");
			return false;
		}*/
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
