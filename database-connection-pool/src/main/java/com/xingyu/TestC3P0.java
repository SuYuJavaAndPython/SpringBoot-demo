package com.xingyu;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class TestC3P0 {

    private static ComboPooledDataSource dataSource;

    static {
        //将指定配置文件中的指定标签内容加载进来 无参构造器默认加载默认路径下的配置文件
//        dataSource = new ComboPooledDataSource();
        //带参构造器去默认路径下的对应配置文件中找名字符合的配置信息进行加载，多用于多数据源
        dataSource = new ComboPooledDataSource("myC3P0");
        System.out.println("数据源名称为：" + dataSource.getDataSourceName());
    }

    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(Connection conn){
        try {
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection conn = getConn();
        if(conn != null){
            System.out.println("成功获取连接");
        }
        closeConn(conn);
    }


}
