package com.bdqn.crm.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 参数乱码问题
 */
public class EncodingRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    private String charsetName;
    private Map<String, String[]> map;
    private Enumeration<String> names;

    public EncodingRequest(HttpServletRequest request, String charsetName) {
        super(request);
        this.request = request;
        this.charsetName = charsetName;
        map = getParameterMap();
        names = Collections.enumeration(map.keySet());
    }

    @Override
    //处理get请求中参数的键的乱码问题
    public Enumeration<String> getParameterNames() {
        return names;
    }

    @Override
    public String getParameter(String name) {
        // 通过getParameterMap方法完成
        String[] values = getParameterValues(name);
        if (values == null) {
            return null;
        }
        return values[0];
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = map.get(name);
        return values;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, String[]> map = new HashMap<>(parameterMap.size());
        for (Map.Entry<String, String[]> entries : parameterMap.entrySet()) {
            String key = entries.getKey();//获取参数的key
            String[] values = entries.getValue();
            try {
                //处理get请求中参数的键的乱码问题
                key = new String(key.getBytes("ISO-8859-1"), charsetName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //处理get请求中参数的值的乱码问题
            if (values != null && values.length > 0) {
                for (int i = 0; i < values.length; i++) {
                    try {
                        // values是一个地址
                        values[i] = new String(values[i].getBytes("ISO-8859-1"), charsetName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            map.put(key, values);
        }
        return map;
    }
}