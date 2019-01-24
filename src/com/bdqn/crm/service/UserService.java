package com.bdqn.crm.service;

import com.bdqn.crm.entity.UserInfo;

import java.util.List;

public interface UserService {

    UserInfo login(String code, String password);

    int addUser(UserInfo userInfo);


    /**
     * 分页查询全部用户
     * @param
     * @param pageSize
     * @return
     */
    List<UserInfo> findPageAllUser(int thisPage, int pageSize, String num, String name);

    int save(UserInfo userInfo);


    /**
     * 查询所有员工
     * @param enable
     * @return
     */
    List<UserInfo> findAllUserByEnable(int enable);


}
