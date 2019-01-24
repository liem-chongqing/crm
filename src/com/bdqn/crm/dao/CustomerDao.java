package com.bdqn.crm.dao;

import com.bdqn.crm.dto.CustomerCareDto;
import com.bdqn.crm.dto.CustomerInfoDto;
import com.bdqn.crm.dto.CustomerLinkmanDto;
import com.bdqn.crm.dto.CustomerLinkreordDto;
import com.bdqn.crm.entity.*;

import java.util.List;

public interface CustomerDao {

    int save(CustomerInfo customerInfo);

    List<CustomerInfoDto> findPageAllCustomer(int thisPage, int pageSize,String name, String phone, String conditionId);

    List<CustomerInfo> findCustomerEmailNotNull();

    CustomerInfoDto getCustomerInfoByCustomerId(int customerId);

    List<CustomerInfo> getAllCustomerInfo();

    int saveCare(CustomerCare customerCare);

    List<CustomerCareDto> findPageAllCustomerCare(int thisPageTo, int pageSize);

    List<CustomerLinkreordDto> findPageAllCustomerLinkreord(int thisPageTo, int pageSize);

    int saveLinkreord(CustomerLinkreord customerLinkreord);

    int saveLinkman(CustomerLinkman customerLinkman);

    List<CustomerLinkmanDto> findPageAllCustomerLinkman(int thisPageTo, int pageSize);
}
