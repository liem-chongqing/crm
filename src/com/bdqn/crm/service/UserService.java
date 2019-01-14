package com.bdqn.crm.service;

import com.bdqn.crm.entity.UserInfo;

import java.util.List;

public interface UserService {

    UserInfo login(String code, String password);

    int addUser(UserInfo userInfo);

    /**
     * 查询总条数
     * @return
     */
    int getTotalNumber();

    /**
     * 分页查询全部用户
     * @param i
     * @param pageSize
     * @return
     */
    List<UserInfo> findPageAllUser(int thisPage, int pageSize);

    int save(UserInfo userInfo);

    /**
     * 根据用户ID删除一条
     * @param l
     * @return
     */
    int deleteOneByUserId(long l);
}
