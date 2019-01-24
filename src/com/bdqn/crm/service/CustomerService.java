package com.bdqn.crm.service;

import com.bdqn.crm.dto.CustomerCareDto;
import com.bdqn.crm.dto.CustomerInfoDto;
import com.bdqn.crm.dto.CustomerLinkmanDto;
import com.bdqn.crm.dto.CustomerLinkreordDto;
import com.bdqn.crm.entity.CustomerCare;
import com.bdqn.crm.entity.CustomerInfo;
import com.bdqn.crm.entity.CustomerLinkman;
import com.bdqn.crm.entity.CustomerLinkreord;

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

    /**
     * 根据id查询客户信息
     * @param i
     * @return
     */
    CustomerInfoDto getCustomerInfoByCustomerId(int i);

    /**
     * 查询所有客户信息
     * @return
     */
    List<CustomerInfo> getAllCustomerInfo();

    /**
     * 新增关怀客户信息
     * @param customerCare
     * @return
     */
    int saveCare(CustomerCare customerCare);

    /**
     * 分页查询客户关怀信息
     * @param thisPageTo
     * @param pageSize
     * @return
     */
    List<CustomerCareDto> findPageAllCustomerCare(int thisPageTo, int pageSize);

    /**
     * 分页查询客户联系记录信息
     * @param thisPageTo
     * @param pageSize
     * @return
     */
    List<CustomerLinkreordDto> findPageAllCustomerLinkreord(int thisPageTo, int pageSize);

    /**
     * 新增保存客户联系记录
     * @param customerLinkreord
     * @return
     */
    int saveLinkreord(CustomerLinkreord customerLinkreord);

    /**
     * 保存联系人信息
     * @param customerLinkman
     * @return
     */
    int saveLinkman(CustomerLinkman customerLinkman);

    /**
     * 分页查询联系人信息
     * @param thisPageTo
     * @param pageSize
     * @return
     */
    List<CustomerLinkmanDto> findPageAllCustomerLinkman(int thisPageTo, int pageSize);
}
