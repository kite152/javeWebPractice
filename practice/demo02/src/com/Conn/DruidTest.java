package com.Conn;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidTest {
    public static void main(String[] args) throws Exception {
        //读取文件
        InputStream inputStream = Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        //使用Properties集合的load方法从字节流读取数据
        Properties properties = new Properties();
        properties.load(inputStream);
        //通过工厂类获得连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //通过连接池对象获得数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
