package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtil;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test01(){
        SqlSession session = MybatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        System.out.println(dao.getClass().getName());
        List<Student> studentList = dao.selectStudents();
        System.out.println(studentList);

    }
    @Test
    public void test02(){
        SqlSession session = MybatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student  = new Student();
        dao.insertStudent(student);
        session.commit();


    }

}
