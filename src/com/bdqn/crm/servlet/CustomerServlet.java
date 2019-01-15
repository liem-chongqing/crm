package com.bdqn.crm.servlet;


import com.bdqn.crm.constant.Constants;
import com.bdqn.crm.dto.CustomerInfoDto;
import com.bdqn.crm.entity.CustomerInfo;
import com.bdqn.crm.entity.DicItem;
import com.bdqn.crm.entity.UserInfo;
import com.bdqn.crm.service.CommonService;
import com.bdqn.crm.service.CustomerService;
import com.bdqn.crm.service.DicService;
import com.bdqn.crm.service.UserService;
import com.bdqn.crm.service.impl.CommonServiceImpl;
import com.bdqn.crm.service.impl.CustomerServiceImpl;
import com.bdqn.crm.service.impl.DicServiceImpl;
import com.bdqn.crm.service.impl.UserServiceImpl;
import com.bdqn.crm.util.MenuUtil;
import com.bdqn.crm.util.PageUtil;
import com.bdqn.crm.util.StringsUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 用户模块
 */
@WebServlet("/customer")
public class CustomerServlet extends BaseServlet {

    /**
     * 跳转到客户新增页面
     * @param request
     * @param response
     * @return
     */
    public String add(HttpServletRequest request, HttpServletResponse response){
        DicService dicService = new DicServiceImpl();
        UserService userService = new UserServiceImpl();
        // 客户来源 CUSTOMER_SOURCE
        List<DicItem> dicItems1 = dicService.findDicType("CUSTOMER_SOURCE");
        // 客户类型 CUSTOMER_TYPE
        List<DicItem> dicItems2 = dicService.findDicType("CUSTOMER_TYPE");
        // 客户状态 CUSTOMER_CONDITION
        List<DicItem> dicItems3 = dicService.findDicType("CUSTOMER_CONDITION");
        // 查询所有员工
        List<UserInfo> userInfos = userService.findAllUserByEnable(Constants.State.ENABLE);
        request.setAttribute("sources", dicItems1);
        request.setAttribute("types", dicItems2);
        request.setAttribute("conditions", dicItems3);
        request.setAttribute("userInfos", userInfos);
        return "add-customer-info";
    }


    /**
     * 新增： 保存信息
     * @param request
     * @param response
     * @return
     */
    public String save(HttpServletRequest request, HttpServletResponse response){
        CustomerInfo customerInfo = parameterBean(request, CustomerInfo.class);
        UserInfo user = (UserInfo) request.getSession().getAttribute("user");
        if(null != user){
            customerInfo.setUpdateTime(new Date());
            customerInfo.setCreateTime(new Date());
            customerInfo.setCreateMan(user.getName());
            customerInfo.setUpdateMan(user.getName());
            CustomerService customerService = new CustomerServiceImpl();
            if(customerService.save(customerInfo) > 0){
                return "add-success";
            }
        }
        return "redirect:customer?command=add";
    }

    /**
     * 分页查看所有客户信息
     * @param request
     * @param response
     * @return
     */
    public String showCustomer(HttpServletRequest request, HttpServletResponse response){
        CommonService commonService = new CommonServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        PageUtil<CustomerInfoDto> pageUtil = new PageUtil<>();
        // 查询数据库总条数
        int totalNumber = commonService.getTotalNumber("customer_info");
        // 得到数据的总条数后装给pagedemo模型
        pageUtil.setTotalNum(totalNumber);
        // 获取前台的分页参数
        String thisPage = request.getParameter("thisPage");
        // 如果不为null的话，则转型
        if(null != thisPage){
            pageUtil.setThisPage(Integer.parseInt(thisPage));
        }
        // 获取总页数
        int totalPage = (pageUtil.getTotalNum() -1)/pageUtil.getPageSize()+1;
        pageUtil.setTotalPage(totalPage);
        List<CustomerInfoDto> customerInfos = customerService.findPageAllCustomer((pageUtil.getThisPage()-1) * pageUtil.getPageSize(), pageUtil.getPageSize());
        pageUtil.setPageList(customerInfos);
        request.setAttribute("pageModel", pageUtil);
        return "show-customer";
    }





}