package com.bdqn.crm.dao;

import com.bdqn.crm.entity.UserInfo;

import java.util.List;

public interface UserDao {

    UserInfo login(String code, String password);

    int addUser(UserInfo userInfo);

    int getTotalNumber();

    List<UserInfo> findPageAllUser(int thisPage, int pageSize);
}
