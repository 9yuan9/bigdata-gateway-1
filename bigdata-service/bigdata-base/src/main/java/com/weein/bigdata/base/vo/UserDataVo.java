package com.weein.bigdata.base.vo;

import com.weein.bigdata.base.entity.MinipUserBindDO;
import com.weein.bigdata.base.entity.MinipUserDO;
import com.weein.bigdata.base.session.SessionData;

public class UserDataVo {
	
	private MinipUserDO minipUserDO;
	
	private MinipUserBindDO minipUserBindDO;
	
	private SessionData sessionData;

	
	public MinipUserDO getMinipUserDO() {
		return minipUserDO;
	}

	public void setMinipUserDO(MinipUserDO minipUserDO) {
		this.minipUserDO = minipUserDO;
	}

	public MinipUserBindDO getMinipUserBindDO() {
		return minipUserBindDO;
	}

	public void setMinipUserBindDO(MinipUserBindDO minipUserBindDO) {
		this.minipUserBindDO = minipUserBindDO;
	}

	public SessionData getSessionData() {
		return sessionData;
	}

	public void setSessionData(SessionData sessionData) {
		this.sessionData = sessionData;
	}
	
	
}
