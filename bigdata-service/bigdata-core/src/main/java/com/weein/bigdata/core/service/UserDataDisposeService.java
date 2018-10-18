package com.weein.bigdata.core.service;

import java.util.List;

public interface UserDataDisposeService {
	public List<List<String>> getUserData1(String phone);
	public List<List<String>> getUserData2(String openId);
}
