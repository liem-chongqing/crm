package com.bdqn.crm.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class WebUtil {

    /**
     * 设置json返回数据
     * @return
     */
    public static void setJsonResponse(HttpServletResponse response, String jsonStr){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(jsonStr);
        } catch (Exception e) {
            System.out.println("设置json返回数据失败:"+e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 获取全部url
     * @param request
     * @return
     */
    public static String getRequestURLAll(HttpServletRequest request){
        if (request == null) {
            return "";
        }
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath() + getRequestURL(request);
    }

    /**
     * 获取应用访问url
     * @param request
     * @return
     */
    public static String getRequestWebUrl(HttpServletRequest request){
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath();
    }

    /**
     * 获取url
     * @param request
     * @return
     */
    public static String getRequestURL(HttpServletRequest request) {
        if (request == null) {
            return "";
        }
        String url = "";
        url = request.getServletPath();

        if (!"".equals(request.getQueryString()) && request.getQueryString() != null) {
            url = url + "?" + request.getQueryString();
        }
        return url;
    }

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     *
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     *
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.100
     *
     * 用户真实IP为： 192.168.1.110
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        try {
            String unknown = "unknown";
            String ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            return ip;
        }catch (Exception e) {
            return "";
        }
    }


    /**
     * 在Servlet中调用这个方法，自动就可以将request转换为需要的类
     */
    public static <T> T  parameterObj(HttpServletRequest req,Class cls){
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
     * 获取的参数转换为map
     * @param request
     * @return
     */
    private Map<String, Object> analyseCallbackRequest(HttpServletRequest request){

        Map map = new HashMap<>();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements())
        {
            String paramName = (String) paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1)
            {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0)
                {
                    map.put(paramName, paramValue);
                }

            }
        }
        return map;
    }

}
