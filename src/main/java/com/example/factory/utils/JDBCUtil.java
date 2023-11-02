package com.example.factory.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 * @Author: fangju
 * @Date: 2019/6/15
 */
public class JDBCUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //静态代码块，在程序编译的时候执行
    public static JDBCUtil getInstance() {
        try {
            //创建Properties对象
            Properties p = new Properties();
            //获取文件输入流

            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
            //加载输入流
            p.load(in);
            //获取数据库连接驱动名字
            driver = p.getProperty("driverClassName",null);
            //获取数据库连接地址
            url = p.getProperty("url",null);
            //获取数据库连接用户名
            username = p.getProperty("username",null);
            //获取数据库连接密码
            password = p.getProperty("password",null);
            if(driver != null && url != null
                    && username != null && password != null){
                //加载驱动
                Class.forName(driver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取连接对象
     * @return Connection连接对象
     */
    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接（Connection连接对象必须在最后关闭）
     * @param conn Connection连接对象
     * @param st 编译执行对象
     * @param rs 结果集
     */
    public static void close(Connection conn, Statement st, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(st != null){
                st.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
