package com.bdqn.crm.dao;

import com.bdqn.crm.entity.UserInfo;

import java.util.List;

public interface UserDao {

    UserInfo login(String code, String password);

    int addUser(UserInfo userInfo);


    List<UserInfo> findPageAllUser(int thisPage, int pageSize, String num, String name);

    int save(UserInfo userInfo);


    List<UserInfo> findAllUserByEnable(int enable);

    UserInfo getUserInfoByuserId(Long userId);
}
