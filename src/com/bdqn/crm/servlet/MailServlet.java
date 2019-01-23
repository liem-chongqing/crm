package com.bdqn.crm.servlet;



import com.bdqn.crm.dto.EmailInfoDto;
import com.bdqn.crm.entity.CustomerInfo;
import com.bdqn.crm.entity.EmailInfo;
import com.bdqn.crm.entity.UserInfo;
import com.bdqn.crm.service.CommonService;
import com.bdqn.crm.service.CustomerService;
import com.bdqn.crm.service.MailService;
import com.bdqn.crm.service.impl.CommonServiceImpl;
import com.bdqn.crm.service.impl.CustomerServiceImpl;
import com.bdqn.crm.service.impl.MailServiceImpl;
import com.bdqn.crm.util.PageUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 邮箱模块
 */
@WebServlet("/mail")
public class MailServlet extends BaseServlet {

    /**
     * 显示发送邮件页面
     * @param request
     * @param response
     * @return
     */
    public String showSend(HttpServletRequest request, HttpServletResponse response){
        // 查询所有邮箱不为空的客户信息
        CustomerService customerService = new CustomerServiceImpl();
        List<CustomerInfo> customers = customerService.findCustomerEmailNotNull();
        request.setAttribute("customers", customers);
        return  "send-mail";
    }


    /**
     * 发送邮件
     * @param request
     * @param response
     * @return
     */
    public String send(HttpServletRequest request, HttpServletResponse response){
        String customer = request.getParameter("customerId");
        String theme = request.getParameter("theme");
        String content = request.getParameter("content");
        String state = request.getParameter("state");
        MailService mailService = new MailServiceImpl();
        String customerId = customer.split(",")[0];
        // 执行发送邮件

        // 保存邮件信息
        EmailInfo emailInfo = new EmailInfo();
        emailInfo.setCustomerId(Long.parseLong(customerId));
        emailInfo.setContent(content);
        emailInfo.setTheme(theme);
        emailInfo.setState(3);
        emailInfo.setTime(new Date());
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute("user");
        emailInfo.setUserId(userInfo.getId());
        int result = mailService.savaSendInfo(emailInfo);
        return "redirect:mail?command=showMail";
    }


    /**
     * 查看邮件
     * @param request
     * @param response
     * @return
     */
    public String showMail(HttpServletRequest request, HttpServletResponse response){
        MailService mailService = new MailServiceImpl();
        CommonService commonService = new CommonServiceImpl();
        PageUtil<EmailInfoDto> pageUtil = new PageUtil<>();
        // 查询数据库总条数
        int totalNumber = commonService.getTotalNumber("email_info");
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
        List<EmailInfoDto> emailList = mailService.findPageAllEmail((pageUtil.getThisPage()-1) * pageUtil.getPageSize(), pageUtil.getPageSize());
        pageUtil.setPageList(emailList);
        request.setAttribute("pageUtil", pageUtil);
        System.out.println("emailList:>"+emailList);
        return "show-mail";
    }

}