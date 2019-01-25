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
    <h1 class="son-title">新增房屋信息</h1>
    <div class="col-md-12 col-sm-12">
        <div class="search-box">
        </div>
        <form action="${CTX}/house?command=save" method="post">
            <div class="form-group">
                <label>房屋类型</label>
                <select class="form-control" name="typeId">
                    <c:forEach items="${types}" var="type">
                        <option value="${type.id}">${type.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>跟踪（负责）员工</label>
                <select class="form-control" name="userId">
                    <option value="-1">暂不分配</option>
                    <c:forEach items="${userInfos}" var="user">
                        <option value="${user.id}">${user.num}&nbsp;-&nbsp;${user.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>房屋地址</label>
                <input type="text" name="address" class="form-control" placeholder="客户姓名">
            </div>
            <div class="form-group">
                <label>房屋价格</label>
                <input type="text" name="price" class="form-control" placeholder="客户姓名">
            </div>
            <div class="form-group">
                <label>房屋环境描述</label>
                <input type="text" name="ambient" class="form-control" placeholder="手机号码">
            </div>
            <div class="form-group">
                <label>数据状态</label>
                <select class="form-control" name="used">
                    <option value="0">有效</option>
                    <option value="1">无效</option>
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