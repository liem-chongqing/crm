package com.bdqn.crm.servlet;


import com.bdqn.crm.entity.UserInfo;
import com.bdqn.crm.service.UserService;
import com.bdqn.crm.service.impl.UserServiceImpl;
import com.bdqn.crm.util.MenuUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import com.bdqn.crm.util.StringsUtil;
import com.bdqn.crm.util.PageUtil;

/**
 * 用户模块
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {

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
        UserService userService = new UserServiceImpl();
        PageUtil<UserInfo> pageUtil = new PageUtil<>();
        // 查询数据库总条数
        int totalNumber = userService.getTotalNumber();
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
        List<UserInfo> userList = userService.findPageAllUser((pageUtil.getThisPage()-1) * pageUtil.getPageSize(), pageUtil.getPageSize());
        pageUtil.setPageList(userList);
        request.setAttribute("pageUserList", pageUtil);
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
        String code = req.getParameter("code");
        String password = req.getParameter("password");
        UserService userService = new UserServiceImpl();
        UserInfo user = userService.login(code, password);
        System.out.println(user);
        if(null != user){
            HttpSession session = req.getSession();
            // 管理员菜单
            req.setAttribute("menu", MenuUtil.getSysMenu(MenuUtil.SYS_MENU));
            session.setAttribute("user", user);
            return "home";
        }
        return  "redirect:login.jsp";
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