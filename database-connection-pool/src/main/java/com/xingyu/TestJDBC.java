package com.xingyu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBC {

    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=UTF-8";
    private static final String username = "root";
    private static final String password = "rootc";

    public static void main(String[] args) throws Exception {
        //六部曲
        String sql = "show variables like 'basedir'";
        //1.加载驱动
        Class.forName(driverName);
        //2.创建连接
        Connection conn = DriverManager.getConnection(url,username,password);
        //3.创建状态参数预处理sql语句
        PreparedStatement pstat = conn.prepareStatement(sql);
        //4.执行sql得到结果
        ResultSet rs = pstat.executeQuery();
        while(rs.next()){
            String name = rs.getString("Variable_name");
            String value = rs.getString("Value");
            System.out.println(name + " " + value);
        }
        rs.close();
        pstat.close();
        conn.close();
    }

}
