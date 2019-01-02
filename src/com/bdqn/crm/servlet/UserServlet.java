package com.bdqn.crm.servlet;


import com.bdqn.crm.entity.User;
import com.bdqn.crm.service.UserService;
import com.bdqn.crm.service.impl.UserServiceImpl;
import com.bdqn.crm.util.WebUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user")
public class UserServlet extends WebUtil {

    public String login(HttpServletRequest req, HttpServletResponse resp) {
        String code = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        UserService userService = new UserServiceImpl();
        User user = userService.login(code, password);
        if(null != user){
            session.setAttribute("user", user);
            return "home";
        }
        return  "login";
    }

}