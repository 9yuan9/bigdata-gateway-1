package com.weein.bigdata.base.entity;

import java.io.Serializable;
import java.util.Date;

public class MyOrderDO implements Serializable {
    private String id;

    /**
     * 用户唯一标识
     */
    private String unionid;

    private String minipOpenId;

    /**
     * 1、手机号 2、qq号....
     */
    private Integer numberType;

    /**
     * 被充号,手机号、qq号、。。。。
     */
    private String number;

    /**
     * 微信订单号
     */
    private String wxOrderId;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 产品id
     */
    private String productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品描述
     */
    private String productContent;

    /**
     * 产品类型：1、流量 2、话费 3、特惠(先申请) 4、组合 5、会员
     */
    private Integer productType;

    /**
     * 售价
     */
    private Integer productPrice;

    /**
     * 原价
     */
    private Integer originalPrice;

    /**
     * 产品标记
     */
    private String productFlag;

    /**
     * 特惠类型:1、王卡。。。。
     */
    private Integer preferentialType;

    /**
     * 日期
     */
    private String orderDate;

    /**
     * 花费金额
     */
    private Integer payFee;

    /**
     * 状态，1,"请求中"   2,"准备请求"  3,"请求中"  4,"请求失败"  5,"请求成功"  6,"请求失败，准备退款" ，9 退款中 10，退款失败 7,"线下退款成功"  8,"其他渠道发卡成功" 11，线上退款成功  12、"回调请求中"  13、"回调准备请求"  14、"回调请求成功"  15、"回调请求失败"
     */
    private Integer orderStatus;

    /**
     * 主键
     */
    private String parentId;

    /**
     * 业务订单号
     */
    private String businessOrderId;

    /**
     * 业务返回订单号
     */
    private String programOrderId;

    /**
     * 业务订单状态
     */
    private String businessStatus;

    /**
     * 微信退款单号
     */
    private String wxRefundNo;

    /**
     * 商户退款单号
     */
    private String outRefundNo;

    /**
     * 退款时间
     */
    private Date refundTime;

    /**
     * 退款金额
     */
    private Integer refundMoney;

    /**
     * 是否可以支付：0、不可 1、可以
     */
    private Integer isPay;

    private String wyAppId;

    private Date createTime;

    private Date updateTime;
    
    private String itemId;
    
    private String couponId;
    
    private String myCouponId;
    
    private Integer couponData;
    
    private Integer costPrice;
    
    private String cam;
    
    /**
     * 接口类型：@see ProductUseEnum
     */
    private Integer interfaceType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getMinipOpenId() {
        return minipOpenId;
    }

    public void setMinipOpenId(String minipOpenId) {
        this.minipOpenId = minipOpenId == null ? null : minipOpenId.trim();
    }

    public Integer getNumberType() {
        return numberType;
    }

    public void setNumberType(Integer numberType) {
        this.numberType = numberType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getWxOrderId() {
        return wxOrderId;
    }

    public void setWxOrderId(String wxOrderId) {
        this.wxOrderId = wxOrderId == null ? null : wxOrderId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent == null ? null : productContent.trim();
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getProductFlag() {
        return productFlag;
    }

    public void setProductFlag(String productFlag) {
        this.productFlag = productFlag == null ? null : productFlag.trim();
    }

    public Integer getPreferentialType() {
        return preferentialType;
    }

    public void setPreferentialType(Integer preferentialType) {
        this.preferentialType = preferentialType;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate == null ? null : orderDate.trim();
    }

    public Integer getPayFee() {
        return payFee;
    }

    public void setPayFee(Integer payFee) {
        this.payFee = payFee;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getBusinessOrderId() {
        return businessOrderId;
    }

    public void setBusinessOrderId(String businessOrderId) {
        this.businessOrderId = businessOrderId == null ? null : businessOrderId.trim();
    }

    public String getProgramOrderId() {
        return programOrderId;
    }

    public void setProgramOrderId(String programOrderId) {
        this.programOrderId = programOrderId == null ? null : programOrderId.trim();
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus == null ? null : businessStatus.trim();
    }

    public String getWxRefundNo() {
        return wxRefundNo;
    }

    public void setWxRefundNo(String wxRefundNo) {
        this.wxRefundNo = wxRefundNo == null ? null : wxRefundNo.trim();
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo == null ? null : outRefundNo.trim();
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public Integer getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(Integer refundMoney) {
        this.refundMoney = refundMoney;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
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
    
    public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId == null ? null : itemId.trim();
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId == null ? null : couponId.trim();
	}

	public String getMyCouponId() {
		return myCouponId;
	}

	public void setMyCouponId(String myCouponId) {
		this.myCouponId = myCouponId == null ? null : myCouponId.trim();
	}

	public Integer getCouponData() {
		return couponData;
	}

	public void setCouponData(Integer couponData) {
		this.couponData = couponData;
	}

	public Integer getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}

	public String getCam() {
		return cam;
	}

	public void setCam(String cam) {
		this.cam = cam == null ? null : cam.trim();
	}

	public Integer getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(Integer interfaceType) {
		this.interfaceType = interfaceType;
	}
	
}