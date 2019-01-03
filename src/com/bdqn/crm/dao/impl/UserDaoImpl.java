package com.bdqn.crm.dao.impl;

import com.bdqn.crm.dao.UserDao;
import com.bdqn.crm.entity.User;
import com.bdqn.crm.util.DBUtil;

public class UserDaoImpl implements UserDao{

    @Override
    public User login(String code, String password) {
        String sql = "SELECT * FROM sys_user WHERE code=? AND password=?";
        return DBUtil.findBySingleObject(User.class, sql, code, password);
    }
}
