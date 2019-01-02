package com.bdqn.crm.dao;

import com.bdqn.crm.entity.User;

public interface UserDao {
    User login(String code, String password);
}
