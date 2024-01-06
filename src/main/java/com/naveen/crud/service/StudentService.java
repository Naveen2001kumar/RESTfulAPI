package com.naveen.crud.service;

import com.naveen.crud.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> fetchAll();
    Student fetchById(int id);
    String deleteStudent(int id);
    String store(Student student);
    String updateStudent(int id, Student student);

}
