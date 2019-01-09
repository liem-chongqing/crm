package com.bdqn.crm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 解决请求乱码通用的过滤器程序
 */
public class EncodingFilter implements Filter {
    // 设置过滤器使用的编码为utf-8
    private String charsetName = "UTF-8";

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("开始过滤请求数据的编码……");
        // 转型为与协议相关对象
        HttpServletRequest req = (HttpServletRequest) request;
        // 获取请求方法
        String method = req.getMethod();
        if ("post".equalsIgnoreCase(method)) {
            // 解决post
            req.setCharacterEncoding(charsetName);
        } else {
            // 解决get请求
            req = new EncodingRequest(req, charsetName);
        }
        // 解决响应乱码
        response.setContentType("text/html; charset=" + charsetName);// 设置响应数据和响应的页面编码格式
        chain.doFilter(req, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}