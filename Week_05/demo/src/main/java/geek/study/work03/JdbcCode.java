package geek.study.work03;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Copyright (C), 2021
 * FileName: JdbcCode
 * Author:   xzw
 * Date:     2021/2/20 23:51
 * Description:
 */
@Repository
public class JdbcCode {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/dev?useUnicode=true&characterEncoding=utf-8";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "root";

    @Autowired
   private HikariDataSource dataSource;

    /**
     * 连接池获取连接
     *
     * @return
     * @throws SQLException
     */
    private Connection getPoolConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 驱动手动建立连接
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * 每次新增一个用户
     *
     * @return 操作数
     */
    public void addOneInfo() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(System.currentTimeMillis() + "");
            userInfo.setUserName("自动创建");
            userInfo.setAddress("好困好困");
            String sql = "insert into user_info(user_id,user_name,address)" +
                    "values(?,?,?)";
            //获取连接
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userInfo.getUserId());
            preparedStatement.setString(2, userInfo.getUserName());
            preparedStatement.setString(3, userInfo.getAddress());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 每次新增两个用户
     *
     * @return
     */
    @Transactional(rollbackFor = {Exception.class})
    public void addBatch() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into user_info(user_id,user_name,address)" +
                    "values(?,?,?)";
            connection = getPoolConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 2; i++) {
                preparedStatement.setString(1, System.currentTimeMillis() + "");
                preparedStatement.setString(2, "自动创建" + i);
                preparedStatement.setString(3, "自动地址" + i);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (Exception e) {
            throw e;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
