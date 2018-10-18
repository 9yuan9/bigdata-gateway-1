package com.weein.common.vo;

import java.util.List;

public class ExportListVo {
	List<String> titles;
	
	/*行*/List</*列*/List<Object>> box;

	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}

	public List<List<Object>> getBox() {
		return box;
	}

	public void setBox(List<List<Object>> box) {
		this.box = box;
	}
	
}
