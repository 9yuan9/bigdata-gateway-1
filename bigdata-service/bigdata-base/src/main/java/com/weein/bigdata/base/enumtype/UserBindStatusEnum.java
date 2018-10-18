package com.weein.bigdata.base.enumtype;



public enum UserBindStatusEnum {
	NOT_BOUND(0,"未绑定"),BOUND(1,"已绑定");
	
	UserBindStatusEnum(Integer code,String desc){
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
