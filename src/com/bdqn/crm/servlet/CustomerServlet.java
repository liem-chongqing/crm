package com.bdqn.crm.servlet;


import com.alibaba.fastjson.JSON;
import com.bdqn.crm.constant.Constants;
import com.bdqn.crm.dto.CustomerCareDto;
import com.bdqn.crm.dto.CustomerInfoDto;
import com.bdqn.crm.dto.CustomerLinkmanDto;
import com.bdqn.crm.dto.CustomerLinkreordDto;
import com.bdqn.crm.entity.*;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * 客户模块
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
        // 获取条件查询参数
        String name = request.getParameter("name") != null ? request.getParameter("name"):"" ;
        String phone = request.getParameter("phone") != null ? request.getParameter("phone"):"" ;
        String conditionId = request.getParameter("conditionId") != null ? request.getParameter("conditionId"):"" ;
        // 分页
        CommonService commonService = new CommonServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        PageUtil<CustomerInfoDto> pageUtil = new PageUtil<>();
        // 查询数据库总条数
        String sql = "SELECT COUNT(id) AS total FROM customer_info WHERE  `name` like ? AND mobile like ?  AND condition_id like ?";
        int totalNumber = commonService.getTotalNumber(sql, "%"+name+"%", "%"+phone+"%", "%"+conditionId+"%");
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
        int thisPageTo = (pageUtil.getThisPage()-1) * pageUtil.getPageSize();
        int pageSize = pageUtil.getPageSize();
        List<CustomerInfoDto> customerInfos = customerService.findPageAllCustomer(thisPageTo,pageSize,name, phone,conditionId);
        pageUtil.setPageList(customerInfos);
        request.setAttribute("pageModel", pageUtil);
        // 返回数据状态
        // 客户状态 CUSTOMER_CONDITION
        DicService dicService = new DicServiceImpl();
        List<DicItem> dicItems3 = dicService.findDicType("CUSTOMER_CONDITION");
        request.setAttribute("dicItems", dicItems3);
        // 查询数据回显
        request.setAttribute("name",name);
        request.setAttribute("phone",phone);
        request.setAttribute("conditionId",conditionId);
        return "show-customer";
    }


    /**
     * 根据id查询客户详情
     * @param request
     * @param response
     * @return
     */
    public void customerInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String customerId = request.getParameter("customerId");
        if(null!=customerId){
            CustomerService customerService = new CustomerServiceImpl();
            CustomerInfoDto customerInfoDto = customerService.getCustomerInfoByCustomerId(Integer.parseInt(customerId));
            PrintWriter out = response.getWriter();
            out.write(JSON.toJSONString(customerInfoDto));
            out.flush();
            out.close();
        }

    }


    /**
     * 显示客户关怀
     * @param request
     * @param response
     * @throws IOException
     */
    public String showCare(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 分页
        CommonService commonService = new CommonServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        PageUtil<CustomerCareDto> pageUtil = new PageUtil<>();
        // 查询数据库总条数
        String sql = "SELECT COUNT(id) AS total FROM customer_care";
        int totalNumber = commonService.getTotalNumber(sql);
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
        int thisPageTo = (pageUtil.getThisPage()-1) * pageUtil.getPageSize();
        int pageSize = pageUtil.getPageSize();
        List<CustomerCareDto> customerCareDtos = customerService.findPageAllCustomerCare(thisPageTo,pageSize);
        pageUtil.setPageList(customerCareDtos);
        request.setAttribute("pageUtil", pageUtil);
        return "show-customer-care";
    }

    /**
     * 查询所有客户信息
     * @param request
     * @param response
     */
    public void getAllCustomerInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CustomerService customerService = new CustomerServiceImpl();
        List<CustomerInfo> customerInfoList = customerService.getAllCustomerInfo();
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(customerInfoList));
        out.flush();
        out.close();
    }

    /**
     * 保存关怀信息
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public String saveCare(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CustomerCare customerCare = parameterBean(request, CustomerCare.class);
        System.out.println("customerCare:"+customerCare);
        CustomerService customerService = new CustomerServiceImpl();
        customerCare.setUsed(Constants.State.ENABLE);
        int result = customerService.saveCare(customerCare);
        return "redirect:customer?command=showCare";
    }

    /**
     * 显示客户联系记录
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public String showLinkreord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 分页
        CommonService commonService = new CommonServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        PageUtil<CustomerLinkreordDto> pageUtil = new PageUtil<>();
        // 查询数据库总条数
        String sql = "SELECT COUNT(id) AS total FROM customer_linkreord";
        int totalNumber = commonService.getTotalNumber(sql);
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
        int thisPageTo = (pageUtil.getThisPage()-1) * pageUtil.getPageSize();
        int pageSize = pageUtil.getPageSize();
        List<CustomerLinkreordDto> CustomerLinkreordDtos = customerService.findPageAllCustomerLinkreord(thisPageTo,pageSize);
        pageUtil.setPageList(CustomerLinkreordDtos);
        request.setAttribute("pageUtil", pageUtil);
        return "show-customer-linkreord";
    }

    /**
     * 保存客户联系记录信息
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public String saveLinkreord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CustomerLinkreord customerLinkreord = parameterBean(request, CustomerLinkreord.class);
        System.out.println("customerCare:"+customerLinkreord);
        CustomerService customerService = new CustomerServiceImpl();
        customerLinkreord.setUsed(Constants.State.ENABLE);
        int result = customerService.saveLinkreord(customerLinkreord);
        return "redirect:customer?command=showLinkreord";
    }

    /**
     * 显示联系人信息
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public String showLinkman(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 分页
        CommonService commonService = new CommonServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        PageUtil<CustomerLinkmanDto> pageUtil = new PageUtil<>();
        // 查询数据库总条数
        String sql = "SELECT COUNT(id) AS total FROM customer_linkman";
        int totalNumber = commonService.getTotalNumber(sql);
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
        int thisPageTo = (pageUtil.getThisPage()-1) * pageUtil.getPageSize();
        int pageSize = pageUtil.getPageSize();
        List<CustomerLinkmanDto> CustomerLinkmanDtos = customerService.findPageAllCustomerLinkman(thisPageTo,pageSize);
        pageUtil.setPageList(CustomerLinkmanDtos);
        request.setAttribute("pageUtil", pageUtil);
        return "show-customer-linkman";
    }

    /**
     * 保存联系人信息
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public String saveLinkman(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CustomerLinkman CustomerLinkman = parameterBean(request, CustomerLinkman.class);
        System.out.println("CustomerLinkman:"+CustomerLinkman);
        CustomerService customerService = new CustomerServiceImpl();
        CustomerLinkman.setUsed(Constants.State.ENABLE);
        int result = customerService.saveLinkman(CustomerLinkman);
        return "redirect:customer?command=showLinkman";
    }

}