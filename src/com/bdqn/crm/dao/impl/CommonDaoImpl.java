package com.bdqn.crm.dao.impl;

import com.bdqn.crm.dao.CommonDao;
import com.bdqn.crm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonDaoImpl implements CommonDao {


    @Override
    public int getTotalNumber(String sql, String... pram) {
        Connection connection = DBUtil.getConnection();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i=0; i<pram.length; i++){
                preparedStatement.setString(i+1, pram[i]);
            }
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
        System.out.println("CommonDaoImpl.deleteOneById(); 正在执行删除，ID为："+id);
        String sql = "DELETE FROM "+tableName+" WHERE id=?";
        return DBUtil.update(sql, id);
    }

    @Override
    public int deleteBatch(String tableName, String ids) {
        System.out.println("CommonDaoImpl.deleteBatch(); 正在执行批量删除，ID为："+ids);
        String sql = "DELETE FROM "+tableName+" WHERE FIND_IN_SET(id,?)";
        return DBUtil.update(sql, ids);
    }

    @Override
    public int update(String tableName, Object object) {
        return DBUtil.modify(tableName, object);
    }

    @Override
    public Integer totalNumberByTableName(String tableName) {
        String sql ="SELECT COUNT(id) AS total FROM "+tableName;
        return getTotalNumber(sql);
    }
}
