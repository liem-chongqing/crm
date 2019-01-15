package com.bdqn.crm.dao.impl;


import com.bdqn.crm.dao.DicDao;
import com.bdqn.crm.dto.DicItemDto;
import com.bdqn.crm.entity.DicItem;
import com.bdqn.crm.entity.DicType;
import com.bdqn.crm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DicDaoImpl implements DicDao {
    @Override
    public int getTotalNumber(String tableName) {
        String sql = "SELECT COUNT(id) AS total FROM "+ tableName;
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
    public List<DicType> getAllType(int thisPage, int pageSize) {
        String sql = "SELECT id,  `name`, `key`, remark, used FROM dic_type ORDER BY id DESC LIMIT ?,?";
        return DBUtil.find(DicType.class, sql, thisPage, pageSize);
    }

    @Override
    public List<DicItemDto> getAllItems(int thisPage, int pageSize) {
        String sql = "SELECT dic_item.id, dic_item.`name`, dic_item.remark, dic_item.used, dic_type.`name` AS dicTypeName FROM dic_item, dic_type WHERE dic_type.id=dic_item.type_id ORDER BY id DESC LIMIT ?,?";
        return DBUtil.find(DicItemDto.class, sql, thisPage, pageSize);
    }

    @Override
    public int saveItem(DicItem dicItem) {
        return DBUtil.insert("dic_item", dicItem);
    }

    @Override
    public int saveType(DicType dicType) {
        return DBUtil.insert("dic_type", dicType);
    }


    @Override
    public List<DicItem> findDicType(String key) {
        String sql ="SELECT dic_item.id, dic_item.`name` FROM dic_item, dic_type WHERE dic_item.type_id = dic_type.id  AND dic_type.`key`=?";
        return DBUtil.find(DicItem.class, sql, key);
    }
}
