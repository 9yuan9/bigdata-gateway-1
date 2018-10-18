package com.weein.bigdata.base.contants;

public class MiniPConstant {

	//短信验证码失效时间 5分钟
	public static final long SMS_TIME_OUT=60*60;
	
	public static final long SESSION_TIME_OUT=60*60*24*10;
	
	public static final long LOCK_TIMEOUT=5;
	
	public static final int MAX_BILL_ERROR=10;

	public static final String UNICOM_SEND_MSM_PATH="/openapi/SMS/v1.0";

	//查询流量使用
	public static final String UNICOM_FEEPOLICYADDUP_PATH="/openapi/provide/dimpt/feepolicyaddup/v1";
	//账户查询
	public static final String UNICOM_ACCT_BALANCE_PATH="/openapi/provide/dimpt/acctbalance/v1";
	
	public static final String UNICOM_USER_NUMBER_CHECK_PATH="/openapi/provide/dimpt/usernumbercheck/v1";
	
	public static final String WO_GET_SMS_TOKEN_URL="http://uwo.533.net/app/index.php?i=2&c=entry&do=smstoken&m=uwointerface&token=TOKEN";
	
	
	//微信接口
	//登录接口
	public static final String MINI_PROGRAMS_LOGIN_URL="https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

	public static final String STRATEGY_GET_MY_ACTIVITY_PATH = "/v1/strategy/api/getMyActivity.do";
	
	public static final String STRATEGY_GET_USER_AVERAGEARUP_PATH ="/v1/strategy/api/getAverageArup.do";
	
	public static final String STRATEGY_GET_PROVINCEID_PATH ="/v1/strategy/api/getProvinceidBytel.do";
	
	public static final String STRATEGY_GET_MY_ACTIVITY_LIST_PATH ="/v2/strategy/api/getMyActivity.do";
	
	
	
}
