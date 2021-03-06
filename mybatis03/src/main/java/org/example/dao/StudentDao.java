package org.example.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.example.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    List<Student> selectStudents();


    //返回值：  sql语句影响的行数
    int insertStudent(Student student);

    @MapKey("id")
    Map<Object,Object> selectStudentsMap();

    List<Student> selectStudentsFor(@Param("sList")List  sList);

    List<Student> selectStudentsFor1(@Param("stuList")List  sList);


}
