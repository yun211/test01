package org.example;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException, SQLException {

        /*定义mybatis主配置文件的名称，从类路径的跟开始： target/classes*/
        String config = "mybatis.xml";
        /*读取config*/
        InputStream in =  Resources.getResourceAsStream(config);
        /*创建SqlSessionFactoryBuilder对象*/
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        /*创建SqlSessionFactory对象

        * */
        SqlSessionFactory factory = builder.build(in);

        /*重要   从SqlSessionFactory获取SqlSession*/
        SqlSession session = factory.openSession();

        /*String sql = "select id from student";
        Connection connection = session.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getInt("id"));
        }*/

        /*重要   指定要执行的sql语句的标识*/
        String sql ="org.example.dao.StudentDao"+"."+"selectStudents";
        /*执行sql语句*/
        List<Student> students = session.selectList(sql);
        students.forEach(student -> {
            System.out.println(student);
        });
        session.close();
        /*有没有发现你根本没有用到  dao层的接口！！！*/
    }
}
