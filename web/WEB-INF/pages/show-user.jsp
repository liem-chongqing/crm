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
                <label >工号</label>
                <input type="email" class="form-control" placeholder="请输入工号">
            </div>
            <div class="form-group form-group-sm">
                <label >性别</label>
                <select class="form-control">
                    <option>不限</option>
                    <option>男</option>
                    <option>女</option>
                </select>
            </div>
            <button type="submit" class="btn btn-default btn-sm">搜索</button>
        </form>
    </div>
    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered text-center">
            <thead>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>序号</td>
                    <td>工号</td>
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
                        <a href="#none"  data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-eye-open" title="查看"></span></a>
                        <span>&nbsp;</span>
                        <a href=""><span class="glyphicon glyphicon-pencil" title="修改"></span></a>
                        <span>&nbsp;</span>
                        <a href=""><span class="glyphicon glyphicon-trash" title="删除"></span></a>
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
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
              </div>
              <div class="modal-body">在这里添加一些文本</div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                  <button type="button" class="btn btn-primary">提交更改</button>
              </div>
          </div><!-- /.modal-content -->
      </div><!-- /.modal -->
  </div>
  <script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
  <script type="text/javascript" src="${STATIC_LIB}/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
</body>
</html>