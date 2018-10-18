package com.weein.common.base;

import java.io.Serializable;
import java.util.List;

public class ListData<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3486728556834057241L;

	private List<T> data;
	
	private Page page;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	
}
