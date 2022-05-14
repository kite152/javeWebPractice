package Conn;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Druid {
    //定义数据源对象
    private static DataSource dataSource;

    //通过静态代码块来定义加载代码，在类加载时自动执行得到dataSource对象
    static {
        InputStream inputStream = Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        try {
            //通过properties的load()方法从输入流读取配置文件
            properties.load(inputStream);
            //通过DruidDataSourceFactory.createDataSource方法为dataSource赋值
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//测试
    public static Connection getConn() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConn(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println("数据库已关闭");
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
