package com.bdqn.crm.servlet;


import com.bdqn.crm.entity.User;
import com.bdqn.crm.service.UserService;
import com.bdqn.crm.service.impl.UserServiceImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户模块
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {

    /**
     * 外部访问URI:  /user?command=reg
     * 重置密码
     * @param request
     * @param response
     * @return
     */
    public String reg(HttpServletRequest request, HttpServletResponse response){

        return  "";
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
        User user = userService.login(code, password);
        if(null != user){
            HttpSession session = req.getSession();
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