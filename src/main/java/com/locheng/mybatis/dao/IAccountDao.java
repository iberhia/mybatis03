package com.locheng.mybatis.dao;

import com.locheng.mybatis.pojo.Account;
import com.locheng.mybatis.pojo.AccountUser;
import com.locheng.mybatis.pojo.User;

import java.util.List;

public interface IAccountDao {
    List<Account> selectAll();

    List<Account> selectAllAccountUser();

}
