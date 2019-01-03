package com.bdqn.crm.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    protected final static String PATH = "/WEB-INF/pages/";
    protected final static String COMMAND = "command";
    protected final static String SUFFIX = ".jsp";
    protected final static String LOGIN = "/login.jsp";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
        String command = req.getParameter(COMMAND);
        this.log(req, resp);
        if(null == command || command.isEmpty()){
            throw new RuntimeException("Not command...");
        }
        try {
            Class clazz = this.getClass();
            Method method = clazz.getMethod(command, HttpServletRequest.class, HttpServletResponse.class);
            String path = (String) method.invoke(this, req, resp);
            if(LOGIN.equals(path)){
                resp.sendRedirect(req.getContextPath()+LOGIN);
                return;
            }
            if(path!=null && !"".equals(path)){
                req.getRequestDispatcher(PATH.concat(path).concat(SUFFIX)).forward(req, resp);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 打印请求信息
     * @param req
     * @param resp
     */
    public void log(HttpServletRequest req, HttpServletResponse resp){
        String parameter = req.getQueryString();
        System.out.println(req.getRequestURL()+"?"+parameter);
    }

}
