package com.weein.bigdata.base.entity;

import java.io.Serializable;
import java.util.Date;

public class MinipThirdPartyBindDO implements Serializable {
    private String id;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 我方小程序
     */
    private String minipOpenId;
    
    private String unionid;
    
    private String wyAppId;

    /**
     * 第三方小程序
     */
    private String thirdPartyOpenId;

    /**
     * 第三方小程序名称
     */
    private String thirdPartyName;

    /**
     * 绑定时间
     */
    private Date bindTime;

    /**
     * 状态
     */
    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String extend1;

    private String extend2;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMinipOpenId() {
        return minipOpenId;
    }

    public void setMinipOpenId(String minipOpenId) {
        this.minipOpenId = minipOpenId == null ? null : minipOpenId.trim();
    }

    public String getThirdPartyOpenId() {
        return thirdPartyOpenId;
    }

    public void setThirdPartyOpenId(String thirdPartyOpenId) {
        this.thirdPartyOpenId = thirdPartyOpenId == null ? null : thirdPartyOpenId.trim();
    }

    public String getThirdPartyName() {
        return thirdPartyName;
    }

    public void setThirdPartyName(String thirdPartyName) {
        this.thirdPartyName = thirdPartyName == null ? null : thirdPartyName.trim();
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1 == null ? null : extend1.trim();
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2 == null ? null : extend2.trim();
    }

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getWyAppId() {
		return wyAppId;
	}

	public void setWyAppId(String wyAppId) {
		this.wyAppId = wyAppId;
	}
    
    
}