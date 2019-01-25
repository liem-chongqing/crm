package com.bdqn.crm.servlet;


import com.alibaba.fastjson.JSON;
import com.bdqn.crm.constant.Constants;
import com.bdqn.crm.dto.CustomerInfoDto;
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

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import com.bdqn.crm.util.StringsUtil;
import com.bdqn.crm.util.PageUtil;

/**
 * 用户模块
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {

    /**
     * 初始系统所需信息
     * @param request
     * @param response
     */
    public void initDicInfo(HttpServletRequest request, HttpServletResponse response){
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
        HttpSession session = request.getSession();
        session.setAttribute("sources", dicItems1);
        session.setAttribute("types", dicItems2);
        session.setAttribute("conditions", dicItems3);
        session.setAttribute("userInfos", userInfos);
    }

    public String addUser(HttpServletRequest request, HttpServletResponse response){
        return "add-user";
    }

    /**
     * 新增： 保存用户
     * @param request
     * @param response
     * @return
     */
    public String save(HttpServletRequest request, HttpServletResponse response) {
        // 对象接收参数
        UserInfo userInfo = parameterBean(request, UserInfo.class);
        UserInfo user = (UserInfo) request.getSession().getAttribute("user");
        if(null != user){
            userInfo.setNum("100003");
            userInfo.setPwd("123456");
            userInfo.setUpdateTime(new Date());
            userInfo.setCreateTime(new Date());
            userInfo.setDepartmentName("估计要删");
            userInfo.setCreateMan(user.getName());
            userInfo.setUpdateMan(user.getName());
            userInfo.setAge(StringsUtil.idNOToAge(userInfo.getIdnum()));
            UserService userService = new UserServiceImpl();
            System.out.println(userInfo);
            if(userService.save(userInfo) > 0){
                return "add-success";
            }
        }
        return "add-user";
    }

    /**
     * 查看用户
     * @param request
     * @param response
     * @return
     */
    public String showUser(HttpServletRequest request, HttpServletResponse response){
        // 获取条件查询参数
        String name = request.getParameter("name") != null ? request.getParameter("name"):"" ;
        String num = request.getParameter("num") != null ? request.getParameter("num"):"" ;
        UserService userService = new UserServiceImpl();
        CommonService commonService = new CommonServiceImpl();
        PageUtil<UserInfo> pageUtil = new PageUtil<>();
        // 查询数据库总条数
        String sql = "SELECT COUNT(id) AS total FROM user_info WHERE  num like ? AND `name` like ? ";
        int totalNumber = commonService.getTotalNumber(sql, "%"+num+"%", "%"+name+"%");
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
        int thisPageNo = (pageUtil.getThisPage()-1) * pageUtil.getPageSize();
        int pageSize = pageUtil.getPageSize();
        List<UserInfo> userList = userService.findPageAllUser(thisPageNo, pageSize, num, name);
        pageUtil.setPageList(userList);
        request.setAttribute("pageUserList", pageUtil);
        // 回显查询数据
        request.setAttribute("name",name);
        request.setAttribute("num",num);
        return "show-user";
    }




    /**
     * 外部访问URI:  /user?command=login
     * 用户登录
     * @param req
     * @param resp
     * @return
     */
    public String login(HttpServletRequest req, HttpServletResponse resp) {
        String rememberMe = req.getParameter("rememberMe");
        String code = req.getParameter("code");
        String password = req.getParameter("password");
        UserService userService = new UserServiceImpl();
        UserInfo user = userService.login(code, password);
        System.out.println(user);
        if(null != user){
            // 记住密码
            if("on".equals(rememberMe)){
                Cookie cookie = new Cookie("cookieUserInfo",code+"-"+password);
                // 设置过期时间
                cookie.setMaxAge(60 * 24);
                // 存储
                resp.addCookie(cookie);
            }else{
                Cookie cookie = new Cookie("cookieUserInfo","");
                resp.addCookie(cookie);
            }

            HttpSession session = req.getSession();
            // 管理员菜单
            if(Constants.Role.BASE_UESR.equals(user.getRoleName())){
                req.setAttribute("menu", MenuUtil.getSysMenu(MenuUtil.BASE_MENU));
            }else{
                req.setAttribute("menu", MenuUtil.getSysMenu(MenuUtil.SYS_MENU));
            }
            session.setAttribute("user", user);
            // 初始化数据字典信息
            initDicInfo(req, resp);
            return "home";
        }
        return  "redirect:login.jsp";
    }


    /**
     * 根据id查询用户的信息
     * @param request
     * @param response
     */
    public void userInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        if(null!=userId){
            UserService userService = new UserServiceImpl();
            UserInfo userInfo = userService.getUserInfoByuserId(Long.parseLong(userId));
            System.out.println("userInfo:"+userInfo);
            PrintWriter out = response.getWriter();
            out.write(JSON.toJSONString(userInfo));
            out.flush();
            out.close();
        }
    }


    /**
     * 登出
     * @param request
     * @param response
     * @return
     */
    public String out(HttpServletRequest request, HttpServletResponse response){
        request.getSession().invalidate();
        return "redirect:login.jsp";
    }
}