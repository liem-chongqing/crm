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
    <h1 class="son-title">房屋信息</h1>
    <div class="search-box">
      <button class="btn btn-success btn-sm" data-toggle="modal" data-target="#addModal">新增</button>
      <button class="btn btn-success btn-sm" data-toggle="modal" data-target="#deleteModel">批量删除</button>
    </div>
    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered text-center">
            <thead>
                <tr>
                    <td><input id="totalCB" type="checkbox"></td>
                    <td>序号</td>
                    <td>房屋类型</td>
                    <td>所属员工</td>
                    <td>地址</td>
                    <td>价格</td>
                    <td>环境描述</td>
                    <td>状态</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach varStatus="v" items="${pageUtil.pageList}" var="house">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${(pageUserList.thisPage-1)*pageUserList.pageSize+v.count}</td>
                    <td>${house.typeName}</td>
                    <td>${house.userName ==null ? "未指定": house.userName}</td>
                    <td>${house.address}</td>
                    <td>${house.price}元/平方</td>
                    <td>${house.ambient}</td>
                    <td>${house.used == 0 ? '有效':'无效'}</td>
                    <td>
                        <span data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-placement="bottom" title="查看/编辑"></span></span>
                        <span>&nbsp;</span>
                        <span onclick="deleteOne('houser_info',${house.id})" data-toggle="modal" data-target="#deleteData" ><span class="glyphicon glyphicon-trash"  data-toggle="tooltip" data-placement="bottom" title="删除"></span></span>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="page">
        <div class="page-info">当前是第${pageUtil.thisPage}页，共${pageUtil.totalPage}页，共${pageUtil.totalNum}条数据</div>
        <ul class="pager">
            <c:if test="${pageUtil.thisPage > 1}">
                <li><a href="${CTX}/house?command=showHouseInfo&thisPage=${pageUtil.thisPage-1}">&larr; 上一页</a></li>
            </c:if>
            <c:if test="${pageUtil.thisPage < pageUtil.totalPage}">
                <li><a href="${CTX}/house?command=showHouseInfo&thisPage=${pageUtil.thisPage+1}">下一页 &rarr;</a></li>
            </c:if>
        </ul>
    </div>
  </div>
  <script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
  <script type="text/javascript" src="${STATIC_LIB}/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
  <%@ include file="/WEB-INF/layout/delete-model.jspf"%>
</body>
</html>