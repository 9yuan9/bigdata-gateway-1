package com.weein.bigdata.base.entity;

import java.io.Serializable;
import java.util.Date;

public class MinipOpenidDO implements Serializable {
    private String id;

    private String minipOpenId;

    private String unionId;

    private String wyAppId;

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

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    public String getWyAppId() {
        return wyAppId;
    }

    public void setWyAppId(String wyAppId) {
        this.wyAppId = wyAppId == null ? null : wyAppId.trim();
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