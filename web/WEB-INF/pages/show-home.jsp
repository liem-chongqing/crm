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
      background-color: rgba(0,0,0,.7);
      margin-right: 10px;

    }
    .base-info{
        color: white;
    }
    .base-info:last-child{
      margin-right: 0;
    }
    .base-info p:last-child{
        margin-top: 10px;
    }
    .icon-size{
      font-size: 32px;
    }
    .bg-main img{
       position: absolute;
       top: 0;
       width: 100%;
       border: 0;

    }
    .container-main{
       position: fixed;
       left: 0;
       right: 0;
       z-index: 9;
    }
    .notice{
        margin-top: 10px;
        text-align: left;
        height: 30px;
        line-height: 30px;
        padding-left: 10px;
        /*background-color: rgba(0,0,0,.2);*/
        color: red;
        overflow: hidden;
    }
    .notice div.notice-box{
        height: 60px;
        animation: myfirst 3s infinite alternate;
        -moz-animation: myfirst 3s infinite alternate;	/* Firefox */
        -webkit-animation: myfirst 3s infinite alternate;	/* Safari 和 Chrome */
        -o-animation: myfirst 3s infinite alternate;	/* Opera */
    }
    .notice-icon{
        line-height: 30px;
    }
    @keyframes myfirst{
        10% {transform:translateY(0px);
            -ms-transform:translateY(0px); 	/* IE 9 */
            -moz-transform:translateY(0px); 	/* Firefox */
            -webkit-transform:translateY(0px); /* Safari 和 Chrome */
            -o-transform:translateY(0px);}
        60% {transform:translateY(-30px);
            -ms-transform:translateY(-30px); 	/* IE 9 */
            -moz-transform:translateY(-30px); 	/* Firefox */
            -webkit-transform:translateY(-30px); /* Safari 和 Chrome */
            -o-transform:translateY(-30px);}
        100% {transform:translateY(-60px);
            -ms-transform:translateY(-60px); 	/* IE 9 */
            -moz-transform:translateY(-60px); 	/* Firefox */
            -webkit-transform:translateY(-60px); /* Safari 和 Chrome */
            -o-transform:translateY(-60px);}
    }

  </style>
</head>
<body>
    <div class="container-main">
        <div class="notice">
            <div class="notice-box">
            <c:forEach items="${noticeInfos}" var="noticeInfo">
                <p><span class="glyphicon glyphicon-volume-up notice-icon"></span>【&nbsp;<fmt:formatDate type="date"  value="${noticeInfo.time}" />&nbsp;】《${noticeInfo.item}》${noticeInfo.content}</p>
            </c:forEach>
            </div>
        </div>
        <div class="total-info-box">
            <div class="base-info">
                <p><i class="glyphicon glyphicon-user icon-size"></i></p>
                <p>${userTotal}员工人数</p>
            </div>
            <div class="base-info">
                <p><i class="glyphicon glyphicon-lock icon-size"></i></p>
                <p>${customerTotal}客户人数</p>
            </div>
            <div class="base-info">
                <p><i class="glyphicon glyphicon-home icon-size"></i></p>
                <p>${houseTotal}房屋数量</p>
            </div>
            <div class="base-info">
                <p><i class="glyphicon glyphicon-headphones icon-size"></i></p>
                <p>${noticeTotal}公告信息</p>
            </div>
            <div class="base-info">
                <p><i class="glyphicon glyphicon-star icon-size"></i></p>
                <p>${mailTotal}邮件数量</p>
            </div>
        </div>
    </div>
  <div class="bg-main"><img src="${STATIC_IMG}/home-bg.jpg" alt=""></div>
  <!--// 删除-->
  <script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
  <script type="text/javascript" src="${STATIC_LIB}/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
</body>
</html>