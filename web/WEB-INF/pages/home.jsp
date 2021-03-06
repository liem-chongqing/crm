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
          <li><h4><a href="${CTX}/common?command=dataTotal" target="iframe-view"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;控制面板</a></h4></li>
          <c:forEach var="menu" items="${menu}">
            <li>
              <h4><i class="${menu.icon}"></i>&nbsp;&nbsp;${menu.name}</h4>
              <ul class="two-nav">
                <c:forEach var="child" items="${menu.child}">
                  <li><a href="${CTX}/${child.url}" target="iframe-view"><i class="${child.icon}"></i>&nbsp;&nbsp;${child.name}</a></li>
                </c:forEach>
              </ul>
            </li>
          </c:forEach>
        </ul>
      </nav>
      <!-- // 菜单 -->
      <section class="col-lg-10 col-md-10 col-sm-12 col-xs-12 main-box">
        <iframe name="iframe-view" src="${CTX}/common?command=dataTotal" scrolling="auto" frameborder="0" width="100%" height="100%"></iframe>
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
      Date.prototype.Format = function (fmt) { //author: meizz
          var o = {
              "M+": this.getMonth() + 1, //月份
              "d+": this.getDate(), //日
              "h+": this.getHours(), //小时
              "m+": this.getMinutes(), //分
              "s+": this.getSeconds(), //秒
              "q+": Math.floor((this.getMonth() + 3) / 3), //季度
              "S": this.getMilliseconds() //毫秒
          };
          if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
          for (var k in o)
              if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
          return fmt;
      }
      setInterval(function(){
          var now = new Date().Format("yyyy-MM-dd hh:mm:ss");
          $("#sysdatetime").html(now);
      },1000);
  </script>
</body>
</html>