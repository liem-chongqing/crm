package com.bdqn.crm.service.impl;

import com.bdqn.crm.dao.UserDao;
import com.bdqn.crm.dao.impl.UserDaoImpl;
import com.bdqn.crm.entity.User;
import com.bdqn.crm.service.UserService;

public class UserServiceImpl implements UserService{
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String code, String password) {
        return userDao.login(code, password);
    }
}
