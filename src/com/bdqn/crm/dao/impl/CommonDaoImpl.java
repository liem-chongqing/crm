package com.bdqn.crm.dao.impl;

import com.bdqn.crm.dao.CommonDao;
import com.bdqn.crm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonDaoImpl implements CommonDao {


    @Override
    public int getTotalNumber(String tableName) {
        String sql = "SELECT COUNT(id) AS total FROM "+tableName;
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
    public int deleteOneById(String tableName, long id) {
        String sql = "DELETE FROM "+tableName+" WHERE id=?";
        return DBUtil.update(sql, id);
    }
}
