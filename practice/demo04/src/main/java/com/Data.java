package com;

import JavaBean.Student;
import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

//@WebServlet(name = "Data", value = "/Data")
public class Data extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1, "a"));
        list.add(new Student(2, "b"));
        list.add(new Student(3, "c"));
        String listString = JSON.toJSONString(list);
        response.getWriter().write(listString);
    }
}
