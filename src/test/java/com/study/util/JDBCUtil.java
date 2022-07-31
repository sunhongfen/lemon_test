package com.study.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Project: jkzdh
 * @Author: sun_h
 * @Create: 2022-07-22 16:17
 * @Desc：
 **/

public class JDBCUtil {
    public static Connection getConnection() {
        //定义数据库连接
        //Oracle：jdbc:oracle:thin:@localhost:1521:DBName
        //SqlServer：jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=DBName
        //MySql：jdbc:mysql://localhost:3306/DBName(数据库名)
        String url="jdbc:mysql://mall.lemonban.com/yami_shops?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String user="lemon";
        String password="lemon123";
        //定义数据库连接对象
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user,password);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }
//main方法验证queryRunner
//    public static void main(String[] args) throws SQLException {
//        Connection connection = getConnection();
//        QueryRunner queryRunner = new QueryRunner();
//        List<Map<String, Object>> query = queryRunner.query(connection, "SELECT * from tz_sms_log;", new MapListHandler());
//        System.out.println(query);
//        Map<String, Object> query1 = queryRunner.query(connection,
//                "SELECT mobile_code FROM tz_sms_log WHERE id=(SELECT MAX(id) FROM tz_sms_log);",
//                new MapHandler());
//        System.out.println(query1);
//        Object query2 = queryRunner.query(connection,
//                "SELECT mobile_code FROM tz_sms_log WHERE id=(SELECT MAX(id) FROM tz_sms_log);",
//                new ScalarHandler<>());
//        System.out.println(query2);
//
//    }

    /**
     * 读取多条数据
     * @param sql，查询数据的sql
     * @return返回查询到的数据
     */
    public static List<Map<String, Object>> queryListData(String sql){
        Connection connection = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        List<Map<String, Object>> query = null;
        try {
            query = queryRunner.query(connection, sql, new MapListHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query;
    }

    /**
     *读取单条数据
     * @param sql，查询数据sql
     * @return 返回查询到的数据
     */
    public static Map<String, Object> queryOneData (String sql){
        Connection connection = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        Map<String, Object> query = null;
        try {
           query = queryRunner.query(connection, sql, new MapHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query;
    }

    /**
     * 读取单个数据
     * @param sql，查询sql
     * @return 返回查询到的结果
     */
    public static Object querySingleData(String sql){
        //调用正则替换sql
        sql = Environment.regexTest(sql);
        //建立连接
        Connection connection = getConnection();
        //QueryRunner实例化
        QueryRunner queryRunner = new QueryRunner();
        //调用ScalarHandler,同时try/catch
        Object query = null;
        try {
            query = queryRunner.query(connection, sql, new ScalarHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query;
    }

}
