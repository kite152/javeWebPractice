package com.DAO.jdbcDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "com.DAO.DAO.jdbcDAO.dispatch", value = "/com.DAO.DAO.jdbcDAO.dispatch")
public class dispatch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dpt = Integer.parseInt(request.getParameter("dpt"));
        switch (dpt) {
            case 1 -> request.getRequestDispatcher("add").forward(request, response);
            case 2 -> request.getRequestDispatcher("delete").forward(request, response);
            case 3 -> request.getRequestDispatcher("edit").forward(request, response);
            case 4 -> request.getRequestDispatcher("search").forward(request, response);
        }
    }
}
