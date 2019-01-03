<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>房地产客户关系管理系统</title>
    <link rel="stylesheet" href="static/lib/bootstrap-3.3.7/dist/css/bootstrap.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/home.css"/>
  </head>
<body>
<%@ include file="/WEB-INF/layout/header.jspf" %>
<section class="content">
  <div class="menu-nav">
    <ul class="one-nav">
        <li>
          <h4><i class="fa ${menu.icon}"></i>&nbsp;&nbsp;1</h4>
          <ul class="two-nav">
              <li><a href="<%=request.getContextPath() %>${menu2.url}" target="iframe-view"><i class="fa ${menu2.icon}"></i>&nbsp;&nbsp;2</a></li>
          </ul>
        </li>
      <li>
        <h4><i class="fa ${menu.icon}"></i>&nbsp;&nbsp;2</h4>
        <ul class="two-nav">
            <li><a href="<%=request.getContextPath() %>${menu2.url}" target="iframe-view"><i class="fa ${menu2.icon}"></i>&nbsp;&nbsp;2</a></li>
        </ul>
      </li>
    </ul>
  </div>
  <div class="view-main">
    <iframe name="iframe-view" scrolling="auto" frameborder="0" width="100%" height="100%"></iframe>
  </div>
</section>
<div class="footer-wrap">
  <footer>Copyright © 2018-2019 Y04 All Rights Reserved</footer>
</div>
<script type="text/javascript" src="static/lib/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".one-nav li h4").click(function(){
            $(this).next("ul").slideToggle();
            $(this).parent().siblings().children("ul").slideUp();
        })
    })
</script>
</body>
</html>