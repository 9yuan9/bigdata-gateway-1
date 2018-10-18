package com.weein.bigdata.base.entity;

import java.io.Serializable;
import java.util.Date;

public class CouponInfoDO implements Serializable {
    private String id;

    /**
     * 优惠券id
     */
    private String couponId;

    /**
     * 所对应的微信卡券id
     */
    private String cardId;

    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * 说明
     */
    private String couponDesc;

    /**
     * 图片地址
     */
    private String couponIcon;

    /**
     * 优惠券类型：1、话费 2、流量。。。
     */
    private Integer couponType;

    /**
     * 微信卡券类型：1:代金券；2:折扣券；3:兑换券；4:优惠券
     */
    private Integer cardtype;

    /**
     * 优惠券面值
     */
    private Integer couponData;

    /**
     * 是否可用：0、不可用 1、可用
     */
    private Integer couponStatus;

    /**
     * 使用门槛
     */
    private Integer couponThreshold;

    /**
     * 有效日期
     */
    private Integer effectiveDate;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    public String getCouponDesc() {
        return couponDesc;
    }

    public void setCouponDesc(String couponDesc) {
        this.couponDesc = couponDesc == null ? null : couponDesc.trim();
    }

    public String getCouponIcon() {
        return couponIcon;
    }

    public void setCouponIcon(String couponIcon) {
        this.couponIcon = couponIcon == null ? null : couponIcon.trim();
    }

    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }

    public Integer getCardtype() {
        return cardtype;
    }

    public void setCardtype(Integer cardtype) {
        this.cardtype = cardtype;
    }

    public Integer getCouponData() {
        return couponData;
    }

    public void setCouponData(Integer couponData) {
        this.couponData = couponData;
    }

    public Integer getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
    }

    public Integer getCouponThreshold() {
        return couponThreshold;
    }

    public void setCouponThreshold(Integer couponThreshold) {
        this.couponThreshold = couponThreshold;
    }

    public Integer getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Integer effectiveDate) {
        this.effectiveDate = effectiveDate;
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