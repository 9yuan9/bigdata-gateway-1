package com.weein.bigdata.base.entity;

import java.io.Serializable;
import java.util.Date;

public class BigdataGroupInfoDO implements Serializable {
    private String id;

    /**
     * 字母+数字
     */
    private String groupId;

    /**
     * 1:省份运营商、2:特征
     */
    private String type;

    /**
     *  0:不可用 1:可用 
     */
    private Integer status;

    /**
     * 特征：女+北京+节假日
 运营商：北京移动

     */
    private String description;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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