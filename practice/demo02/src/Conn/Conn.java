package Conn;

import java.sql.*;

public class Conn {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws ClassNotFoundException {
        //连接数据库驱动
        Connection connection = null;
        try {
            //连接数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "152313");
            //封装sql语句
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConn(Connection connection, PreparedStatement preparedStatement) {
        try {
            //关闭数据库连接
            if (connection != null)
                connection.close();
            if (preparedStatement != null)
                preparedStatement.close();
            System.out.println("数据库已关闭");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConn(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            //关闭数据库连接
            if (resultSet != null)
                resultSet.close();
            closeConn(connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
