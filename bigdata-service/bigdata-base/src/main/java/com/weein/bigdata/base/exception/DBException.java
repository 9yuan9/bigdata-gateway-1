package com.weein.bigdata.base.exception;

import com.weein.bigdata.base.enumtype.ResultCodeEnum;

public class DBException extends Exception{

	/**    
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）    
	 *    
	 * @since Ver 1.1    
	 */    
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	private String message;
	
	public DBException(){
		
	}
	
	public DBException(String code,String message){
		this.code=code;
		this.message=message;
	}
	
	public DBException(ResultCodeEnum resultCodeEnum){
		this.code=resultCodeEnum.getCode();
		this.message=resultCodeEnum.getMsg();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
