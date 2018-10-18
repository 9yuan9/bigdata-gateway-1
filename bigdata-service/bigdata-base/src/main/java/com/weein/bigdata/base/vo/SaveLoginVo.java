package com.weein.bigdata.base.vo;

import java.util.Date;

import com.weein.mp.vo.minip.login.LoginRes;


public class SaveLoginVo {
	private Date time;
	
	private LoginRes loginRes;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public LoginRes getLoginRes() {
		return loginRes;
	}

	public void setLoginRes(LoginRes loginRes) {
		this.loginRes = loginRes;
	}
	
	
}
