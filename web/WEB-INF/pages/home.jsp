<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layout/constant.jspf"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>房地产客户关系管理系统</title>
  <link rel="stylesheet" href="${STATIC_LIB}/bootstrap-3.3.7/dist/css/bootstrap.css">
  <link rel="stylesheet" href="${STATIC_CSS}/home.css">
</head>
<body>
  <div class="container-fluid">
    <!-- 头部 -->
    <%@ include file="/WEB-INF/layout/header.jspf"%>
    <!-- 主要部分 -->
    <div class="row">
      <!-- 菜单 -->
      <nav class="col-lg-2 col-md-2 menu">
        <ul class="one-nav">
          <c:forEach var="menu" items="${menu}">
            <li>
              <h4><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;${menu.name}</h4>
              <ul class="two-nav">
                <c:forEach var="child" items="${menu.child}">
                    <li><a href="${CTX}/${child.url}" target="iframe-view"><i class="fa ${child.icon}"></i>&nbsp;&nbsp;${child.name}</a></li>
                </c:forEach>
              </ul>
            </li>
          </c:forEach>
        </ul>
      </nav>
      <!-- // 菜单 -->
      <section class="col-lg-10 col-md-10 col-sm-12 col-xs-12 main-box">
        <iframe name="iframe-view" scrolling="auto" frameborder="0" width="100%" height="100%"></iframe>
      </section>
    </div>
    <!-- 页脚 -->
    <%@ include file="/WEB-INF/layout/footer.jspf"%>
  </div>
  <script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
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