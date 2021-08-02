package org.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    private static SqlSessionFactory factory = null;
    static {
        /*定义mybatis主配置文件的名称，从类路径的跟开始： target/classes*/
        String config = "mybatis.xml";
        /*读取config*/
        try {
            InputStream in =  Resources.getResourceAsStream(config);
            /*创建SqlSessionFactoryBuilder对象*/
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            /*创建SqlSessionFactory对象* */
            factory = builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSession getSqlSession(){
        SqlSession sqlSession= null;
        if(factory!=null){
            sqlSession = factory.openSession();
        }
        return sqlSession;
    }
}
