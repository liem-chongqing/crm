package com.bdqn.crm.servlet;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    public final static String PATH = "/WEB-INF/pages/";
    public final static String COMMAND = "command";
    public final static String SUFFIX = ".jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        String command = req.getParameter(COMMAND);
        try {
            Class clazz = this.getClass();
            Method method = clazz.getMethod(command, HttpServletRequest.class,HttpServletResponse.class);
            String path = (String) method.invoke(this, req, resp);
            if(path!=null && !"".equals(path)) {
                req.getRequestDispatcher(PATH.concat(path).concat(SUFFIX)).forward(req, resp);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
