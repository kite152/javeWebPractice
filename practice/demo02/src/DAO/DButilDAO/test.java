package DAO.DButilDAO;

import Conn.Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
//query(String sql, ResultSetHandler rsh)
//不需要替换参数来执行已给予的SELECT语句
//
//query(String sql, ResultSetHandler rsh, Object... params)
//需要一个或多个替换参数来执行已给予的SELECT语句，并返回一种对象结果

//int update(Connection conn, String sql)
//不需要替换参数来执行INSERT, UPDATE
//DELETE语句
//
//int update(Connection conn, String sql, Object... params)
//需要一个或多个替换参数以及一个数据库连接来执行INSERT, UPDATE
//DELETE语句
//
//int update(Connection conn, String sql, Object param)
//需要一个替换参数，以及一个数据库连接来执行INSERT, UPDATE
//DELETE语句
//
//int update(String sql)
//不需要替换参数来执行已给予的INSERT, UPDATE
//DELETE语句
//
//int update(String sql, Object... params)
//需要一个或多个替换参数来执行INSERT, UPDATE
//DELETE语句（参数无需带有连接）
//
//int update(String sql, Object param)
//不需要替换参数来执行INSERT, UPDATE
//DELETE语句（参数无需带有连接）
public class test {
    //创建执行sql语句对象，并绑定数据源DataSource
    static QueryRunner queryRunner = new QueryRunner(Druid.getDataSource());

    @Test
    public void insert() throws SQLException {
        //从Druid数据库连接池获得一个连接
        Connection connection = Druid.getConn();
        String sql = "insert into test1 values(?,?)";
        Object[] param = {789, "樊冲"};
        try {
            int i = queryRunner.update(connection, sql, param);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Druid.closeConn(connection);
        }
    }

    @Test
    public void delete() throws SQLException {
        //创建执行sql语句对象，并绑定数据源DataSource
        //从Druid数据库连接池获得一个连接
        Connection connection = Druid.getConn();
        String sql = "delete from test1 where id=? and name=?";
        Object[] param = {789, "樊冲"};
        try {
            int i = queryRunner.update(connection, sql, param);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Druid.closeConn(connection);
        }
    }

    @Test
    public void edit() throws SQLException {
        //创建执行sql语句对象，并绑定数据源DataSource
        //从Druid数据库连接池获得一个连接
        Connection connection = Druid.getConn();
        String sql = "update test1 set id=?,name=? where id=? and name=?";
        Object[] param = {111, "樊冲", 221, "樊冲"};
        try {
            int i = queryRunner.update(sql, param);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Druid.closeConn(connection);
        }
    }

    @Test
    public void search() throws SQLException {
        //创建执行sql语句对象，并绑定数据源DataSource
        //从Druid数据库连接池获得一个连接
        Connection connection = Druid.getConn();
        String sql = "select * from test1 where id=? and name=?";
        Object[] param = {221, "樊冲"};
        try {
            Object[] list = queryRunner.query(sql, new ArrayHandler(), param);
            System.out.println(Arrays.toString(list));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Druid.closeConn(connection);
        }
    }

    @Test
    public void searchList() throws SQLException {
        //创建执行sql语句对象，并绑定数据源DataSource
        //从Druid数据库连接池获得一个连接
        Connection connection = Druid.getConn();
        String sql = "select * from test1 where id=? and name=?";
        Object[] param = {221, "樊冲"};
        try {
            List<Object[]> list = queryRunner.query(sql, new ArrayListHandler(), param);
            for (Object[] o :
                    list) {
                System.out.println(Arrays.toString(o));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Druid.closeConn(connection);
        }
    }
}
