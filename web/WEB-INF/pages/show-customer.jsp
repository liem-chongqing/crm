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
    <h1 class="son-title">客户信息</h1>
    <div class="search-box">
        <form action="${CTX}/customer" method="get" class="form-inline">
            <input type="hidden" name="command" value="showCustomer"/>
            <div class="form-group form-group-sm">
                <label >姓名</label>
                <input type="text" name="name" value="${name}" class="form-control" placeholder="请输入客户姓名">
            </div>
            <div class="form-group form-group-sm">
                <label >电话</label>
                <input type="text" name="phone" value="${phone}" class="form-control" placeholder="请输入电话">
            </div>
            <div class="form-group form-group-sm">
                <label >客户状态</label>
                <select class="form-control" name="conditionId">
                    <option value="">-请选择-</option>
                    <c:forEach items="${dicItems}" var="dic">
                        <option value="${dic.id}">${dic.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-default btn-sm">搜索</button>
        </form>
    </div>
    <div class="form-group">
        <button onclick="deleteBatch('customer_info')" class="btn btn-success">批量删除</button>
    </div>
    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered text-center">
            <thead>
                <tr>
                    <td><input id="totalCB" type="checkbox"></td>
                    <td>序号</td>
                    <td>状态</td>
                    <td>来源</td>
                    <td>所属员工</td>
                    <td>类型</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>电话</td>
                    <td>职位</td>
                    <td>生日</td>
                    <td>状态</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach varStatus="v" items="${pageModel.pageList}" var="customer">
                <tr>
                    <td><input value="${customer.id}" type="checkbox"></td>
                    <td>${(pageModel.thisPage-1)*pageModel.pageSize+v.count}</td>
                    <td>${customer.conditionName}</td>
                    <td>${customer.sourceName}</td>
                    <td>${customer.userName ==null ? "未指定": customer.userName}</td>
                    <td>${customer.typeName}</td>
                    <td>${customer.name}</td>
                    <td>${customer.sex==0?"男":"女"}</td>
                    <td>${customer.mobile}</td>
                    <td>${customer.job}</td>
                    <td>${customer.birthDay}</td>
                    <td><span class="label label-info">${customer.used==0?"有效":"无效"}</span></td>
                    <td>
                        <span data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-placement="bottom" title="查看/编辑"></span></span>
                        <span>&nbsp;</span>
                        <span onclick="deleteOne('customer_info',${customer.id})" data-toggle="modal" data-target="#deleteData" ><span class="glyphicon glyphicon-trash"  data-toggle="tooltip" data-placement="bottom" title="删除"></span></span>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="page">
        <div class="page-info">当前是第${pageModel.thisPage}页，共${pageModel.totalPage}页，共${pageModel.totalNum}条数据</div>
        <ul class="pager">
            <c:if test="${pageModel.thisPage > 1}">
                <li><a href="${CTX}/customer?command=showCustomer&thisPage=${pageModel.thisPage-1}&name=${name}&phone=${phone}&conditionId=${conditionId}">&larr; 上一页</a></li>
            </c:if>
            <c:if test="${pageModel.thisPage < pageModel.totalPage}">
                <li><a href="${CTX}/customer?command=showCustomer&thisPage=${pageModel.thisPage+1}&name=${name}&phone=${phone}&conditionId=${conditionId}">下一页 &rarr;</a></li>
            </c:if>
        </ul>
    </div>

  </div>

  <script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
  <script type="text/javascript" src="${STATIC_LIB}/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
  <%@ include file="/WEB-INF/layout/delete-model.jspf"%>
</body>
</html>