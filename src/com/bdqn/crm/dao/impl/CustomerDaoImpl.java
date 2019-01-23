package com.bdqn.crm.dao.impl;

import com.bdqn.crm.dao.CustomerDao;
import com.bdqn.crm.dto.CustomerInfoDto;
import com.bdqn.crm.entity.CustomerInfo;
import com.bdqn.crm.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {


    @Override
    public int save(CustomerInfo customerInfo) {
        return DBUtil.insert("customer_info", customerInfo);
    }

    @Override
    public List<CustomerInfoDto> findPageAllCustomer(int thisPage, int pageSize, String name, String phone, String conditionId ) {
        String sql = "SELECT ci.*,  dit1.`name` AS conditionName, dit2.`name` AS typeName, dit3.`name` AS sourceName, ui.`name` AS userName "+
                        "FROM  customer_info ci "+
                        "LEFT JOIN dic_item dit1 ON ci.condition_id = dit1.id "+
                        "LEFT JOIN dic_item dit2 ON ci.type_id = dit2.id "+
                        "LEFT JOIN dic_item dit3 ON ci.source_id = dit3.id "+
                        "LEFT JOIN user_info ui ON ci.user_id = ui.id "+
                        "WHERE ci.`name` LIKE ? AND ci.mobile LIKE ? AND ci.condition_id LIKE ? "+
                        "ORDER BY ci.create_time DESC LIMIT ?,?";
        return DBUtil.find(CustomerInfoDto.class, sql, "%"+name+"%", "%"+phone+"%", "%"+conditionId+"%", thisPage, pageSize);
    }

    @Override
    public List<CustomerInfo> findCustomerEmailNotNull() {
        List<CustomerInfo> customerInfoList = null;
        ResultSet resultSet = null;
        PreparedStatement prepareStatement=null;
        Connection connection = DBUtil.getConnection();
        String sql = "SELECT * FROM customer_info WHERE  email != ''";
        try {
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            customerInfoList= new ArrayList<>();
            while (resultSet.next()){
                CustomerInfo customerInfo = new CustomerInfo();
                customerInfo.setId(resultSet.getLong("id"));
                customerInfo.setName(resultSet.getString("name"));
                customerInfo.setEmail(resultSet.getString("email"));
                customerInfoList.add(customerInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet, prepareStatement, connection);
        }
        return customerInfoList;
    }

}
