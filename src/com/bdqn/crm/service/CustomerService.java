package com.bdqn.crm.service;

import com.bdqn.crm.dto.CustomerInfoDto;
import com.bdqn.crm.entity.CustomerInfo;
import com.bdqn.crm.entity.DicItem;
import com.bdqn.crm.entity.UserInfo;

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
    List<CustomerInfoDto> findPageAllCustomer(int i, int pageSize);
}
