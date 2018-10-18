package com.weein.bigdata.base.enumtype;

public enum ProductEnum {
	PRODUCT_ONE("0","默认产品");
	ProductEnum(String productId,String dsc){
		this.productId = productId;
		this.dsc = dsc;
	}
	
private String productId;
	
	private String dsc;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
}
