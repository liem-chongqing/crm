package com.bdqn.crm.servlet;

import com.bdqn.crm.constant.Constants;
import com.bdqn.crm.dao.HouseDao;
import com.bdqn.crm.dto.HouseInfoDto;
import com.bdqn.crm.entity.DicItem;
import com.bdqn.crm.entity.HouseInfo;
import com.bdqn.crm.entity.UserInfo;
import com.bdqn.crm.service.CommonService;
import com.bdqn.crm.service.DicService;
import com.bdqn.crm.service.HouseService;
import com.bdqn.crm.service.UserService;
import com.bdqn.crm.service.impl.CommonServiceImpl;
import com.bdqn.crm.service.impl.DicServiceImpl;
import com.bdqn.crm.service.impl.HouseServiceImpl;
import com.bdqn.crm.service.impl.UserServiceImpl;
import com.bdqn.crm.util.PageUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 房屋模块
 */
@WebServlet("/house")
public class HouseServlet extends BaseServlet {

    /**
     * 跳转到添加房屋视图
     * @param request
     * @param response
     * @return
     */
    public String add(HttpServletRequest request, HttpServletResponse response){
        DicService dicService = new DicServiceImpl();
        UserService userService = new UserServiceImpl();
        // 客户来源 CUSTOMER_SOURCE
        List<DicItem> types = dicService.findDicType("HOUSE_TYPE");
        List<UserInfo> userInfos = userService.findAllUserByEnable(Constants.State.ENABLE);
        request.setAttribute("types", types);
        request.setAttribute("userInfos", userInfos);
        return  "add-houser";
    }

    /**
     * 新增：保存房屋信息
     * @param request
     * @param response
     * @return
     */
    public String save(HttpServletRequest request, HttpServletResponse response){
        HouseInfo houseInfo = parameterBean(request, HouseInfo.class);
        HouseService houseService = new HouseServiceImpl();
        int result = houseService.save(houseInfo);
        return "redirect:house?command=showHouseInfo";
    }


    public String showHouseInfo(HttpServletRequest request, HttpServletResponse response){
        CommonService commonService = new CommonServiceImpl();
        HouseService houseService = new HouseServiceImpl();
        PageUtil<HouseInfoDto> pageUtil = new PageUtil<>();
        // 查询数据库总条数
        String sql =  "SELECT COUNT(id) AS total FROM houser_info ";
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
        List<HouseInfoDto> houseList = houseService.findPageAllUser((pageUtil.getThisPage()-1) * pageUtil.getPageSize(), pageUtil.getPageSize());
        pageUtil.setPageList(houseList);
        request.setAttribute("pageUtil", pageUtil);
        return "show-houser";
    }

}
