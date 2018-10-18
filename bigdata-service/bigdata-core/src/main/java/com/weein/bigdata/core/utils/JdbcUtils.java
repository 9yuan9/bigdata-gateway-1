package com.weein.bigdata.core.utils;


import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcUtils {

    private static Logger logger = LoggerFactory.getLogger(JdbcUtils.class);

    public static List<String> getTableList(String driver, String url, Properties properties) throws IOException {
        List<String> tables = new ArrayList<>();

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new IOException("can not init driver " + driver, e);
        }

        try (Connection conn = DriverManager.getConnection(url, properties)) {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet rs = metaData.getTables(conn.getCatalog(), null, null, new String[]{"TABLE", "VIEW"});
            while (rs.next()) {
                tables.add(rs.getString("TABLE_SCHEM") + "." + rs.getString("TABLE_NAME"));
            }
            rs.close();
        } catch (Throwable e) {
            tables.add("Get table list failed: " + e.getMessage());
        }

        long start = System.currentTimeMillis();
        logger.info("get table list cost:" + (System.currentTimeMillis() - start));
        return tables;
    }

    public static void executeUpdate(String driver, String url, Properties properties, String sql) throws IOException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new IOException("can not init driver " + driver, e);
        }

        List<List<String>> result = new ArrayList<>();

        long start = System.currentTimeMillis();

        try (Connection c = DriverManager.getConnection(url, properties)) {
            logger.info("connect to url " + url + " cost : " + (System.currentTimeMillis() - start));
            start = System.currentTimeMillis();
            try (Statement stmt = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
                stmt.executeUpdate(sql);
            }
            logger.info("execute update cost:" + (System.currentTimeMillis() - start));
        } catch (Throwable e) {
            throw new IOException("execute sql failed", e);
        }
    }

    public static List<List<String>> readFirstRows(String driver, String url, Properties properties, String sql, int rows) throws IOException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new IOException("can not init driver " + driver, e);
        }

        List<List<String>> result = new ArrayList<>();

        long start = System.currentTimeMillis();

        try (Connection c = DriverManager.getConnection(url, properties)) {
            logger.info("connect to url " + url + " cost : " + (System.currentTimeMillis() - start));
            start = System.currentTimeMillis();
            try (Statement stmt = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
                stmt.setFetchSize(rows);
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    int cols = rs.getMetaData().getColumnCount();
                    char[] clobBuffer = new char[100];
                    while (rs.next() && rows-- > 0) {
                        List<String> r = new ArrayList<>();
                        for (int i = 0; i < cols; i++) {
                            Object col = rs.getObject(i + 1);
                            if (col == null) {
                                r.add("");
                            } else if (col instanceof Clob) {
                                try (Reader reader = ((Clob) col).getCharacterStream()) {
                                    int len = reader.read(clobBuffer);
                                    r.add(new String(clobBuffer, 0, len));
                                }
                            } else {
                                r.add(col.toString());
                            }
                        }
                        result.add(r);
                    }
                }
            }
            logger.info("get result cost:" + (System.currentTimeMillis() - start));
        } catch (Throwable e) {
            throw new IOException("read jdbc data error", e);
        }

        return result;
    }

}
