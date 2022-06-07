package com.controller;

import com.beans.Student;
import com.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController  //标注控制器组件
@RequestMapping("/student") //提供路由信息，负责URL到函数的映射
public class StudentHandler {
    @Autowired //自动导入依赖的Bean
    private StudentDao studentDao;

    @RequestMapping("/findAll")
    public Collection<Student> findAll() {
        return studentDao.findAll();
    }
}
