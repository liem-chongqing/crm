<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>房地产客户关系管理系统</title>
  <link rel="stylesheet" href="static/lib/bootstrap-3.3.7/dist/css/bootstrap.css">
  <link rel="stylesheet" href="static/css/home.css">
</head>
<body>
  <div class="container-fluid">
    <!-- 头部 -->
    <%@ include file="/WEB-INF/layout/header.jspf"%>
    <!-- 主要部分 -->
    <div class="row">
      <nav class="col-lg-2 col-md-2 menu">
        <ul class="one-nav">
          <li>
            <h4><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;用户管理</h4>
            <ul class="two-nav">
              <li><a href="<%=request.getContextPath() %>${menu2.url}" target="iframe-view"><i class="fa ${menu2.icon}"></i>&nbsp;&nbsp;2</a></li>
            </ul>
          </li>
          <li>
            <h4><i class="glyphicon glyphicon-road"></i>&nbsp;&nbsp;房产管理</h4>
            <ul class="two-nav">
              <li><a href="<%=request.getContextPath() %>${menu2.url}" target="iframe-view"><i class="fa ${menu2.icon}"></i>&nbsp;&nbsp;2</a></li>
            </ul>
          </li>
        </ul>
      </nav>
      <section class="col-lg-10 col-md-10 col-sm-12 col-xs-12 main-box">
        <iframe name="iframe-view" scrolling="auto" frameborder="0" width="100%" height="100%"></iframe>
      </section>
    </div>
    <!-- 页脚 -->
    <%@ include file="/WEB-INF/layout/footer.jspf"%>
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