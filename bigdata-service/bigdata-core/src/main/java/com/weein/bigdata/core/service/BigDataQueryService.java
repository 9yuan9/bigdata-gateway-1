package com.weein.bigdata.core.service;

import java.util.List;

public interface BigDataQueryService {
	List<List<String>> getBigDataQueryResult(String sql,int limit);
}
