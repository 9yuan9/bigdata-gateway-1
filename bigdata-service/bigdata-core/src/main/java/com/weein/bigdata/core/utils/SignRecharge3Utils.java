package com.weein.bigdata.core.utils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.weein.wcommon.utils.MD5;

public class SignRecharge3Utils {
	public static String getSign(Object o, String platformid,String security,boolean isOnlyValue) {
		TreeMap<String,Object> treeMap = new TreeMap<String,Object>();
		Class cls = o.getClass();
		try {
			while (cls != Object.class) {
				Field[] fields = cls.getDeclaredFields();
				for (Field f : fields) {
					f.setAccessible(true);
					if (f.get(o) != null && f.get(o) != "") {
						treeMap.put(f.getName(), f.get(o));
					}
				}
				cls = cls.getSuperclass();
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(platformid!=null)
		treeMap.put("platformid", platformid);
		if(security!=null)
		treeMap.put("security", security);
		StringBuilder sb = new StringBuilder();
		Set<String> keys = treeMap.keySet();
		for(String key:keys) {
			if(isOnlyValue)
				sb.append(key).append("=").append(treeMap.get(key)+"").append("&");
			else
				sb.append(treeMap.get(key)+"");
		}
		if(sb.length()>0) {
			if(isOnlyValue)
			sb.deleteCharAt(sb.length()-1);
		}
		return MD5.crypto(sb.toString());
	}
}
