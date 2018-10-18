package com.weein.bigdata.base.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductInfoDO implements Serializable {
    private String id;

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

    private String productIcon;

    /**
     * 产品类型：1、流量 2、话费 3、特惠(先申请) 4、组合 5、会员(需要输入qq号),6、"会员(需要输入手机号)"，7、"卡密"
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
     * 成本价
     */
    private Integer costPrice;

    /**
     * 状态：0、不可用 1、可用
     */
    private Integer productStatus;

    /**
     * 产品标记
     */
    private String productFlag;

    /**
     * 是特惠类型时：1、王卡。。。。
是会员类型时：1、腾讯会员 2、咪咕会员
     */
    private Integer preferentialType;

    /**
     * 运营商：1、移动 2、联通 3、电信。支持多个中间用逗号隔开。(1,2)代表移动联通，(1,2,3)代表移动联通电信，(2)代表联通，依此类推
     */
    private String operatorType;

    /**
     * 商品编号
     */
    private String itemId;

    /**
     * 王卡类型
     */
    private String cardType;

    /**
     * 王卡编码
     */
    private String cardCode;

    /**
     * 王卡渠道号
     */
    private String channelNumber;

    /**
     * 接口类型：接口类型 1001,"公象产品虚拟卡；1002,"公象产品直充"；2001,"百妙话费充值"；2002,"百妙流量充值"；2003,"百妙产品直充"；3002,"网景流量充值"；3001,"网景话费充值"
     */
    private Integer interfaceType;

    private Date createTime;

    /**
     * 库存数量
     */
    private Integer stockNumber;

    private Date updateTime;

    /**
     * 需要号码类型 1:手机号，2:qq号
     */
    private Integer numberType;

    /**
     * 有效期 ：yyyy-MM-dd
     */
    private String expiryDate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon == null ? null : productIcon.trim();
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

    public Integer getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
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

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType == null ? null : operatorType.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode == null ? null : cardCode.trim();
    }

    public String getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(String channelNumber) {
        this.channelNumber = channelNumber == null ? null : channelNumber.trim();
    }

    public Integer getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(Integer interfaceType) {
        this.interfaceType = interfaceType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getNumberType() {
        return numberType;
    }

    public void setNumberType(Integer numberType) {
        this.numberType = numberType;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate == null ? null : expiryDate.trim();
    }
}