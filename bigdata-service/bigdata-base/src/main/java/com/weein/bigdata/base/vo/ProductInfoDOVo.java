package com.weein.bigdata.base.vo;

import java.io.Serializable;

import com.weein.bigdata.base.entity.ProductInfoDO;


public class ProductInfoDOVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int index;

	private ProductInfoDO productInfoDO;
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ProductInfoDO getProductInfoDO() {
		return productInfoDO;
	}

	public void setProductInfoDO(ProductInfoDO productInfoDO) {
		this.productInfoDO = productInfoDO;
	}
	

}
