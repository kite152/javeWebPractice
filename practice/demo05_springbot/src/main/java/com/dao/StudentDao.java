package com.dao;

import com.beans.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> findAll();
}
