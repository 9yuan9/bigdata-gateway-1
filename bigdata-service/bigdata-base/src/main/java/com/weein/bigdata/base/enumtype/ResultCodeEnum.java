package com.weein.bigdata.base.enumtype;

public enum ResultCodeEnum {
	SUCCESS("0","请求成功"),
	PARAMS_ERROR("99999","参数错误"),
	TOO_MUCH_ACTION("88888","操作过于频繁"),
	USER_NOT_LOGIN("10001","用户未登录"),
	USERNUMBER_VALID_CODE_ERROR("10002","验证码错误"),
	GET_USERNUMBER_ERROR("10003","获取用户信息错误"),
	USER_BIND_PHONE_NOT_FOUND_ERROR("10004","用户绑定关系不存在"),
	USER_BIND_PHONE_TIMEOUT_ERROR("10005","用户绑定手机号超时"),
	DB_ERROR("10006","数据库操作异常"),
	
	WHEEL_EXCHANGE_NOT_FOUND_ERROR("20001","兑换产品不存在"),
	DATA_BALANCE_ERROR("20002","流量余额不足"),
	NOT_UNICOM_NUMBER_ERROR("20003","非联通手机号"),
	NUMBER_DATA_ACCOUNT_NOT_FOUND_ERROR("20004","手机流量账户不存在"),
	
	WHEEL_REWARD_ERROR("20005","中奖数据错误"),
	WHEEL_REWARD_ALREADY_GET("20006","当日游戏次数已达上限"),
	
	WHEEL_GET_DATA_ERROR("20007","兑换流量错误"),
	
	LOGIN_CODE_INVALID("30001","登录code失效"),
	REWARD_NOT_FOUND("30002","奖品未找到"),
	SIGN_ERROR("30003","签到错误"),
	SIGN_SETTING_ERROR("30004","签到设置错误"),
	LOGIN_CODE_NULL_ERROR("30005","登录code为空"),
	MINIPID_NULL_ERROR("30006","小程序号为空"),
	OPENID_NULL_ERROR("30007","用户openid为空"),
	PHONE_NULL_ERROR("30008","手机号为空"),
	FORMID_NULL_ERROR("30009","formId为空"),
	MINIPID_VALID_ERROR("30010","minipid验证失败"),
	SIGN_DATE_VALID_ERROR("30011","签到日期验证失败"),
	
	GROUP_TYPE_EXCEPTION("50001","数据库异常"),
	GROUP_USER_OPEN_INFORMATION_NOT_FOUND("50002","开团信息不存在"),
	GROUP_TMP_BANNER_INFORMATION_NOT_FOUND("50003","BANNER信息查询不存在"),

	GROUP_REWARD_TYPE_NOT_FOUND("50004","奖品类型不存在"),
	GROUP_REWARD_TYPE_CONTENT_NOT_FOUND("50005","奖品信息不存在"),
	GROUP_REWARD_SIGN_ERROR("50006","签名错误"),
	GROUP_INFORMATON_ERROR("50007","该用户的今日的参团开团信息有误"),
	
	GROUP_ACTIVITY_ALREADY_END("50008","活动已结束"),
	WXBOOK_SIGN_ERROR("60001","微信读书签名错误")
	;
	ResultCodeEnum(String code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	private String code;
	
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public static void main(String[] args) {
		for(ResultCodeEnum resultCodeEnum: ResultCodeEnum.values()){
			System.out.println(resultCodeEnum.getCode()+":"+resultCodeEnum.getMsg());
		}
	}
}
