package com.weein.bigdata.core.utils;

import com.weein.bigdata.base.entity.MinipUserBindDO;
import com.weein.bigdata.base.entity.MinipUserDO;
import com.weein.bigdata.base.session.SessionData;
import com.weein.bigdata.base.vo.UserDataVo;

public class UserDataUtils {
	
	private static final ThreadLocal<UserDataVo> unicomUser = new ThreadLocal<UserDataVo>();
	
	public static void setUserData(MinipUserDO minipUserDO,MinipUserBindDO minipUserBindDO,SessionData sessionData){
		UserDataVo userDataVo = new UserDataVo();
		userDataVo.setMinipUserBindDO(minipUserBindDO);
		userDataVo.setMinipUserDO(minipUserDO);
		userDataVo.setSessionData(sessionData);
		unicomUser.set(userDataVo);
	}
	
	public static MinipUserDO getMinipUser(){
		UserDataVo userDataVo = unicomUser.get();
		if(userDataVo!=null){
			return userDataVo.getMinipUserDO();
		}else{
			return null;
		}
	}
	public static MinipUserBindDO getMinipUserBind(){
		UserDataVo userDataVo = unicomUser.get();
		if(userDataVo!=null){
			return userDataVo.getMinipUserBindDO();
		}else{
			return null;
		}
	}
	
	public static SessionData getSessionData(){
		UserDataVo userDataVo = unicomUser.get();
		if(userDataVo!=null){
			return userDataVo.getSessionData();
		}else{
			return null;
		}
	}
	
	public static void clear() {
		unicomUser.remove();
	}
}
