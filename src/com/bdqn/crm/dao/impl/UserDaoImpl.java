package com.bdqn.crm.dao.impl;

import com.bdqn.crm.dao.UserDao;
import com.bdqn.crm.entity.UserInfo;
import com.bdqn.crm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public UserInfo login(String code, String password) {
        String sql = "SELECT * FROM user_info WHERE num=? AND pwd=?";
        return DBUtil.get(UserInfo.class, sql, code, password);
    }

    @Override
    public int addUser(UserInfo userInfo) {
        return DBUtil.insert("user_info", userInfo);
    }


    @Override
    public List<UserInfo> findPageAllUser(int thisPage, int pageSize, String num, String name) {
        String sql = "SELECT id, num, role_name, name, sex, age,  email, mobile, idnum, nation FROM user_info WHERE num LIKE ? AND name LIKE ? ORDER BY create_time DESC LIMIT ?,?";
        return DBUtil.find(UserInfo.class, sql, "%"+num+"%", "%"+name+"%", thisPage, pageSize);
    }

    @Override
    public int save(UserInfo userInfo) {
        return DBUtil.insert("user_info", userInfo);
    }

    @Override
    public List<UserInfo> findAllUserByEnable(int enable) {
        String sql ="SELECT id, `name`, num FROM user_info WHERE used=?";
        return DBUtil.find(UserInfo.class, sql, enable);
    }

    @Override
    public UserInfo getUserInfoByuserId(Long userId) {
        String sql = "SELECT id,role_name,name,sex,mobile,age,address,num,tel,idnum,email,hobby,diploma,bank_card,nation,married,used FROM user_info WHERE id=?";
        return DBUtil.get(UserInfo.class, sql, userId);
    }


}
