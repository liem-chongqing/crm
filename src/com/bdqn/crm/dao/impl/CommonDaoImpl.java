package com.bdqn.crm.dao.impl;

import com.bdqn.crm.dao.CommonDao;
import com.bdqn.crm.entity.UserInfo;
import com.bdqn.crm.util.DBUtil;
import com.bdqn.crm.util.ExcelUtil;
import com.bdqn.crm.util.StringsUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public int batchAdd(List<ArrayList<Object>> list, String tableName) {
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO ").append(tableName).append("(");
        String property = list.get(0).toString();
        sb.append(property.substring(1,property.length()-1));
        sb.append(") ").append("VALUES");

        StringBuffer value = new StringBuffer();
        for (int i = 1; i < list.size(); i++) {
            sb.append("(");
            for (int j = 0; j < list.get(i).size(); j++) {
                value.append("'");
                value.append(list.get(i).get(j));
                value.append("',");
            }
            sb.append(value.toString().substring(0,value.length()-1));
            sb.append("),");
            value.delete(0,value.length());
        }
        String sql = sb.toString().substring(0, sb.length()-1);
        return DBUtil.update(sql);
    }

}
