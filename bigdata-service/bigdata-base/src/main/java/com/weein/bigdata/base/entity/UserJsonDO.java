package com.weein.bigdata.base.entity;

import java.io.Serializable;
import java.util.List;

import org.json.JSONObject;

public class UserJsonDO implements Serializable{
	/**
	 * 用户列表及模板消息
	 */
	private static final long serialVersionUID = 1L;
	private List<JSONObject> user;
	private String phone;
	private JSONObject msg;
	
	public void setUser(List<JSONObject> user)
	{
		this.user=user;
	}
	public void setPhone(String phone)
	{
		this.phone=phone== null ? null : phone.trim();
	}
	public void setMsg(JSONObject msg)
	{
		this.msg=msg;
	}
	public List<JSONObject> getUser()
	{
		return user;
	}
	public String getPhone()
	{
		return phone;
	}
	public JSONObject getMsg()
	{
		return msg;
	}
	
	

}
