package com.bdqn.crm.servlet;

import com.bdqn.crm.entity.User;
import com.bdqn.crm.util.BeanMapConvertUtil;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        User user = new User();
        user.setId(11);
        user.setUserName("adxx");
        Map map= BeanMapConvertUtil.convertBean(user);
        System.out.println(map);
    }
}
