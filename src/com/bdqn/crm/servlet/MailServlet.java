package com.bdqn.crm.servlet;



import com.bdqn.crm.constant.Constants;
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
import com.liem.mail.MailModel;
import com.liem.mail.MailTo;

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
        if(Constants.Email.SEND.equals(state)){
            // 执行发送邮件
            boolean result = actionSendMail(customer.split(",")[1],theme, content);
            System.out.println("邮件发送状态：" +result);
        }
        // 保存邮件信息
        EmailInfo emailInfo = new EmailInfo();
        emailInfo.setCustomerId(Long.parseLong(customerId));
        emailInfo.setContent(content);
        emailInfo.setTheme(theme);
        emailInfo.setState(Integer.parseInt(state));
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
        String sql =  "SELECT COUNT(id) AS total FROM email_info ";
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
        List<EmailInfoDto> emailList = mailService.findPageAllEmail((pageUtil.getThisPage()-1) * pageUtil.getPageSize(), pageUtil.getPageSize());
        pageUtil.setPageList(emailList);
        request.setAttribute("pageUtil", pageUtil);
        System.out.println("emailList:>"+emailList);
        return "show-mail";
    }


    /**
     * 执行发送
     * @param request
     * @param response
     * @return
     */
        public String sendStateMail(HttpServletRequest request, HttpServletResponse response) {
            String mailId = request.getParameter("mailId");
            if (null != mailId) {
                MailService mailService = new MailServiceImpl();
                // 根据ID查询出当条邮件信息
                EmailInfoDto emailInfo = mailService.getEmailInfoByMailId(Integer.parseInt(mailId));
                // 执行发送邮件
                boolean result = actionSendMail(emailInfo.getEmail(), emailInfo.getTheme(), emailInfo.getContent());
                if (result) {
                    int i = mailService.modifyMialSendStateByMailId(Constants.Email.SEND, emailInfo.getId());
                }else{
                    return "redirect:mail?command=showMail";
                }
            }
            return "redirect:mail?command=showMail";
        }




        /**
         * 执行发送邮件
         * @param mailTo
         * @param mailTitle
         * @param content
         */
        public boolean actionSendMail(String mailTo, String mailTitle, String content){
            // 得到MailModel对象
            MailModel mailModel = MailModel.getInstance("mail.properties");
            // 设置收件人
            mailModel.setToAddress(mailTo);
            // 设置邮件标题
            mailModel.setSubject(mailTitle);
            // 设置邮件内容
            mailModel.setContent(content);
            //  这个类主要来发送邮件
            return  MailTo.sendEmail(mailModel, MailTo.SEND_TEXT);
        }

    }