package com.weein.bigdata.base.entity;

import java.io.Serializable;
import java.util.Date;

public class MinipUserMyselfBindRecordDO implements Serializable {
	 private String id;
	 
    private String bindId;

    private String userId;

    private Date bindTime;

    private String nickname;

    private String minipOpenId;
    
    private String unionid;
    
    private String wyAppId;
    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private Integer sex;

    private String email;

    private String birthday;

    private String phone;

    /**
     * 状态 0:解绑，1:绑定
     */
    private Integer status;

    private Date unbindTime;

    private Date createTime;

    private Date updateTime;

    private String extend1;

    private String extend2;

    private String extend3;

    private static final long serialVersionUID = 1L;

    
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMinipOpenId() {
		return minipOpenId;
	}

	public void setMinipOpenId(String minipOpenId) {
		this.minipOpenId = minipOpenId;
	}

	public String getBindId() {
        return bindId;
    }

    public void setBindId(String bindId) {
        this.bindId = bindId == null ? null : bindId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUnbindTime() {
        return unbindTime;
    }

    public void setUnbindTime(Date unbindTime) {
        this.unbindTime = unbindTime;
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

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3 == null ? null : extend3.trim();
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