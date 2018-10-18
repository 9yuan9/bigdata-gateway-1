package com.weein.bigdata.base.entity;

import java.io.Serializable;
import java.util.Date;

public class UserFieldDO implements Serializable {
    private String id;

    /**
     * 手机号
     */
    private String phone;

    private String openId;

    /**
     * 自己小程序openid
     */
    private String minipOpenId;

    private Date createTime;

    private Date updateTime;

    private String noneField;

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getMinipOpenId() {
        return minipOpenId;
    }

    public void setMinipOpenId(String minipOpenId) {
        this.minipOpenId = minipOpenId == null ? null : minipOpenId.trim();
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

    public String getNoneField() {
        return noneField;
    }

    public void setNoneField(String noneField) {
        this.noneField = noneField == null ? null : noneField.trim();
    }
}