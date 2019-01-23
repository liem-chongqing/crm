package com.bdqn.crm.dao;

import com.bdqn.crm.dto.CustomerInfoDto;
import com.bdqn.crm.entity.CustomerInfo;
import com.bdqn.crm.entity.DicItem;

import java.util.List;

public interface CustomerDao {

    int save(CustomerInfo customerInfo);

    List<CustomerInfoDto> findPageAllCustomer(int thisPage, int pageSize,String name, String phone, String conditionId);

    List<CustomerInfo> findCustomerEmailNotNull();
}
