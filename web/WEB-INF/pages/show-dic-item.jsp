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
    <h1 class="son-title">列表信息</h1>
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
                    <td>名称</td>
                    <td>描述</td>
                    <td>状态</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach varStatus="v" items="${pageUtil.pageList}" var="dicItem">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${(pageUserList.thisPage-1)*pageUserList.pageSize+v.count}</td>
                    <td>${dicItem.name}</td>
                    <td>${dicItem.remark }</td>
                    <td>${dicItem.used == 0 ? '有效':'无效'}</td>
                    <td>
                        <a href="#" data-toggle="modal" data-target="#modifyModel">编辑</a>
                        <span>&nbsp;|&nbsp;</span>
                        <a href="#" data-toggle="modal" data-target="#deleteModel">删除</a>
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
                <li><a href="${CTX}/user?command=showUser&thisPage=${pageUtil.thisPage-1}">&larr; 上一页</a></li>
            </c:if>
            <c:if test="${pageUtil.thisPage < pageUtil.totalPage}">
                <li><a href="${CTX}/user?command=showUser&thisPage=${pageUtil.thisPage+1}">下一页 &rarr;</a></li>
            </c:if>
        </ul>
    </div>
  </div>
  <!-- 新增模态框 -->
  <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title" id="myModalLabel">新增字典列表信息</h4>
              </div>
              <form action="${CTX}/dic?command=saveItem" method="post">
                  <div class="modal-body">
                        <div class="form-group">
                            <label>字典类型</label>
                            <select class="form-control" name="typeId">
                                <option value="0">客户来源</option>
                                <option value="1">否</option>
                            </select>
                        </div>
                        <div class="form-group">
                              <label>名称</label>
                              <input type="text" name="name" class="form-control" placeholder="名称">
                          </div>
                          <div class="form-group">
                              <label>描述</label>
                              <input type="text" name="remark" class="form-control" placeholder="描述">
                          </div>
                          <div class="form-group">
                              <label>是否激活</label>
                              <select class="form-control" name="used">
                                  <option value="0">是</option>
                                  <option value="1">否</option>
                              </select>
                          </div>

                  </div>
                  <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                      <button type="submit" class="btn btn-primary">提交更改</button>
                  </div>
              </form>
          </div><!-- /.modal-content -->
      </div><!-- /.modal -->
  </div>
  <!-- 详情模态框 -->
  <div class="modal fade" id="modifyModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title" >查看详情/修改</h4>
              </div>
              <div class="modal-body">
                  <form action="${CTX}/user?command=save" method="post">
                      <div class="form-group">
                          <label>角色名</label>
                          <select class="form-control" name="roleName">
                              <option value="0">管理员</option>
                              <option value="1">普通用户</option>
                          </select>
                      </div>
                      <div class="form-group">
                          <label>是否激活</label>
                          <select class="form-control" name="used">
                              <option value="0">是</option>
                              <option value="1">否</option>
                          </select>
                      </div>
                  </form>
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                  <button type="button" class="btn btn-primary">提交更改</button>
              </div>
          </div><!-- /.modal-content -->
      </div><!-- /.modal -->
  </div>
  <!-- 删除模态框 -->
  <div class="modal fade" id="deleteModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                      &times;
                  </button>
                  <h4 class="modal-title" id="myModalLabel2">
                      删除数据
                  </h4>
              </div>
              <div class="modal-body">
                  <span class="glyphicon glyphicon-trash"></span>&nbsp;确定要删除吗？
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">取消
                  </button>
                  <a class="btn btn-primary" id="actionDelete" href="#">确定</a>
              </div>
          </div><!-- /.modal-content -->
      </div><!-- /.modal -->
  </div>
  <!--// 删除-->
  <script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
  <script type="text/javascript" src="${STATIC_LIB}/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
  <script  type="text/javascript" >
      // 删除一条数据
      function deleteOne(userId) {
          $("#actionDelete").attr("href","${CTX}/user?command=deleteOne&userId="+userId);
      }
      $(function () {
          // 编辑提示
          $("[data-toggle='tooltip']").tooltip();
          //全选与反选方式二
          $("#totalCB").click(function() {
              var flag = this.checked;
              $(":checkbox[type='checkbox']").attr('checked',flag);
          });
          //而且还实现了:当其中不勾选某一个选项的时候,则去掉全选复选框
          $(":checkbox[type='checkbox']").click(function(){
              $("#totalCB").attr('checked',
              $(":checkbox[type='checkbox']").length==$(":checkbox[type='checkbox']:checked").length);
          });
      });
  </script>
</body>
</html>