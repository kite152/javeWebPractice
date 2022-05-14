package DAO.jdbcDAO;

import Conn.Conn;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "edit", value = "/edit")
public class edit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id1 = Integer.parseInt(request.getParameter("id1"));
        int id2 = Integer.parseInt(request.getParameter("id2"));
        String name1 = request.getParameter("name1");
        String name2 = request.getParameter("name2");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Conn.getConn();
            preparedStatement = connection.prepareStatement("update test1 set id=?,name=? where id=? and name=?");
            preparedStatement.setInt(1, id2);
            preparedStatement.setString(2, name2);
            preparedStatement.setInt(3, id1);
            preparedStatement.setString(4, name1);
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            Conn.closeConn(connection, preparedStatement);
            request.getRequestDispatcher("show").forward(request, response);
        }
    }
}
