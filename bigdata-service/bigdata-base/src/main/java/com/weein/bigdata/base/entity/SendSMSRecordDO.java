package com.weein.bigdata.base.entity;

import java.io.Serializable;
import java.util.Date;

public class SendSMSRecordDO implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    private String minpOpenid;

    private String ofOpenid;

    private String unionid;

    private String userNumber;

    /**
     * 内容或可以表示内容的json
     */
    private String content;

    /**
     * 类型 1:绑定手机号验证码
     */
    private Integer type;

    /**
     * 状态 0:发送失败，1:发送成功
     */
    private Integer status;

    private String extend1;

    private String extend2;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMinpOpenid() {
        return minpOpenid;
    }

    public void setMinpOpenid(String minpOpenid) {
        this.minpOpenid = minpOpenid == null ? null : minpOpenid.trim();
    }

    public String getOfOpenid() {
        return ofOpenid;
    }

    public void setOfOpenid(String ofOpenid) {
        this.ofOpenid = ofOpenid == null ? null : ofOpenid.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}