package org.example;

import org.example.dao.StudentDao;
import org.example.dao.impl.StudentDaoImpl;
import org.example.domain.Student;

public class MyApp {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();
        System.out.println(studentDao.insertStudent(student));

        /*有没有发现你根本没有用到  dao层的接口！！！*/
    }
}
