package com.weein.bigdata.base.vo;

import java.util.List;

public class ProductsOfGroupVo {

	private String groupId;
	private List<String> productIdList;
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public List<String> getProductIdList() {
		return productIdList;
	}
	public void setProductIdList(List<String> productIdList) {
		this.productIdList = productIdList;
	}
	
}
