package DAO.jdbcDAO;

import Conn.Conn;
import data.Student;
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

@WebServlet(name = "show", value = "/show")
public class show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Conn.getConn();
            preparedStatement = connection.prepareStatement("select * from test1");
            resultSet = preparedStatement.executeQuery();
            ArrayList<Student> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                arrayList.add(new Student(resultSet.getInt(1), resultSet.getString(2)));
            }
            req.setAttribute("list", arrayList);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Conn.closeConn(connection, preparedStatement, resultSet);
            req.getRequestDispatcher("jspPage/show.jsp").forward(req, resp);
        }
    }
}