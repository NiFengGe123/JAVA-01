package com.geek.study;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

/**
 * 百万数据插入测试
 * Copyright (C), 2021
 * FileName: serivce
 * Author:   xzw
 * Date:     2021/3/6 15:48
 * Description:
 */
public class serivce {


    private static final String URL = "jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        long startTimes = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
//            saveNewProductInfo(20000);
            insertBatch(20000);
        }
        System.out.println("插入数据：一百万 条,总耗时：" + (System.currentTimeMillis() - startTimes) + "MS");
    }

    private static void insertBatch(Integer length){
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "insert into product_info (product_id,product_code,product_name,bar_code,price,push_status,audit_status\n" +
                "        ,production_date,shelf_life,descript)\n" +
                "        values(?,?,?,?,?,1,1,?,3,?)";
        try{
            connection = getConnection();
            if (connection == null){
                throw new RuntimeException("未取得数据库连接");
            }
            statement  = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            DecimalFormat format = new java.text.DecimalFormat("#.00");
            for (int i = 0;i<length;i++){
                String productId = RandomStringUtils.randomAlphanumeric(6);
                String productCode = RandomStringUtils.randomAlphabetic(7);
                String barCode = RandomStringUtils.randomAlphabetic(7);
                String productName = "测试商品-翡翠石" + RandomUtils.nextInt(0,1100000);
                statement.setString(1,productId);
                statement.setString(2,productCode);
                statement.setString(3,productName);
                statement.setString(4,barCode);
                statement.setString(5,format.format(Math.random()));
                statement.setString(6,DateFormatUtils.format(DateUtils.addWeeks(new Date(), -RandomUtils.nextInt(1, 50)), "yyyy-MM-dd HH:mm:ss"));
                statement.setString(7,"这是一个"+productName);
                statement.addBatch();
            }
            long startTimes = System.currentTimeMillis();
            int[] batch = statement.executeBatch();
            connection.commit();
            System.out.println("成功插入数据：" + batch.length + " 条,总耗时：" + (System.currentTimeMillis() - startTimes) + "MS");
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void saveNewProductInfo(Integer length) {
        StringBuilder builder = new StringBuilder();
        builder.append("insert into product_info (product_id,product_code,product_name,bar_code,price,push_status,audit_status\n" +
                "        ,production_date,shelf_life,descript)\n" +
                "        values");
        String values = getSQL(length);
        builder.append(values);
        try (Connection connection = getHikariConnection();
             Statement statement = connection.createStatement()) {
            long startTimes = System.currentTimeMillis();
            int result = statement.executeUpdate(builder.toString());
            System.out.println("成功插入数据：" + result + " 条,总耗时：" + (System.currentTimeMillis() - startTimes) + "MS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getSQL(Integer length) {
        StringBuilder builder = new StringBuilder();
        DecimalFormat format = new java.text.DecimalFormat("#.00");
        for (int i = 0; i < length; i++) {
            String productId = RandomStringUtils.randomAlphanumeric(6);
            String productCode = RandomStringUtils.randomAlphabetic(7);
            String barCode = RandomStringUtils.randomAlphabetic(7);
            String productName = "测试产品-五彩石" + RandomUtils.nextInt(0,1100000);
            if (i > 0) {
                builder.append(",");
            }
            builder.append("(");
            builder.append("'").append(productId).append("'").append(",").append("'").append(productCode).append("'")
                    .append(",").append("'").append(productName).append("'").append(",").append("'").append(barCode).append("'");
            builder.append(",").append(format.format(Math.random())).append(",").append(1)
                    .append(",").append(1)
                    .append(",").append("'").append(DateFormatUtils.format(DateUtils.addWeeks(new Date(), -RandomUtils.nextInt(1, 50)), "yyyy-MM-dd HH:mm:ss")).append("'")
                    .append(",").append(3).append(",").append("'").append("这是一个").append(productName).append("'");
            builder.append(")");
        }
        return builder.toString();
    }

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }

    /**
     * 使用Hikari连接池管理连接
     *
     * @return
     */
    public static Connection getHikariConnection() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(URL);
        hikariConfig.setUsername(USER_NAME);
        hikariConfig.setPassword(PASSWORD);
        hikariConfig.setAutoCommit(false);
        hikariConfig.setMinimumIdle(5);
        hikariConfig.setMaximumPoolSize(20);
        hikariConfig.setConnectionTimeout(180000);
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "256");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        try {
            return hikariDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
