package com.dao.imp;

import com.beans.Student;
import com.dao.StudentDao;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository //将该类自动的放入IOC容器中 对应DAO层
public class StudentDaoImp implements StudentDao {
    private static final Map<Integer, Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put(1, new Student(1, "a"));
        studentMap.put(2, new Student(2, "b"));
        studentMap.put(3, new Student(3, "c"));
    }

    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }
}
