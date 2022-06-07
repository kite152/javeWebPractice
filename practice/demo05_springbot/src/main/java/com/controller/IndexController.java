package com.controller;

import com.beans.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/index")
public class IndexController {
    @GetMapping("/i") //采用GET方式请求
    public String index(Model model) {

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1, "a"));
        list.add(new Student(2, "b"));
        list.add(new Student(3, "c"));
        model.addAttribute("list", list);
        return "index";
    }
}
