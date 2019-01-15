<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layout/constant.jspf"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>房地产客户关系管理系统</title>
  <link rel="stylesheet" href="${STATIC_LIB}/bootstrap-3.3.7/dist/css/bootstrap.css">
  <link rel="stylesheet" href="${STATIC_CSS}/user-list.css">
  <style type="text/css">
    .total-info-box{
      display: flex;
      padding: 10px 0;
    }
    .base-info{
      width: 100%;
      padding: 10px 0;
      text-align: center;
      background-color: #EEEEEE;
      margin-right: 10px;

    }
    .base-info:last-child{
      margin-right: 0;
    }
    .icon-size{
      font-size: 32px;
    }
  </style>
</head>
<body>
  <div class="container-main">
    <h1 class="son-title">控制面板</h1>
    <div class="total-info-box">
        <div class="base-info">
          <p><i class="glyphicon glyphicon-user icon-size"></i></p>
          <p>100员工人数</p>
        </div>
        <div class="base-info">
          <p><i class="glyphicon glyphicon-lock icon-size"></i></p>
          <p>客户人数</p>
        </div>
        <div class="base-info">
          <p><i class="glyphicon glyphicon-star icon-size"></i></p>
          <p>员工人数</p>
        </div>
        <div class="base-info">
          <p><i class="glyphicon glyphicon-home icon-size"></i></p>
          <p>10房屋数量</p>
        </div>
        <div class="base-info">
          <p><i class="glyphicon glyphicon-headphones icon-size"></i></p>
          <p>公告信息</p>
        </div>
    </div>
  </div>
  <!--// 删除-->
  <script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
  <script type="text/javascript" src="${STATIC_LIB}/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
</body>
</html>