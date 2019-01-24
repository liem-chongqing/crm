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
    <h1 class="son-title">客户关怀</h1>
    <div class="search-box">
      <button class="btn btn-success btn-sm"  onclick="getCustomerInfo()" data-toggle="modal" data-target="#addModal">新增</button>
      <button class="btn btn-success btn-sm"  onclick="deleteBatch('customer_care')" >批量删除</button>
    </div>
    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered text-center">
            <thead>
                <tr>
                    <td><input id="totalCB" type="checkbox"></td>
                    <td>序号</td>
                    <td>客户名称</td>
                    <td>关辉主题</td>
                    <td>关怀方式</td>
                    <td>关怀时间</td>
                    <td>下次时间</td>
                    <td>关怀人</td>
                    <td>描述</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach varStatus="v" items="${pageUtil.pageList}" var="customerCare">
                <tr>
                    <td><input value="${customerCare.id}" type="checkbox"></td>
                    <td>${(pageUtil.thisPage-1)*pageUtil.pageSize+v.count}</td>
                    <td>${customerCare.customerName}</td>
                    <td>${customerCare.theme}</td>
                    <td>${customerCare.way }</td>
                    <td><fmt:formatDate type="date" value="${customerCare.time }" /></td>
                    <td><fmt:formatDate type="date" value="${customerCare.nextTime }" /></td>
                    <td>${customerCare.people }</td>
                    <td>${customerCare.remark }</td>
                    <td>
                        <span onclick="deleteOne('customer_care',${customerCare.id})" data-toggle="modal" data-target="#deleteData" ><span class="glyphicon glyphicon-trash"  data-toggle="tooltip" data-placement="bottom" title="删除"></span></span>
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
                <li><a href="${CTX}/customer?command=showCare&thisPage=${pageUtil.thisPage-1}">&larr; 上一页</a></li>
            </c:if>
            <c:if test="${pageUtil.thisPage < pageUtil.totalPage}">
                <li><a href="${CTX}/customer?command=showCare&thisPage=${pageUtil.thisPage+1}">下一页 &rarr;</a></li>
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
                  <h4 class="modal-title" id="myModalLabel">新增客户关怀信息</h4>
              </div>
              <form action="${CTX}/customer?command=saveCare" method="post">
                  <div class="modal-body">
                      <div class="form-group">
                          <label>客户名称</label>
                          <select class="form-control" id="customerId" name="customerId">
                          </select>
                      </div>
                      <div class="form-group">
                          <label>关怀主题</label>
                          <input type="text" name="theme" class="form-control" placeholder="关怀主题">
                      </div>
                      <div class="form-group">
                          <label>关怀方式</label>
                          <input type="text" name="way" class="form-control" placeholder="关怀方式">
                      </div>
                      <div class="form-group">
                          <label>关怀时间</label>
                          <input type="date" name="time" class="form-control" placeholder="关怀时间">
                      </div>
                      <div class="form-group">
                          <label>描述</label>
                          <textarea name="remark" class="form-control" placeholder="描述"></textarea>
                      </div>
                      <div class="form-group">
                          <label>下次关怀时间</label>
                          <input type="date" name="nextTime" class="form-control" placeholder="描述">
                      </div>
                      <div class="form-group">
                          <label>关怀人</label>
                          <input type="text" name="people" class="form-control" placeholder="关怀人">
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
  <script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
  <script type="text/javascript" src="${STATIC_LIB}/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
  <%@ include file="/WEB-INF/layout/delete-model.jspf"%>
  <script type="text/javascript">
      function getCustomerInfo(){
          $.ajax({
              type: "GET",
              url: "${CTX}/customer?command=getAllCustomerInfo",
              dataType: "json",
              success: function(data){
                  $('#customerId').empty();
                  $.each(data,function(index, datas){
                      console.info(datas);
                      $('#customerId').append('<option value="'+datas.id+'">'+datas.mobile+' -- '+datas.name+'</option>')
                  });
              }
          });
      }
  </script>
</body>
</html>