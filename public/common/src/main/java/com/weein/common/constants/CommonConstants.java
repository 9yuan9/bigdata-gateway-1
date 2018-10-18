package com.weein.common.constants;

/** 
 * 类 名: CommonConstants<br/>
 * 描 述: 公用常量接口<br/>
 * 作 者: 郭昕<br/>
 * 创 建： 2013-8-12<br/>
 *
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public interface CommonConstants {

	String ENCODE_UTF8 = "UTF-8";
	
	/**
	 * 读取字节大小
	 */
	int READ_BYTE_SIZE = 1024;

	/**
	 * 手机号隐藏位数
	 */
	int HIDE_MOBILE_DIGIT = 4;

	/**
	 * 身份证隐藏位数
	 */
	int HIDE_IDCARD_DIGIT = 3;

	/**
	 * 银行卡隐藏位数
	 */
	int HIDE_CARDNO_DIGIT = 8;

	/**
	 * 银行卡两边位数
	 */
	int HIDE_CARDNO_FLANK_DIGIT = 3;
	
	/**
	 * 分割符号-下划线
	 */
	String SPLIT_UNDERLINE = "_";
	
	/**
	 * 分割符号-点
	 */
	String SPLIT_POINT = ".";
	/**
	 * 分割符号-冒号
	 */
	String SPLIT_COLON = "：";
	/**
	 * 分割符号-冒号-半角
	 */
	String SPLIT_COLON_HALF = ":";
	
	/**
	 * java换行符
	 */
	String JAVA_LINE_BREAK = "\n";
	
	/**
	 * html换行符
	 */
	String HTML_LINE_BREAK = "<br/>";
	/**
	 * yyyyMM,长度
	 */
	int  RANDOM_YM_LEN = 6;

	/**
	 * 回车换行
	 */
	String CRLF = "\r\n";
}
