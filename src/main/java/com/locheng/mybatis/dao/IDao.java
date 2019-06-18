package com.locheng.mybatis.dao;

import com.locheng.mybatis.pojo.User;

import java.util.List;

public interface IDao {
    List<User> selectAll();
}
