package com.weein.bigdata.core.service.impl;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.weein.bigdata.core.configuration.BigDataJDBCProperties;
import com.weein.bigdata.core.service.BigDataQueryService;
import com.weein.bigdata.core.utils.JdbcUtils;
@Service
public class BigDataQueryServiceImpl implements BigDataQueryService {
	private static final Logger LOG = LoggerFactory.getLogger(BigDataQueryService.class);
	@Resource
	private BigDataJDBCProperties bigDataJDBCProperties;
	@Override
	public List<List<String>> getBigDataQueryResult(String sql, int limit) {
		String driver = bigDataJDBCProperties.getDriver();
        String url = bigDataJDBCProperties.getUrl();
        String user = bigDataJDBCProperties.getUser();
        String password = bigDataJDBCProperties.getPassword();
		Properties properties = new Properties();
        properties.setProperty("driver", driver);
        properties.setProperty("url", url);
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        List<List<String>> resultList = null;
        
        try {
        	resultList = JdbcUtils.readFirstRows(driver, url, properties, sql, limit);
        	LOG.info("[查询数据结果:{}", new Object[] { resultList });
        	return resultList;
        }catch (Exception e) {
        	LOG.error("[发生异常:{}", new Object[] { e });
        	return null;
		}
	}

}
