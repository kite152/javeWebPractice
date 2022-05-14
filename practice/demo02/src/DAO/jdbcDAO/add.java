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

@WebServlet(name = "add", value = "/add")
public class add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Conn.getConn();
            preparedStatement = connection.prepareStatement("insert into test1 values (?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
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
