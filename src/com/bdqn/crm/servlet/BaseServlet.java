package com.bdqn.crm.servlet;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

public class BaseServlet extends HttpServlet {

    protected final static String PATH = "/WEB-INF/pages/";
    protected final static String COMMAND = "command";
    protected final static String SUFFIX = ".jsp";
    protected final static String REDIRECT = "redirect";

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
            if(path.contains(REDIRECT)){
                resp.sendRedirect(req.getContextPath()+"/"+path.split(":")[1]);
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
     * 在Servlet中调用这个方法，自动就可以将request转换为需要的类
     */
    public static <T> T  parameterBean(HttpServletRequest req,Class cls){
        T obj=null;
        try {
            obj= (T)cls.newInstance();
            Enumeration<String> ens=req.getParameterNames();
            while(ens.hasMoreElements()){
                String key=ens.nextElement();
                String val=req.getParameter(key);
                //查找class中对应的setxxx方法
                Method method[]=cls.getDeclaredMethods();
                for(Method m:method){
                    //忽略大小写进行匹配
                    if(m.getName().equalsIgnoreCase("set"+key)){
                        Class pc[]=m.getParameterTypes();
                        if(pc[0].getName().equalsIgnoreCase("float")){
                            m.invoke(obj, Float.parseFloat(val));
                        }else if(pc[0].getName().equalsIgnoreCase("int")){
                            m.invoke(obj, Integer.parseInt(val));
                        }else {
                            m.invoke(obj,val);
                        }
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
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
