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
        <h1 class="son-title">新增客户</h1>
        <div class="col-md-12 col-sm-12">
            <div class="search-box">
            </div>
            <form action="${CTX}/customer?command=save" method="post">
                <div class="form-group">
                    <label>客户状态</label>
                    <select class="form-control" name="conditionId">
                        <c:forEach items="${conditions}" var="condition">
                            <option value="${condition.id}">${condition.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>客户来源</label>
                    <select class="form-control" name="sourceId">
                        <c:forEach items="${sources}" var="source">
                            <option value="${source.id}">${source.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>客户类型</label>
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
                    <label>客户姓名</label>
                    <input type="text" name="name" class="form-control" placeholder="客户姓名">
                </div>
                <div class="form-group">
                    <label>客户性别</label>
                    <select class="form-control" name="sex">
                        <option value="0">男</option>
                        <option value="1">女</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>客户移动电话</label>
                    <input type="text" name="mobile" class="form-control" placeholder="手机号码">
                </div>
                <div class="form-group">
                    <label>客户QQ</label>
                    <input type="text" name="qq" class="form-control" placeholder="QQ号码">
                </div>
                <div class="form-group">
                    <label>客户地址</label>
                    <input type="text" name="address" class="form-control" placeholder="长居住地址">
                </div>
                <div class="form-group">
                    <label>客户邮箱</label>
                    <input type="text" name="email" class="form-control" placeholder="客户邮箱">
                </div>

                <div class="form-group">
                    <label>客户职位</label>
                    <input type="text" name="job" class="form-control" placeholder="职位">
                </div>
                <div class="form-group">
                    <label>客户微博</label>
                    <input type="text" name="blog" class="form-control" placeholder="微博">
                </div>
                <div class="form-group">
                    <label>客户固话</label>
                    <input type="text" name="tel" class="form-control" placeholder="固定电话">
                </div>
                <div class="form-group">
                    <label>客户微信</label>
                    <input type="text" name="wechat" class="form-control" placeholder="微信">
                </div>
                <div class="form-group">
                    <label>客户生日</label>
                    <input type="date" name="birthDay" class="form-control" placeholder="生日">
                </div>
                <div class="form-group">
                    <label>客户公司</label>
                    <input type="text" name="company" class="form-control" placeholder="公司名称">
                </div>
                <div class="form-group">
                    <label>备注</label>
                    <input type="text" name="remark" class="form-control" placeholder="备注信息">
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