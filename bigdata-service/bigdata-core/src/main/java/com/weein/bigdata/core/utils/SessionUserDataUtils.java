package com.weein.bigdata.core.utils;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.weein.bigdata.base.entity.MinipOpenidDO;
import com.weein.bigdata.base.entity.MinipThirdPartyBindDO;
import com.weein.bigdata.base.entity.MinipUserDO;
import com.weein.bigdata.base.entity.MinipUserMyselfBindDO;
import com.weein.bigdata.base.session.SessionData;
import com.weein.bigdata.base.vo.MyUserDataVo;
import com.weein.bigdata.base.vo.SessionUserDataVo;

public class SessionUserDataUtils {
	
	private static final ThreadLocal<SessionUserDataVo> minipUser = new ThreadLocal<SessionUserDataVo>();
	
	public static void setUserData(MinipUserDO minipUserDO,MinipOpenidDO minipOpenidDO,List<MinipOpenidDO> minipOpenidDOs,MinipUserMyselfBindDO minipUserMyselfBindDO,MinipThirdPartyBindDO minipThirdPartyBindDO,SessionData sessionData){
		SessionUserDataVo sessionUserDataVo = new SessionUserDataVo();
		sessionUserDataVo.setMinipOpenidDO(minipOpenidDO);
		sessionUserDataVo.setMinipOpenidDOs(minipOpenidDOs);
		sessionUserDataVo.setMinipUserMyselfBindDO(minipUserMyselfBindDO);
		sessionUserDataVo.setMinipUserDO(minipUserDO);
		sessionUserDataVo.setMinipThirdPartyBindDO(minipThirdPartyBindDO);
		sessionUserDataVo.setSessionData(sessionData);
		minipUser.set(sessionUserDataVo);
	}
	
	public static MinipOpenidDO getMinipOpenidDO() {
		SessionUserDataVo sessionUserDataVo = minipUser.get();
		if(sessionUserDataVo!=null){
			return sessionUserDataVo.getMinipOpenidDO();
		}else{
			return null;
		}
	}
	
	public static List<MinipOpenidDO> getMinipOpenidDOs() {
		SessionUserDataVo sessionUserDataVo = minipUser.get();
		if(sessionUserDataVo!=null){
			return sessionUserDataVo.getMinipOpenidDOs();
		}else{
			return null;
		}
	}
	
	public static MinipUserDO getMinipUser(){
		SessionUserDataVo sessionUserDataVo = minipUser.get();
		if(sessionUserDataVo!=null){
			return sessionUserDataVo.getMinipUserDO();
		}else{
			return null;
		}
	}
	public static MinipUserMyselfBindDO getMinipUserBind(){
		SessionUserDataVo sessionUserDataVo = minipUser.get();
		if(sessionUserDataVo!=null){
			return sessionUserDataVo.getMinipUserMyselfBindDO();
		}else{
			return null;
		}
	}
	
	public static MinipThirdPartyBindDO getMinipThirdPartyBind(){
		SessionUserDataVo sessionUserDataVo = minipUser.get();
		if(sessionUserDataVo!=null){
			return sessionUserDataVo.getMinipThirdPartyBindDO();
		}else{
			return null;
		}
	}
	
	public static SessionData getSessionData(){
		SessionUserDataVo sessionUserDataVo = minipUser.get();
		if(sessionUserDataVo!=null){
			return sessionUserDataVo.getSessionData();
		}else{
			return null;
		}
	}
	
	public static MyUserDataVo cloneMyUserDataVo() {
		SessionUserDataVo sessionUserDataVo = minipUser.get();
		if(sessionUserDataVo!=null){
			MyUserDataVo myUserDataVo = new MyUserDataVo();
			BeanUtils.copyProperties(sessionUserDataVo, myUserDataVo);
			return myUserDataVo;
		}else{
			return null;
		}
		
	}
	
	public static void clear() {
		minipUser.remove();
	}
}
