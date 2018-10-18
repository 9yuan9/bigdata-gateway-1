package com.weein.bigdata.base.vo.signtmp;

import java.util.Map;

public class SignResVo {
	private Integer type;//	int		1:现金红包，2:流量	
	private Integer status;//	int		0:未领取，1:已领取	
	private String reward;//	String		奖励说明 100MB流量，¥0.12	
	private Integer type2;//	int		1:现金红包，2:流量	
	private Integer status2;//	int		0:未领取，1:已领取	
	private String reward2;//	String		奖励说明 100MB流量，¥0.12	
	private Map<String,Object> dataJson;
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public Map<String,Object> getDataJson() {
		return dataJson;
	}
	public void setDataJson(Map<String,Object> dataJson) {
		this.dataJson = dataJson;
	}
	public Integer getType2() {
		return type2;
	}
	public void setType2(Integer type2) {
		this.type2 = type2;
	}
	public Integer getStatus2() {
		return status2;
	}
	public void setStatus2(Integer status2) {
		this.status2 = status2;
	}
	public String getReward2() {
		return reward2;
	}
	public void setReward2(String reward2) {
		this.reward2 = reward2;
	}
	
}
