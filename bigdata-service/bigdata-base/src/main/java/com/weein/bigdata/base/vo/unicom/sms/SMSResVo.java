package com.weein.bigdata.base.vo.unicom.sms;

public class SMSResVo {
//	{
//		"resultCode": 0,
//		"resultDescription": "success",
//		"sessionID": "000002011104201711270231498462"
//	}
	
	private Integer resultCode;
	
	private String resultDescription;
	
	private String sessionID;

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	
	
}
