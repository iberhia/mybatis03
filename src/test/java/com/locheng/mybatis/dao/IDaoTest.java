package com.locheng.mybatis.dao;

import com.locheng.mybatis.pojo.User;
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

    private InputStream inputStream;
    private SqlSession sqlSession;
    private IUserDao iUserDao;

    @Before
    public void init() throws Exception{
        String resource = "com/locheng/mybatis/MybatisConfig.xml";
        inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        iUserDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception {
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void selectAll() {
        List<User> userList = iUserDao.selectAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
