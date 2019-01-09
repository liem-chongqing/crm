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
                    <td>序号</td>
                    <td>编号</td>
                    <td>角色</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>民族</td>
                    <td>身份证</td>
                    <td>邮箱</td>
                    <td>电话</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach varStatus="v" items="${pageUserList.pageList}" var="pageUser">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${(pageUserList.thisPage-1)*pageUserList.pageSize+v.count}</td>
                    <td>${pageUser.num}</td>
                    <td>${pageUser.roleName}</td>
                    <td>${pageUser.name}</td>
                    <td>${pageUser.sex == 0 ? '男':'女'}</td>
                    <td>${pageUser.age}</td>
                    <td>${pageUser.nation}</td>
                    <td>${pageUser.idnum}</td>
                    <td>${pageUser.email }</td>
                    <td>${pageUser.mobile}</td>
                    <td>
                        <a href="">详情</a>
                        <span>|</span>
                        <a href="">编辑</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="page">
        <div class="page-info">当前是第${pageUserList.thisPage}页，共${pageUserList.totalPage}页，共${pageUserList.totalNum}条数据</div>
        <ul class="pager">
            <c:if test="${pageUserList.thisPage > 1}">
                <li><a href="${CTX}/user?command=showUser&thisPage=${pageUserList.thisPage-1}">&larr; 上一页</a></li>
            </c:if>
            <c:if test="${pageUserList.thisPage < pageUserList.totalPage}">
                <li><a href="${CTX}/user?command=showUser&thisPage=${pageUserList.thisPage+1}">下一页 &rarr;</a></li>
            </c:if>

        </ul>
    </div>
  </div>
  <script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
</body>
</html>