<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layout/constant.jspf"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>房地产客户关系管理系统</title>
  <link rel="stylesheet" href="${STATIC_LIB}/bootstrap-3.3.7/dist/css/bootstrap.css">
  <link rel="stylesheet" href="${STATIC_CSS}/user-list.css">
</head>
<body>
  <div class="container-main">
    <div class="search-box">
        <form class="form-inline">
            <div class="form-group form-group-sm">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
            </div>
            <div class="form-group form-group-sm">
                <label for="exampleInputEmail2">工号</label>
                <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
            </div>
            <button type="submit" class="btn btn-default btn-sm">搜索</button>
        </form>
    </div>
    <div class="table-responsive">
        <table class="table table-hover table-bordered text-center">
            <thead>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>编号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>性别</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pageUserList.pageList}" var="pageUser">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${pageUser.num}</td>
                    <td>${pageUser.name}</td>
                    <td>${pageUser.roleName}</td>
                    <td>${pageUser.mobile}</td>
                    <td>${pageUser.sex == 0 ? '男':'女'}</td>
                    <td>${pageUser.age}</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>性别</td>
                    <td>
                        <a href="">详情</a>
                        <span>&nbsp;|&nbsp;</span>
                        <a href="">编辑</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
  </div>
  <script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
</body>
</html>