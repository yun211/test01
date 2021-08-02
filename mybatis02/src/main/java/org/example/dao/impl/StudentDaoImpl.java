package org.example.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtil;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        SqlSession session = MybatisUtil.getSqlSession();
        String sqlId = "org.example.dao.StudentDao.selectStudents";
        List<Student> students = session.selectList(sqlId);
        session.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession session = MybatisUtil.getSqlSession();
        String sqlId = "org.example.dao.StudentDao.insertStudent";
        int num = session.insert(sqlId);
        session.commit();
        session.close();
        return num;
    }
}
