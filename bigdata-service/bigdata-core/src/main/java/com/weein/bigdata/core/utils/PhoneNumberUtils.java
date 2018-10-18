package com.weein.bigdata.core.utils;

import java.util.regex.Pattern;

public class PhoneNumberUtils {

	private static Pattern unicomOperatorPattern = Pattern.compile("^((130)|(131)|(132)|(155)|(156)|(145)|(185)|(186)|(176)|(175)|(170)|(171)|(166))\\d{8}$");
	
	public static boolean isUnicomOperator(String phoneNumber){
		return unicomOperatorPattern.matcher(phoneNumber).matches();
	}
	public static void main(String[] args) {
		System.out.println(isUnicomOperator("15738815510"));
	}
}
