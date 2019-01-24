package com.bdqn.crm.service.impl;


import com.bdqn.crm.dao.CustomerDao;
import com.bdqn.crm.dao.impl.CustomerDaoImpl;
import com.bdqn.crm.dto.CustomerCareDto;
import com.bdqn.crm.dto.CustomerInfoDto;
import com.bdqn.crm.dto.CustomerLinkmanDto;
import com.bdqn.crm.dto.CustomerLinkreordDto;
import com.bdqn.crm.entity.CustomerCare;
import com.bdqn.crm.entity.CustomerInfo;
import com.bdqn.crm.entity.CustomerLinkman;
import com.bdqn.crm.entity.CustomerLinkreord;
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

    @Override
    public CustomerInfoDto getCustomerInfoByCustomerId(int customerId) {
        return customerDao.getCustomerInfoByCustomerId(customerId);
    }

    @Override
    public List<CustomerInfo> getAllCustomerInfo() {
        return customerDao.getAllCustomerInfo();
    }

    @Override
    public int saveCare(CustomerCare customerCare) {
        return customerDao.saveCare(customerCare);
    }

    @Override
    public List<CustomerCareDto> findPageAllCustomerCare(int thisPageTo, int pageSize) {
        return customerDao.findPageAllCustomerCare(thisPageTo, pageSize);
    }

    @Override
    public List<CustomerLinkreordDto> findPageAllCustomerLinkreord(int thisPageTo, int pageSize) {
        return customerDao.findPageAllCustomerLinkreord(thisPageTo, pageSize);
    }

    @Override
    public int saveLinkreord(CustomerLinkreord customerLinkreord) {
        return  customerDao.saveLinkreord(customerLinkreord);
    }

    @Override
    public int saveLinkman(CustomerLinkman customerLinkman) {
        return customerDao.saveLinkman(customerLinkman);
    }

    @Override
    public List<CustomerLinkmanDto> findPageAllCustomerLinkman(int thisPageTo, int pageSize) {
        return customerDao.findPageAllCustomerLinkman(thisPageTo, pageSize);
    }
}
