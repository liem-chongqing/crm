package com.bdqn.crm.service.impl;

import com.bdqn.crm.dao.UserDao;
import com.bdqn.crm.dao.impl.UserDaoImpl;
import com.bdqn.crm.entity.UserInfo;
import com.bdqn.crm.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao userDao = new UserDaoImpl();

    @Override
    public UserInfo login(String code, String password) {
        return userDao.login(code, password);
    }

    @Override
    public int addUser(UserInfo userInfo) {
        return userDao.addUser(userInfo);
    }


    @Override
    public List<UserInfo> findPageAllUser(int thisPage, int pageSize, String num,String  name) {
        return userDao.findPageAllUser(thisPage, pageSize, num, name);
    }

    @Override
    public int save(UserInfo userInfo) {
        return userDao.save(userInfo);
    }


    @Override
    public List<UserInfo> findAllUserByEnable(int enable) {
        return userDao.findAllUserByEnable(enable);
    }
}
