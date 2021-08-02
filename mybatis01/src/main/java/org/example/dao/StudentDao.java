package org.example.dao;

import org.example.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();
    //返回值：  sql语句影响的行数
    int insertStudent(Student student);
}
