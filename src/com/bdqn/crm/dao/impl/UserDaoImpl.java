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
    public int getTotalNumber() {
        String sql = "SELECT COUNT(id) AS total FROM user_info ";
        Connection connection = DBUtil.getConnection();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                result = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet, preparedStatement, connection);
        }

        return result;
    }



    @Override
    public List<UserInfo> findPageAllUser(int thisPage, int pageSize) {
        String sql = "SELECT id, num, role_name, name, sex, age,  email, mobile, idnum, nation FROM user_info LIMIT ?,?";
        return DBUtil.find(UserInfo.class, sql, thisPage, pageSize);
    }

    @Override
    public int save(UserInfo userInfo) {
        return DBUtil.insert("user_info", userInfo);
    }


}
