package com.bdqn.crm.servlet;

import com.bdqn.crm.dto.DicItemDto;
import com.bdqn.crm.entity.DicItem;
import com.bdqn.crm.entity.DicType;
import com.bdqn.crm.service.CommonService;
import com.bdqn.crm.service.DicService;
import com.bdqn.crm.service.impl.CommonServiceImpl;
import com.bdqn.crm.service.impl.DicServiceImpl;
import com.bdqn.crm.util.PageUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/dic")
public class DicServlet extends  BaseServlet {


    /**
     * 新增： 保存字典类型
     * @param request
     * @param response
     * @return
     */
    public String saveType(HttpServletRequest request, HttpServletResponse response) {
        // 对象接收参数
        DicType dicType = parameterBean(request, DicType.class);
        DicService dicService = new DicServiceImpl();
        dicService.saveType(dicType);
        return "redirect:dic?command=getAllType";
    }

    /**
     * 新增： 保存字典列表
     * @param request
     * @param response
     * @return
     */
    public String saveItem(HttpServletRequest request, HttpServletResponse response) {
        // 对象接收参数
        DicItem dicItem = parameterBean(request, DicItem.class);
        System.out.println(dicItem);
        DicService dicService = new DicServiceImpl();
        dicService.saveItem(dicItem);
        return "redirect:dic?command=getAllItem";
    }


    /**
     * 获取全部类型
     * @param request
     * @param response
     * @return
     */
    public String getAllType(HttpServletRequest request, HttpServletResponse response){
        DicService dicService = new DicServiceImpl();
        CommonService commonService = new CommonServiceImpl();
        PageUtil<DicType> pageUtil = new PageUtil<>();
        String sql =  "SELECT COUNT(id) AS total FROM dic_type ";
        int totalNumber = commonService.getTotalNumber(sql);
        pageUtil.setTotalNum(totalNumber);
        String thisPage = request.getParameter("thisPage");
        if(null != thisPage){
            pageUtil.setThisPage(Integer.parseInt(thisPage));
        }
        int totalPage = (pageUtil.getTotalNum() -1)/pageUtil.getPageSize()+1;
        pageUtil.setTotalPage(totalPage);

        List<DicType> dicTypes = dicService.getAllType((pageUtil.getThisPage()-1) * pageUtil.getPageSize(), pageUtil.getPageSize());
        pageUtil.setPageList(dicTypes);
        request.setAttribute("pageUtil", pageUtil);
        return "show-dic-type";
    }


    /**
     * 获取全部列表
     * @param request
     * @param response
     * @return
     */
    public String getAllItem(HttpServletRequest request, HttpServletResponse response){
        DicService dicService = new DicServiceImpl();
        CommonService commonService = new CommonServiceImpl();
        PageUtil<DicItemDto> pageUtil = new PageUtil<>();
        String sql =  "SELECT COUNT(id) AS total FROM dic_item ";
        int totalNumber = commonService.getTotalNumber(sql);
        pageUtil.setTotalNum(totalNumber);
        String thisPage = request.getParameter("thisPage");
        if(null != thisPage){
            pageUtil.setThisPage(Integer.parseInt(thisPage));
        }
        int totalPage = (pageUtil.getTotalNum() -1)/pageUtil.getPageSize()+1;
        pageUtil.setTotalPage(totalPage);

        List<DicItemDto> dicItems = dicService.getAllItems((pageUtil.getThisPage()-1) * pageUtil.getPageSize(), pageUtil.getPageSize());
        pageUtil.setPageList(dicItems);
        request.setAttribute("pageUtil", pageUtil);
        // 查询所有客户来源
        List<DicType> dicTypes = dicService.getAllType(0, 99999999);
        request.setAttribute("dicTypes", dicTypes);
        return "show-dic-item";
    }
}
