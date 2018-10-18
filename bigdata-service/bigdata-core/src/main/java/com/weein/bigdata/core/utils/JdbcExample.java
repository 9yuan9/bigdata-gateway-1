package com.weein.bigdata.core.utils;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class JdbcExample {

    public static void main(String[] args) throws IOException {
        String driver = "com.datapps.linkoopdb.jdbc.JdbcDriver";
        String url = "jdbc:linkoopdb:tcp://localhost:9105/ldb";
        String user = "admin";
        String password = "123456";
       /* String url = "jdbc:mysql://47.95.119.35:3307/act?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
        String user = "root";
        String password = "123456";*/
        Properties properties = new Properties();
        properties.setProperty("driver", driver);
        properties.setProperty("url", url);
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        List<String> tables = JdbcUtils.getTableList(driver, url, properties);
        for (String table : tables) {
            System.out.println(table);
        }
        String phone = "18601107610";

        String sql = "SELECT * FROM DATAZHX.T_USER_PROFILE where phone ="+phone;// limit 2
        List<List<String>> result = JdbcUtils.readFirstRows(driver, url, properties, sql, 1000);
        for (List<String> row : result) {
            System.out.println("row: " + row);
        }
    }

}
