package com.weein.bigdata.base.vo.encrypted;

/**
 * {
    "phoneNumber": "13580006666",  
    "purePhoneNumber": "13580006666", 
    "countryCode": "86",
    "watermark":
    {
        "appid":"APPID",
        "timestamp":TIMESTAMP
    }
}
 *       
 * 类名称：PhoneNumberDataVo<br/>
 * 类描述：<br/>
 * 创建人：guoxin<br/>
 * 创建时间：2017年11月27日 下午6:00:10 <br/>
 * @version     
 *
 */
public class PhoneNumberDataVo {
	/**
	 * 用户绑定的手机号（国外手机号会有区号）
	 */
	private String phoneNumber;  
	/**
	 * 没有区号的手机号
	 */
    private String purePhoneNumber; 
    /**
     * 区号
     */
    private String countryCode;
    private WatermarkVo watermark;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPurePhoneNumber() {
		return purePhoneNumber;
	}
	public void setPurePhoneNumber(String purePhoneNumber) {
		this.purePhoneNumber = purePhoneNumber;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public WatermarkVo getWatermark() {
		return watermark;
	}
	public void setWatermark(WatermarkVo watermark) {
		this.watermark = watermark;
	}
    
}
