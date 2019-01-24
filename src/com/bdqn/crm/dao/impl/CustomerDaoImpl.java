package com.bdqn.crm.dao.impl;

import com.bdqn.crm.dao.CustomerDao;
import com.bdqn.crm.dto.CustomerCareDto;
import com.bdqn.crm.dto.CustomerInfoDto;
import com.bdqn.crm.dto.CustomerLinkmanDto;
import com.bdqn.crm.dto.CustomerLinkreordDto;
import com.bdqn.crm.entity.CustomerCare;
import com.bdqn.crm.entity.CustomerInfo;
import com.bdqn.crm.entity.CustomerLinkman;
import com.bdqn.crm.entity.CustomerLinkreord;
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

    @Override
    public CustomerInfoDto getCustomerInfoByCustomerId(int customerId) {
        String sql = "SELECT ci.*,  dit1.`name` AS conditionName, dit2.`name` AS typeName, dit3.`name` AS sourceName, ui.`name` AS userName "+
                "FROM  customer_info ci "+
                "LEFT JOIN dic_item dit1 ON ci.condition_id = dit1.id "+
                "LEFT JOIN dic_item dit2 ON ci.type_id = dit2.id "+
                "LEFT JOIN dic_item dit3 ON ci.source_id = dit3.id "+
                "LEFT JOIN user_info ui ON ci.user_id = ui.id "+
                "WHERE ci.id=?";
        return DBUtil.get(CustomerInfoDto.class, sql, customerId);
    }

    @Override
    public List<CustomerInfo> getAllCustomerInfo() {
        List<CustomerInfo> customerInfoList = null;
        ResultSet resultSet = null;
        PreparedStatement prepareStatement=null;
        Connection connection = DBUtil.getConnection();
        String sql = "SELECT id, `name`, mobile FROM customer_info ";
        try {
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            customerInfoList= new ArrayList<>();
            while (resultSet.next()){
                CustomerInfo customerInfo = new CustomerInfo();
                customerInfo.setId(resultSet.getLong("id"));
                customerInfo.setName(resultSet.getString("name"));
                customerInfo.setMobile(resultSet.getString("mobile"));
                customerInfoList.add(customerInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet, prepareStatement, connection);
        }
        return customerInfoList;
    }

    @Override
    public int saveCare(CustomerCare customerCare) {
        return DBUtil.insert("customer_care", customerCare);
    }

    @Override
    public List<CustomerCareDto> findPageAllCustomerCare(int thisPageTo, int pageSize) {
        String sql = "SELECT cc.*, ci.`name` AS customerName FROM customer_care cc, customer_info ci WHERE cc.customer_id=ci.id ORDER BY cc.id DESC LIMIT ?,?";
        return DBUtil.find(CustomerCareDto.class, sql, thisPageTo, pageSize);
    }

    @Override
    public List<CustomerLinkreordDto> findPageAllCustomerLinkreord(int thisPageTo, int pageSize) {
        String sql = "SELECT cl.*, ci.`name` AS customerName FROM customer_linkreord cl, customer_info ci WHERE cl.customer_id = ci.id ORDER BY cl.id DESC LIMIT ?,?";
        return DBUtil.find(CustomerLinkreordDto.class, sql, thisPageTo, pageSize);
    }

    @Override
    public int saveLinkreord(CustomerLinkreord customerLinkreord) {
        return DBUtil.insert("customer_linkreord", customerLinkreord);
    }

    @Override
    public int saveLinkman(CustomerLinkman customerLinkman) {
        return DBUtil.insert("customer_linkman", customerLinkman);
    }

    @Override
    public List<CustomerLinkmanDto> findPageAllCustomerLinkman(int thisPageTo, int pageSize) {
        String sql = "SELECT cl.*, ci.`name` AS customerName FROM customer_linkman cl, customer_info ci WHERE cl.customer_id = ci.id ORDER BY cl.id DESC LIMIT ?,?";
        return DBUtil.find(CustomerLinkmanDto.class, sql, thisPageTo, pageSize);
    }

}
