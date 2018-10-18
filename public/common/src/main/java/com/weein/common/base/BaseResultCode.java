package com.weein.common.base;

/**
 * 类 名: BaseResultCodeEnum<br/>
 * 描 述: 枚举错误码抽象接口<br/>
 * 作 者: 郭昕<br/>
 * 创 建： 2014-9-3<br/>
 * 
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public interface BaseResultCode {
	
	/**
	 * 
	 * 描 述：错误码<br/>
	 * 作 者：郭昕<br/>
	 * 历 史: (版本) 作者 时间 注释 <br/>
	 * @return
	 */
	public String code();
	
	/**
	 * 
	 * 描 述：错误描述信息<br/>
	 * 作 者：郭昕<br/>
	 * 历 史: (版本) 作者 时间 注释 <br/>
	 * @return
	 */
	public String desc();
}
