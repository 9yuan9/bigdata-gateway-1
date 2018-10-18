package com.weein.bigdata.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "recharge3")
public class Recharge3Properties {
	private String rechargeBaseUrl;
	private String rechargeNotifyUrl;
	private String platformid;
	private String security;
	private String rechargeAction;

	public String getRechargeBaseUrl() {
		return rechargeBaseUrl;
	}

	public void setRechargeBaseUrl(String rechargeBaseUrl) {
		this.rechargeBaseUrl = rechargeBaseUrl;
	}

	public String getPlatformid() {
		return platformid;
	}

	public void setPlatformid(String platformid) {
		this.platformid = platformid;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getRechargeAction() {
		return rechargeAction;
	}

	public void setRechargeAction(String rechargeAction) {
		this.rechargeAction = rechargeAction;
	}

	public String getRechargeNotifyUrl() {
		return rechargeNotifyUrl;
	}

	public void setRechargeNotifyUrl(String rechargeNotifyUrl) {
		this.rechargeNotifyUrl = rechargeNotifyUrl;
	}

}
