package com.weein.bigdata.base.entity;

import java.io.Serializable;
import java.util.Date;

public class ActivityShowDO implements Serializable {
    private String id;

    /**
     * 0：不展示；1：展示
     */
    private Integer status;

    private Integer activty;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getActivty() {
        return activty;
    }

    public void setActivty(Integer activty) {
        this.activty = activty;
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