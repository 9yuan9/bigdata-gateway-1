package com.weein.bigdata.base.vo.sms;

public class SmsSingleSenderResult{

    private int result;
    private String errMsg;
    private String ext;
    private String sid;
    private int fee;

    public SmsSingleSenderResult() {
        this.errMsg = "";
        this.ext = "";
        this.sid = "";
        this.fee = 0;
    }

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
    
    
}
