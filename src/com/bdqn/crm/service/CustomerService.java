package com.bdqn.crm.service;

import com.bdqn.crm.dto.CustomerInfoDto;
import com.bdqn.crm.entity.CustomerInfo;

import java.util.List;

public interface CustomerService {


    /**
     * 保存客户新增信息
     * @param customerInfo
     * @return
     */
    int save(CustomerInfo customerInfo);


    /**
     * 分页查询所有客户
     * @param i
     * @param pageSize
     * @return
     */
    List<CustomerInfoDto> findPageAllCustomer(int thisPage, int pageSize, String name, String phone,String conditionId);

    /**
     * 查询所有邮箱不为空的客户信息
     * @return
     */
    List<CustomerInfo> findCustomerEmailNotNull();
}
