package com.bdqn.crm.servlet;

import com.bdqn.crm.constant.Constants;
import com.bdqn.crm.dto.HouseInfoDto;
import com.bdqn.crm.dto.NoticeInfoDto;
import com.bdqn.crm.entity.DicItem;
import com.bdqn.crm.entity.HouseInfo;
import com.bdqn.crm.entity.NoticeInfo;
import com.bdqn.crm.entity.UserInfo;
import com.bdqn.crm.service.*;
import com.bdqn.crm.service.impl.*;
import com.bdqn.crm.util.PageUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/notice")
public class NoticeServlet extends BaseServlet {


    /**
     * 保存新增公告信息
     * @param request
     * @param response
     * @return
     */
    public String save(HttpServletRequest request, HttpServletResponse response){
        NoticeInfo noticeInfo = parameterBean(request, NoticeInfo.class);
        System.out.println("noticeInfo+"+noticeInfo);
        NoticeService noticeService = new NoticeServiceImpl();
        noticeService.save(noticeInfo);
        return "redirect:notice?command=showNotice";
    }


    /**
     * 分页查询所有公告信息
     * @param request
     * @param response
     * @return
     */
    public String showNotice(HttpServletRequest request, HttpServletResponse response){
        CommonService commonService = new CommonServiceImpl();
        NoticeService noticeService = new NoticeServiceImpl();
        PageUtil<NoticeInfoDto> pageUtil = new PageUtil<>();
        // 查询数据库总条数
        String sql =  "SELECT COUNT(id) AS total FROM notice_info ";
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
        List<NoticeInfoDto> noticeList = noticeService.findPageAllNotice((pageUtil.getThisPage()-1) * pageUtil.getPageSize(), pageUtil.getPageSize());
        pageUtil.setPageList(noticeList);
        request.setAttribute("pageUtil", pageUtil);
        return "show-notice";
    }

}
