package com.weein.bigdata.base.enumtype;

public enum MinipUserBindStatusEnum {
	UNBINDED(0,"解绑"),BINDING(1,"绑定");
	MinipUserBindStatusEnum(Integer code,String desc){
		this.code=code;
		this.desc=desc;
	}
	private Integer code;
	
	private String desc;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
