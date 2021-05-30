package com.xingyu;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class TestDruid {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(TestDBCP.class.getClassLoader()
                    .getResourceAsStream("druid.properties"));
            //通过基础数据源工厂类来创建连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = getConn();
            DatabaseMetaData metaData = conn.getMetaData();
            //通过元数据获取数据库名称及版本信息
            System.out.println(metaData.getDatabaseProductName() + " " +
                    metaData.getDatabaseProductVersion());
            closeConn(conn);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        for(int i = 0; i < 10; i++){
            Connection conn = getConn();
            System.out.println("连接池创建成功"+i);
            closeConn(conn);
        }
    }
}
