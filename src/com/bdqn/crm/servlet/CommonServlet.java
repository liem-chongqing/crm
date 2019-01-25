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
import com.bdqn.crm.util.ExcelUtil;
import com.bdqn.crm.util.PageUtil;
import com.jspsmart.upload.SmartUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    /**
     * 执行上传文件
     */
    public String uploadFile(HttpServletRequest request, HttpServletResponse response){
        try {
            SmartUpload smartUpload = new SmartUpload();
            smartUpload.initialize(this.getServletConfig(), request, response);
            smartUpload.setCharset("UTF-8");
            // 允许上传的类型,多个类型使用豆号分隔,指定文件的上传格式，zip,xlsx,ppt,任何文件都可以
            smartUpload.setAllowedFilesList("xlsx,xls");
            // smartUpload.setDeniedFilesList("exe");
            smartUpload.setMaxFileSize(1024 * 1024 * 10);
            smartUpload.setTotalMaxFileSize(1024 * 1024 * 100);
            smartUpload.upload();
            String uploadPath = this.getServletContext().getRealPath("/");
            // 拼接一个保存图片的位置的路径
            String saveFileDir = File.separator + "uploadIMG" + File.separator + new SimpleDateFormat("yyyyMMdd")
                    .format(new Date()) + File.separator;

            String uploadFilePath = uploadPath + saveFileDir;
            // 在服务器指定位置创建文件
            File uploadFile = new File(uploadFilePath);
            if (!uploadFile.exists()) {
                uploadFile.mkdirs();
            }
            String strNameAdd = UUID.randomUUID() + ".";
            String fileExt = smartUpload.getFiles().getFile(0).getFileExt();
            smartUpload.getFiles().getFile(0).saveAs(uploadFilePath + strNameAdd + fileExt);

            String path = uploadPath+saveFileDir + strNameAdd + fileExt;
            System.out.println("path:" + path);
            System.out.println("开始解析文档~~");
            List<ArrayList<Object>> list = ExcelUtil.excelReader(path,3);
            CommonService commonService = new CommonServiceImpl();
            String tableName = smartUpload.getRequest().getParameter("code");
            int result = commonService.batchAdd(list, tableName);
            switch (tableName){
                case "user_info":
                    return "redirect:user?command=showUser";
            }
        } catch (Exception e) {
            System.err.println("上传失败!");
            e.printStackTrace();
        }
        return  "";
    }
}