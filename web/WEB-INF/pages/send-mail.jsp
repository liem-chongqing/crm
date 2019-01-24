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
        .base-info{ height: 40px; padding-bottom: 10px; padding-top: 10px}
    </style>
</head>
<body>
<div class="container-main">
    <h1 class="son-title">发邮件</h1>
    <div class="col-md-12 col-sm-12">
        <form action="${CTX}/mail?command=send" method="post">
            <div class="form-group">
                <label>接收人</label>
                <select class="form-control" name="customerId" >
                    <c:forEach items="${customers}" var="customer">
                        <option value="${customer.id},${customer.email}">${customer.email}（${customer.name}）</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>主题</label>
                <input type="text" name="theme" class="form-control" placeholder="主题">
            </div>
            <div class="form-group">
                <label>内容</label>
                <textarea name="content" class="form-control" placeholder="内容"></textarea>
            </div>
            <div class="form-group">
                <label>邮件状态</label>
                <select class="form-control" name="state">
                    <option value="0">立即发送</option>
                    <option value="1">暂不发送</option>
                </select>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-success">
                <input type="reset" class="btn btn-success">
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
</body>
</html>