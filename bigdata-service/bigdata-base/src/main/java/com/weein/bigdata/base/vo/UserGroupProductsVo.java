package com.weein.bigdata.base.vo;

import java.util.List;

import com.weein.bigdata.base.entity.BigdataGroupProductConfigurationDO;

public class UserGroupProductsVo {
	private ProductsOfGroupVo groupTye1Products;
	private ProductsOfGroupVo groupTye2Products;
	private List<String> productIdList;


	
	public ProductsOfGroupVo getGroupTye1Products() {
		return groupTye1Products;
	}
	public void setGroupTye1Products(ProductsOfGroupVo groupTye1Products) {
		this.groupTye1Products = groupTye1Products;
	}
	public ProductsOfGroupVo getGroupTye2Products() {
		return groupTye2Products;
	}
	public void setGroupTye2Products(ProductsOfGroupVo groupTye2Products) {
		this.groupTye2Products = groupTye2Products;
	}
	public List<String> getProductIdList() {
		return productIdList;
	}
	public void setProductIdList(List<String> productIdList) {
		this.productIdList = productIdList;
	}
	
	
	
}
