package com.bdqn.crm.servlet;


import com.bdqn.crm.entity.UserInfo;
import com.bdqn.crm.service.UserService;
import com.bdqn.crm.service.impl.UserServiceImpl;
import com.bdqn.crm.util.MenuUtil;
import org.junit.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import com.uwang.pagedemo.entity.PageUtil;

/**
 * 用户模块
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {

    public String addUser(HttpServletRequest request, HttpServletResponse response){
        return "add-user";
    }

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
     * 外部访问URI:  /user?command=reg
     * 重置密码
     * @return
     */
    @Test
    public void add(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(100L);
        userInfo.setNum("100001");
        userInfo.setAddress("重庆市店家的");
        userInfo.setAge(15);
        userInfo.setBankCard("500232312");
        userInfo.setCreateTime(new Date());
        UserService userService = new UserServiceImpl();
        userService.addUser(userInfo);
//        return  "";
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
        return  "login";
    }



    /**
     * 登出
     * @param request
     * @param response
     * @return
     */
    public String out(HttpServletRequest request, HttpServletResponse response){
        request.getSession().invalidate();
        return LOGIN;
    }
}