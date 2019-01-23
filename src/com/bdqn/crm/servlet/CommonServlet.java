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
import java.util.Date;
import java.util.List;

/**
 * 共用模块
 */
@WebServlet("/common")
public class CommonServlet extends BaseServlet {

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
        }
        return "redirect:login.jsp";
    }

    public String showHome(HttpServletRequest request, HttpServletResponse response){
        return  "show-home";
    }
}