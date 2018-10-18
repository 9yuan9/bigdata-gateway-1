package com.weein.bigdata.core.utils;

import com.alibaba.fastjson.JSONObject;

public class MessageTemplateUtils {
	public static JSONObject getMessageTemplateOfExpire (String touser,
			String template_id,String page,String keyword1,
			String keyword2,String keyword3,String color,String emphasis_keyword) {
		
		JSONObject object = new JSONObject();
		JSONObject object1 = new JSONObject();
		JSONObject object11 = new JSONObject();
		object11.put("value", keyword1);
		object11.put("color", color);
		object1.put("keyword1", object11);
		
		
		JSONObject object22 = new JSONObject();
		object22.put("value", keyword2);
		object22.put("color", color);
		object1.put("keyword2", object22);
		
		JSONObject object33 = new JSONObject();
		object33.put("value", keyword3);
		object33.put("color", color);
		object1.put("keyword3", object33);
		
		object.put("touser", touser);
		object.put("template_id", template_id);
		object.put("page", page);
		object.put("data", object1);
		object.put("emphasis_keyword", emphasis_keyword);
		object.put("messageType", "productExpirationReminder");
		return object;
	}
	
	public static JSONObject getMessageTemplateOfRecommended (String touser,
			String template_id,String page,String keyword1,
			String keyword2,String color,String emphasis_keyword) {
		
		JSONObject object = new JSONObject();
		JSONObject object1 = new JSONObject();
		JSONObject object11 = new JSONObject();
		object11.put("value", keyword1);
		object11.put("color", color);
		object1.put("keyword1", object11);
		
		
		JSONObject object22 = new JSONObject();
		object22.put("value", keyword2);
		object22.put("color", color);
		object1.put("keyword2", object22);
		
		
		object.put("touser", touser);
		object.put("template_id", template_id);
		object.put("page", page);
		object.put("data", object1);
		object.put("emphasis_keyword", emphasis_keyword);
		object.put("messageType", "productRecommendations");
		return object;
	}
}
