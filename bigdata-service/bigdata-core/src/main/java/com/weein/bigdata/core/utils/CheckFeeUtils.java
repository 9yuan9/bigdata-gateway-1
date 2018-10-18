package com.weein.bigdata.core.utils;

public class CheckFeeUtils {

	public static String check(String str){
		String flag = "";
		if("360000".equals(str))
			flag = "充值成功！";
		else
			flag = "充值失败！";
		return flag;
	}
}
