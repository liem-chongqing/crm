package com.bdqn.crm.service;

import com.bdqn.crm.entity.User;

public interface UserService {
    User login(String code, String password);
}
