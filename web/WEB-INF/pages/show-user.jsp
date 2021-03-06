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
    <h1 class="son-title">员工信息</h1>
    <div class="search-box">
        <form action="${CTX}/user" method="POST" class="form-inline">
          <input type="hidden" name="command" value="showUser"/>
          <div class="form-group form-group-sm">
              <label >工号</label>
              <input type="text" name="num" value="${num}" class="form-control" placeholder="请输入客户姓名">
          </div>
          <div class="form-group form-group-sm">
              <label >姓名</label>
              <input type="text" name="name" value="${name}" class="form-control" placeholder="请输入电话">
          </div>
          <button type="submit" class="btn btn-default btn-sm">搜索</button>
        </form>
    </div>
    <div class="form-group">
      <button onclick="deleteBatch('user_info')" class="btn btn-success">批量删除</button>
    </div>
    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered text-center">
            <thead>
                <tr>
                    <td><input id="totalCB" type="checkbox"></td>
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
                    <td><input value="${pageUser.id}" type="checkbox"></td>
                    <td>${(pageUserList.thisPage-1)*pageUserList.pageSize+v.count}</td>
                    <td>${pageUser.num}</td>
                    <td>${pageUser.roleName == 0 ? '管理员':'普通用户'}</td>
                    <td>${pageUser.name}</td>
                    <td>${pageUser.sex == 0 ? '男':'女'}</td>
                    <td>${pageUser.age}</td>
                    <td>${pageUser.nation == 0 ? '汉族':'不详'}</td>
                    <td>${pageUser.idnum}</td>
                    <td>${pageUser.email }</td>
                    <td>${pageUser.mobile}</td>
                    <td>
                        <span onclick="getDetails(${pageUser.id})" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-placement="bottom" title="查看/编辑"></span></span>
                        <span>&nbsp;</span>
                        <span onclick="deleteOne('user_info', ${pageUser.id})" data-toggle="modal" data-target="#deleteData" ><span class="glyphicon glyphicon-trash"  data-toggle="tooltip" data-placement="bottom" title="删除"></span></span>
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
                <li><a href="${CTX}/user?command=showUser&num=${num}&name=${name}&thisPage=${pageUserList.thisPage-1}">&larr; 上一页</a></li>
            </c:if>
            <c:if test="${pageUserList.thisPage < pageUserList.totalPage}">
                <li><a href="${CTX}/user?command=showUser&num=${num}&name=${name}&thisPage=${pageUserList.thisPage+1}">下一页 &rarr;</a></li>
            </c:if>
        </ul>
    </div>
  </div>
  <!-- 详情模态框 -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title" id="myModalLabel">查看详情/修改</h4>
              </div>
              <form id="modifyBox" action="${CTX}/common?command=modifyData&code=user" method="post">





              </form>
          </div><!-- /.modal-content -->
      </div><!-- /.modal -->
  </div>
  <!-- 删除模态框 -->
  <!-- 模态框（Modal） -->
  <div class="modal fade" id="deleteData" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
  <%@ include file="/WEB-INF/layout/delete-model.jspf"%>
  <script type="text/javascript">
      function getDetails(userId){
          $.ajax({
              type: "GET",
              url: "${CTX}/user?command=userInfo&userId="+userId,
              dataType: "json",
              success: function(data){
                  console.info(data);
                  var roleName = data.roleName;
                  var married = data.married;
                  var sex = data.sex;
                  var used = data.used;
                  var nation = data.nation;
                  $('#modifyBox').empty();   //清空myModal里面的所有内容
                  var html = '';
                  html +='<div class="modal-body">';
                  html +='<div class="form-group">';
                  html +='<label>角色名</label>';
                  html +='<input type="hidden" value="'+data.id+'" name="id">';
                  html +='<select class="form-control" name="roleName">';
                  if(roleName==1){
                      html +='<option value="0" selected>管理员</option>';
                      html +='<option value="1">普通用户</option>';
                  }else{
                      html +='<option value="0">管理员</option>';
                      html +='<option value="1" selected>普通用户</option>';
                  }
                  html +='</select>';
                  html +='</div>';
                  html +='<div class="form-group">';
                  html +='<label>姓名</label>';
                  html +='<input value="'+data.name+'" type="text" name="name" class="form-control" placeholder="姓名">';
                  html +='</div>';
                  html +='<div class="form-group">';
                  html +='<label>性别</label>';
                  html +='<select class="form-control" name="sex">';
                  if(sex==0){
                      html +='<option value="0" selected>男</option>';
                      html +='<option value="1">女</option>';
                  }else{
                      html +='<option value="0">男</option>';
                      html +='<option value="1" selected>女</option>';
                  }
                  html +='</select>';
                  html +='</div>';
                  html +='<div class="form-group">';
                  html +='<label>民族</label>';
                  html +='<select class="form-control" name="nation">';
                  if(nation==0){
                      html +='<option value="0" selected>汉族</option>';
                      html +='<option value="1">苗族</option>';
                      html +='<option value="2">土家族</option>';
                  }else if(nation==1){
                      html +='<option value="0">汉族</option>';
                      html +='<option value="1" selected>苗族</option>';
                      html +='<option value="2">土家族</option>';
                  }else{
                      html +='<option value="0">汉族</option>';
                      html +='<option value="1">苗族</option>';
                      html +='<option value="2" selected>不详</option>';
                  }
                  html +='</select>';
                  html +='</div>';
                  html +='<div class="form-group">';
                  html +='<label>婚姻</label>';
                  html +='<select class="form-control" name="married">';
                  if(married==0){
                      html +='<option value="0" selected>已婚</option>';
                      html +='<option value="1">未婚</option>';
                  }else{
                      html +='<option value="0">已婚</option>';
                      html +='<option value="1" selected>未婚</option>';
                  }
                  html +='</select>';
                  html +='</div>';
                  html +='<div class="form-group">';
                  html +='<label>学历</label>';
                  html +='<select class="form-control" name="diploma">';
                  html +='<option value="0">小学</option>';
                  html +='<option value="1">初中</option>';
                  html +='<option value="2">高中</option>';
                  html +='<option value="3">专科</option>';
                  html +='<option value="4">本科</option>';
                  html +='<option value="5">硕士</option>';
                  html +='<option value="6">博士</option>';
                  html +='</select>';
                  html +='</div>';
                  html +='<div class="form-group">';
                  html +='<label>移动电话</label>';
                  html +='<input value="'+data.mobile+'" type="text" name="mobile" class="form-control" placeholder="手机号码">';
                  html +='</div>';
                  html +='<div class="form-group">';
                  html +='<label>地址</label>';
                  html +='<input value="'+data.address+'" type="text" name="address" class="form-control" placeholder="长居住地址">';
                  html +='</div>';
                  html +='<div class="form-group">';
                  html +='<label>固话</label>';
                  html +='<input value="'+data.tel+'" type="text" name="tel" class="form-control" placeholder="固定电话">';
                  html +='</div>';
                  html +='<div class="form-group">';
                  html +='<label>身份证号</label>';
                  html +='<input value="'+data.idnum+'" type="text" name="idnum" class="form-control" placeholder="身份证号">';
                  html +='</div>';
                  html +='<div class="form-group">';
                  html +='<label>邮箱</label>';
                  html +='<input value="'+data.email+'" type="text" name="email" class="form-control" placeholder="邮箱">';
                  html +='</div>';
                  html +='<div class="form-group">';
                  html +='<label>爱好</label>';
                  html +='<input value="'+data.hobby+'" type="text" name="hobby" class="form-control" placeholder="爱好">';
                  html +='</div>';
                  html +='<div class="form-group">';
                  html +='<label>银行卡号</label>';
                  html +='<input value="'+data.bankCard+'" type="text" name="bankCard" class="form-control" placeholder="银行卡号">';
                  html +='</div>';
                  html +='<div class="form-group">';
                  html +='<label>是否激活</label>';
                  html +='<select class="form-control" name="used">';
                  if(used==0){
                      html +='<option value="0" selected>是</option>';
                      html +='<option value="1">否</option>';
                  }else{
                      html +='<option value="0">是</option>';
                      html +='<option value="1" selected>否</option>';
                  }
                  html +='</select>';
                  html +='</div>';
                  html +='</div>';
                  html +='<div class="modal-footer">';
                  html +='<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>';
                  html +='<button type="submit" class="btn btn-primary">提交更改</button>';
                  html +='</div>';


                  $('#modifyBox').html(html);
              }
          });
      }
  </script>
</body>
</html>