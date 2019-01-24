<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
  String usernum = "";
  String userpwd = "";
  Cookie[] cookies = request.getCookies();
  for (int i = 0; i < cookies.length; i++) {
    if (cookies[i].getName().equals("cookieUserInfo")) {
      //存着数据（用户名+密码）
      usernum = cookies[i].getValue().split("-")[0];
      userpwd = cookies[i].getValue().split("-")[1];
      //再一次的存起来（备用）
      request.setAttribute("usernum", usernum);
      request.setAttribute("userpwd", userpwd);
    }
  }
%>
<html>
  <head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>房地产客户关系管理系统</title>
    <link rel="stylesheet" href="static/lib/bootstrap-3.3.7/dist/css/bootstrap.css">
    <link rel="stylesheet" href="static/css/common.css">
    <style type="text/css">
      .row{
        display: flex;
        justify-content: center;
      }
      .btn-100{
        width: 100%;

      }
      .logo{
        height: 50px;
        font-size: 16px;
        text-align: center;
        font-weight: bold;
      }
      .checkbox{
        display: flex;
        justify-content: space-between;
      }
      .main-logo{
        width: 90px;
        height: 90px;
        background-image: url("/static/images/logo.jpg");
        background-size: cover;
        margin-top: 90px;
      }
    </style>
  </head>
  <body>
    <div class="container-fluid" >
      <div class="row">
        <div class="logo main-logo"></div>
      </div>
      <div class="row">
        <div class="col-lg-12 logo">微胜房地产CRM</div>
      </div>
      <div class="row">
        <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12">
          <form class="" method="post" action="/user?command=login">
            <div class="form-group">
              <input type="text" name="code" class="form-control" value="${usernum}" placeholder="请输入邮箱/手机号">
            </div>
            <div class="form-group">
              <input type="password" name="password" class="form-control" value="${userpwd}" placeholder="请输入密码">
            </div>
            <div class="checkbox">
              <label>
                <c:if test="${usernum != null}">
                <input name="rememberMe" type="checkbox" checked>记住密码
                </c:if>
                <c:if test="${usernum == null}">
                  <input name="rememberMe" type="checkbox">记住密码
                </c:if>
              </label>
              <a href="" >忘记密码?</a>
            </div>
            <button type="submit" class="btn btn-success btn-100">登录</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
