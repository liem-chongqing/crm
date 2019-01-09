package com.bdqn.crm.filter;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 权限验证拦截
 */
public class AuthorFilter implements Filter {

    private static final String AUTHOR_URI = "AUTHOR_URI";

    private String logonPage;

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI()+"?"+req.getQueryString();
        String[] str = logonPage.split(";");
        for(int i=0; i<str.length; i++){
            if (uri.contains(str[i])) {
                chain.doFilter(request, response);
                return;
            }
        }
        // 如果访问的不是登录页面，则判断用户是否已经登录
        HttpSession session = req.getSession();
        if (null != session.getAttribute("user") && "" != session.getAttribute("user")) {
            chain.doFilter(request, response);
            return;
        } else {
            req.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        // 从部署描述符中获取登录页面和首页的URI
        logonPage = config.getInitParameter(AUTHOR_URI);
        if (null == logonPage) {
            throw new ServletException("没有找到登录页面或主页");
        }
    }

}