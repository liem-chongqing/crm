package com.bdqn.crm.service.impl;


import com.bdqn.crm.dao.CustomerDao;
import com.bdqn.crm.dao.impl.CustomerDaoImpl;
import com.bdqn.crm.dto.CustomerInfoDto;
import com.bdqn.crm.entity.CustomerInfo;
import com.bdqn.crm.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public int save(CustomerInfo customerInfo) {
        return customerDao.save(customerInfo);
    }

    @Override
    public List<CustomerInfoDto> findPageAllCustomer(int thisPage, int pageSize, String name, String phone,String conditionId) {
        return customerDao.findPageAllCustomer(thisPage, pageSize, name, phone, conditionId);
    }

    @Override
    public List<CustomerInfo> findCustomerEmailNotNull() {
        return customerDao.findCustomerEmailNotNull();
    }
}
