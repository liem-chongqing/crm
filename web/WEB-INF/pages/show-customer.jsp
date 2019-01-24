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
        <form action="${CTX}/customer" method="POST" class="form-inline">
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
                        <span data-toggle="modal" data-target="#myModal" onclick="getDetails(${customer.id})"><span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-placement="bottom" title="查看/编辑"></span></span>
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

  <!-- 修改模态框  -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title" id="myModalLabel">查看详情/修改</h4>
              </div>
              <form id="modifyBox" action="${CTX}/common?command=modifyData&code=customer" method="post">

              </form>
          </div>
      </div>
  </div>
  <script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
  <script type="text/javascript" src="${STATIC_LIB}/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
  <%@ include file="/WEB-INF/layout/delete-model.jspf"%>
  <script type="text/javascript">
     function getDetails(customerId){
         $.ajax({
             type: "GET",
             url: "${CTX}/customer?command=customerInfo&customerId="+customerId,
             dataType: "json",
             success: function(data){
                 console.info(data);
                 var typeId=data.typeId;
                 var conditionId=data.conditionId;
                 var sourceId=data.sourceId;
                 var userId=data.userId;
                 $('#modifyBox').empty();   //清空myModal里面的所有内容
                 var html = '';
                 html +='<div class="modal-body">';
                 html +='<input type="hidden" name="id" value="'+data.id+'">';
                 html +='<div class="form-group">';
                 html +='<label>客户状态</label>';
                 html +='<select class="form-control" name="conditionId">';
                 html +='<c:forEach items="${conditions}" var="condition">';
                 if('${condition.id}' == conditionId){
                     html +='<option value="${condition.id}" selected >${condition.name}</option>';
                 }else{
                     html +='<option value="${condition.id}">${condition.name}</option>';
                 }
                 html +='</c:forEach>';
                 html +='</select>';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户来源</label>';
                 html +='<select class="form-control" name="sourceId">';
                 html +='<c:forEach items="${sources}" var="source">';
                 if('${source.id}' == sourceId){
                     html +='<option value="${source.id}" selected>${source.name}</option>';
                 }else{
                     html +='<option value="${source.id}">${source.name}</option>';
                 }
                 html +='</c:forEach>';
                 html +='</select>';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户类型</label>';
                 html +='<select class="form-control" name="typeId">';
                 html +='<c:forEach items="${types}" var="type">';
                 if('${type.id}' == typeId){
                    html +='<option value="${type.id}" selected >${type.name}</option>';
                 }else{
                    html +='<option value="${type.id}">${type.name}</option>';
                 }
                 html +='</c:forEach>';
                 html +='</select>';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>跟踪（负责）员工</label>';
                 html +='<select class="form-control" name="userId">';
                 html +='<option value="-1">暂不分配</option>';
                 html +='<c:forEach items="${userInfos}" var="user">';
                 if('${user.id}'==userId){
                     html +='<option value="${user.id}" selected>${user.num}&nbsp;-&nbsp;${user.name}</option>';
                 }else{
                     html +='<option value="${user.id}">${user.num}&nbsp;-&nbsp;${user.name}</option>';
                 }
                 html +='</c:forEach>';
                 html +='</select>';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户姓名</label>';
                 html +='<input type="text" value="'+data.name+'" name="name" class="form-control" placeholder="客户姓名">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户性别</label>';
                 var sex = data.sex;
                 html +='<select class="form-control" name="sex">';
                 if(sex==1){
                     html +='<option value="0">男</option>';
                     html +='<option value="1" selected>女</option>';
                 }else{
                     html +='<option value="0" selected>男</option>';
                     html +='<option value="1">女</option>';
                 }
                 html +='</select>';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户移动电话</label>';
                 html +='<input type="text" value="'+data.mobile+'" name="mobile" class="form-control" placeholder="手机号码">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户QQ</label>';
                 html +='<input type="text" value="'+data.qq+'" name="qq" class="form-control" placeholder="QQ号码">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户地址</label>';
                 html +='<input type="text" value="'+data.address+'" name="address" class="form-control" placeholder="长居住地址">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户邮箱</label>';
                 html +='<input type="text" value="'+data.email+'" name="email" class="form-control" placeholder="客户邮箱">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户职位</label>';
                 html +='<input type="text" value="'+data.job+'" name="job" class="form-control" placeholder="职位">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户微博</label>';
                 html +='<input type="text" value="'+data.blog+'" name="blog" class="form-control" placeholder="微博">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户固话</label>';
                 html +='<input type="text" value="'+ data.tel +'" name="tel" class="form-control" placeholder="固定电话">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户微信</label>';
                 html +='<input type="text" value="'+ data.wechat +'" name="wechat" class="form-control" placeholder="微信">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户生日</label>';
                 html +='<input type="date" value="'+ new Date(data.birthDay).Format("yyyy-MM-dd")  +'" name="birthDay" class="form-control" placeholder="生日">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>客户公司</label>';
                 html +='<input type="text" value="'+ data.company +'" name="company" class="form-control" placeholder="公司名称">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>备注</label>';
                 html +='<input type="text" value="'+ data.remark +'" name="remark" class="form-control" placeholder="备注信息">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>数据状态</label>';
                 var used = data.used;
                 html +='<select class="form-control" name="used">';
                 if(used==1){
                     html +='<option value="0">有效</option>';
                     html +='<option value="1" selected >无效</option>';
                 }else{
                     html +='<option value="0" selected >有效</option>';
                     html +='<option value="1" >无效</option>';
                 }
                 html +='</select>';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>创建时间</label>';
                 html +='<input type="text" value="'+ new Date(data.createTime).Format("yyyy-MM-dd hh:mm:ss") +'" disabled class="form-control">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>创建人</label>';
                 html +='<input type="text" value="'+ data.createMan +'" disabled class="form-control">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>修改时间</label>';
                 html +='<input type="text" value="'+ new Date(data.updateTime).Format("yyyy-MM-dd hh:mm:ss") +'" disabled class="form-control">';
                 html +='</div>';
                 html +='<div class="form-group">';
                 html +='<label>修改人</label>';
                 html +='<input type="text" value="'+ data.updateMan +'" disabled class="form-control">';
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

     Date.prototype.Format = function (fmt) { //author: meizz
         var o = {
             "M+": this.getMonth() + 1, //月份
             "d+": this.getDate(), //日
             "h+": this.getHours(), //小时
             "m+": this.getMinutes(), //分
             "s+": this.getSeconds(), //秒
             "q+": Math.floor((this.getMonth() + 3) / 3), //季度
             "S": this.getMilliseconds() //毫秒
         };
         if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
         for (var k in o)
             if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
         return fmt;
     }
  </script>
</body>
</html>