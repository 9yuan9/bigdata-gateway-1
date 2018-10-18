package com.weein.bigdata.utils;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class BindingResultLogUtils {
	
	public static String getLog(BindingResult result){
		if(result.hasErrors()){
			StringBuilder stringBuilder = new StringBuilder();
			List<FieldError> list = result.getFieldErrors();
			for(FieldError fieldError:list){
				stringBuilder.append(fieldError.getDefaultMessage());
				stringBuilder.append("；");
			}
			return stringBuilder.toString();
		}
		return "";
	}
}
