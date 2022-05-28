package com.DAO.jdbcDAO;

import com.Conn.Conn;
import com.data.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "search", value = "/search")
public class search extends HttpServlet {
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
        ResultSet resultSet = null;
        ArrayList<Student> arrayList = new ArrayList<>();
        try {
            connection = Conn.getConn();
            preparedStatement = connection.prepareStatement("select * from test1 where id=? and name=?");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                arrayList.add(new Student(resultSet.getInt(1), resultSet.getString(2)));
            }
            request.setAttribute("list", arrayList);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            Conn.closeConn(connection, preparedStatement, resultSet);
            request.getRequestDispatcher("jspPage/show.jsp").forward(request, response);
        }
    }
}
