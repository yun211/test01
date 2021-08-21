package org.example;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        student.setId(1008);
        student.setAge(99);
        dao.insertStudent(student);
        session.commit();
    }

    @Test
    public void test03(){
        SqlSession session = MybatisUtil.getSqlSession();

        StudentDao dao = session.getMapper(StudentDao.class);
        Map<Object,Object> studentMap = dao.selectStudentsMap();
        System.out.println(studentMap);

    }

    @Test
    public void test04(){
        SqlSession session = MybatisUtil.getSqlSession();
        List sList = new ArrayList();
        sList.add(1001);
        sList.add(1002);
        sList.add(1003);
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudentsFor(sList);
        System.out.println(students);

    }

    @Test
    public void test05(){
        SqlSession session = MybatisUtil.getSqlSession();
        List<Student> sList = new ArrayList();
        Student s1 = new Student();
        s1.setId(1001);
        Student s2 = new Student();
        s2.setId(1003);
        Student s3 = new Student();
        s3.setId(1008);
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudentsFor1(sList);
        System.out.println(students);

    }

    @Test
    public void test06(){
        SqlSession session = MybatisUtil.getSqlSession();

        StudentDao dao = session.getMapper(StudentDao.class);

        System.out.println(dao.getClass().getName());

        /*
        *pageNum: 第几页  从一开始
        * pageSize:一页有多少数据 */
        PageHelper.startPage(2,2);
        List<Student> studentList = dao.selectStudents();
        System.out.println(studentList);

    }

    @Test
    public void test07() throws ParseException {
        String a = "0810"; String b = "0130";
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
        long result = sdf.parse(a).getTime() - sdf.parse(b).getTime()+sdf1.parse("1970").getTime();
        //加上1970年
        Date d1 = new Date(result);
        System.out.println(sdf2.format(d1).toString());

    }

}
