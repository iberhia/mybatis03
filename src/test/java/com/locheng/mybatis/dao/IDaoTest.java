package com.locheng.mybatis.dao;

import com.locheng.mybatis.pojo.User;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class IDaoTest {

    InputStream inputStream;
    SqlSession sqlSession;
    IDao iDao;

    @Before
    public void init() throws Exception{
        String resource = "com/locheng/mybatis/MybatisConfig.xml";
        inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        iDao = sqlSession.getMapper(IDao.class);
    }

    @After
    public void destroy() throws Exception {
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void selectAll() {
        List<User> userList = iDao.selectAll();
        for (User user : userList) {
            System.out.println(user);
        }
        System.out.println(userList.size());
        System.out.println("select all");
    }
}
