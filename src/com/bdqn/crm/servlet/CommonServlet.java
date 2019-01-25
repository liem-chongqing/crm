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
import com.bdqn.crm.util.PageUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 共用模块
 */
@WebServlet("/common")
public class CommonServlet extends BaseServlet {


    /**
     * 数据统计
     * @param request
     * @param response
     * @return
     */
    public String dataTotal(HttpServletRequest request, HttpServletResponse response){
        CommonService commonService = new CommonServiceImpl();
        // 统计总员工数
        Integer userTotal = commonService.totalNumberByTableName("user_info");
        // 统计总客户数
        Integer customerTotal = commonService.totalNumberByTableName("customer_info");
        // 统计总房屋数
        Integer houseTotal = commonService.totalNumberByTableName("houser_info");
        // 统计总公告数
        Integer noticeTotal = commonService.totalNumberByTableName("notice_info");
        // 统计总邮件数
        Integer mailTotal = commonService.totalNumberByTableName("email_info");
        request.setAttribute("userTotal", userTotal);
        request.setAttribute("customerTotal", customerTotal);
        request.setAttribute("houseTotal", houseTotal);
        request.setAttribute("noticeTotal", noticeTotal);
        request.setAttribute("mailTotal", mailTotal);
        return  "show-home";
    }



    /**
     * 根据ID删除数据和表名删除数据
     * @param request
     * @param response
     * @return
     */
    public String deleteOne(HttpServletRequest request, HttpServletResponse response){
        CommonService commonService = new CommonServiceImpl();
        String tableName = request.getParameter("code");
        String id = request.getParameter("id");
        if(null != id){
            int result = commonService.deleteOneById(tableName,Long.parseLong(id));
        }
        switch (tableName){
            case "customer_info":
                return "redirect:customer?command=showCustomer";
            case "user_info":
                return "redirect:user?command=showUser";
            case "dic_type":
                return "redirect:dic?command=getAllType";
            case "dic_item":
                return "redirect:dic?command=getAllItem";
            case "houser_info":
                return "redirect:house?command=showHouseInfo";
            case "notice_info":
                return "redirect:notice?command=showNotice";
            case "email_info":
                return "redirect:mail?command=showMail";
            case "customer_care":
                return "redirect:customer?command=showCare";
            case "customer_linkreord":
                return "redirect:customer?command=showLinkreord";
            case "customer_linkman":
                return "redirect:customer?command=showLinkman";
        }
        return "redirect:login.jsp";
    }

    /**
     * 批量删除
     * @param request
     * @param response
     * @return
     */
    public String deleteBatch(HttpServletRequest request, HttpServletResponse response){
        CommonService commonService = new CommonServiceImpl();
        String tableName = request.getParameter("code");
        String ids = request.getParameter("ids");
        int result = commonService.deleteBatch(tableName, ids);
        switch (tableName){
            case "customer_info":
                return "redirect:customer?command=showCustomer";
            case "user_info":
                return "redirect:user?command=showUser";
            case "dic_type":
                return "redirect:dic?command=getAllType";
            case "dic_item":
                return "redirect:dic?command=getAllItem";
            case "houser_info":
                return "redirect:house?command=showHouseInfo";
            case "notice_info":
                return "redirect:notice?command=showNotice";
            case "email_info":
                return "redirect:mail?command=showMail";
            case "customer_care":
                return "redirect:customer?command=showCare";
            case "customer_linkreord":
                return "redirect:customer?command=showLinkreord";
            case "customer_linkman":
                return "redirect:customer?command=showLinkman";
        }
        return "redirect:login.jsp";
    }



    /**
     * 修改数据
     * @param request
     * @param response
     * @return
     */
    public String modifyData(HttpServletRequest request, HttpServletResponse response){
        String code = request.getParameter("code");
        switch (code){
            case "customer":
                CustomerInfo customerInfo = parameterBean(request, CustomerInfo.class);
                if(null != customerInfo.getId()){
                    HttpSession session = request.getSession();
                    UserInfo userInfo = (UserInfo) session.getAttribute("user");
                    customerInfo.setUpdateMan(userInfo.getName());
                    customerInfo.setUpdateTime(new Date());
                    CommonService commonService = new CommonServiceImpl();
                    commonService.update("customer_info", customerInfo);
                }
                return "redirect:customer?command=showCustomer";
            default:
                return "redirect:login.jsp";
        }
    }
}