package com.weein.bigdata.base.entity;

import java.io.Serializable;
import java.util.Date;

public class WxPhoneNumberRecordDO implements Serializable {
    private String id;

    private String minipOpenId;

    private String unionid;

    private String phoneNumber;

    private String purePhoneNumber;

    private String countryCode;

    private String wyAppid;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMinipOpenId() {
        return minipOpenId;
    }

    public void setMinipOpenId(String minipOpenId) {
        this.minipOpenId = minipOpenId == null ? null : minipOpenId.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getPurePhoneNumber() {
        return purePhoneNumber;
    }

    public void setPurePhoneNumber(String purePhoneNumber) {
        this.purePhoneNumber = purePhoneNumber == null ? null : purePhoneNumber.trim();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public String getWyAppid() {
        return wyAppid;
    }

    public void setWyAppid(String wyAppid) {
        this.wyAppid = wyAppid == null ? null : wyAppid.trim();
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
}