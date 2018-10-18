package com.weein.bigdata.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "tencent.sms.api")
public class TencentSMSApiProperties {

	private String url;
	private Integer templetid;
	private Integer appid;
	private String appkey;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getTempletid() {
		return templetid;
	}
	public void setTempletid(Integer templetid) {
		this.templetid = templetid;
	}
	public Integer getAppid() {
		return appid;
	}
	public void setAppid(Integer appid) {
		this.appid = appid;
	}
	public String getAppkey() {
		return appkey;
	}
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	
	

}
