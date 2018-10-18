package com.weein.bigdata.base.vo.encrypted;

/**
 *  {
        "appid":"APPID",
        "timestamp":TIMESTAMP
    }
 *       
 * 类名称：WatermarkVo<br/>
 * 类描述：<br/>
 * 创建人：guoxin<br/>
 * 创建时间：2017年11月27日 下午6:00:46 <br/>
 * @version     
 *
 */
public class WatermarkVo {
	private String appid;
    private Long timestamp;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
    
}
