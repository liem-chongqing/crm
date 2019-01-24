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
    <h1 class="son-title">客户联系人记录</h1>
    <div class="search-box">
        <button class="btn btn-success btn-sm"  onclick="getCustomerInfo()" data-toggle="modal" data-target="#addModal">新增</button>
        <button class="btn btn-success btn-sm"  onclick="deleteBatch('customer_linkman')" >批量删除</button>
    </div>
    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered text-center">
            <thead>
            <tr>
                <td><input id="totalCB" type="checkbox"></td>
                <td>序号</td>
                <td>客户名称</td>
                <td>姓名</td>
                <td>性别</td>
                <td>职位</td>
                <td>电话</td>
                <td>年龄</td>
                <td>与客户关系</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach varStatus="v" items="${pageUtil.pageList}" var="linkman">
                <tr>
                    <td><input value="${linkman.id}" type="checkbox"></td>
                    <td>${(pageUtil.thisPage-1)*pageUtil.pageSize+v.count}</td>
                    <td>${linkman.customerName}</td>
                    <td>${linkman.name}</td>
                    <td>${linkman.sex }</td>
                    <td>${linkman.job }</td>
                    <td>${linkman.mobile }</td>
                    <td>${linkman.age }</td>
                    <td>${linkman.relation }</td>
                    <td>
                        <span onclick="deleteOne('customer_linkman',${linkman.id})" data-toggle="modal" data-target="#deleteData" ><span class="glyphicon glyphicon-trash"  data-toggle="tooltip" data-placement="bottom" title="删除"></span></span>
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
                <li><a href="${CTX}/customer?command=showLinkman&thisPage=${pageUtil.thisPage-1}">&larr; 上一页</a></li>
            </c:if>
            <c:if test="${pageUtil.thisPage < pageUtil.totalPage}">
                <li><a href="${CTX}/customer?command=showLinkman&thisPage=${pageUtil.thisPage+1}">下一页 &rarr;</a></li>
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
                <h4 class="modal-title" id="myModalLabel">新增联系人信息</h4>
            </div>
            <form action="${CTX}/customer?command=saveLinkman" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label>客户名称</label>
                        <select class="form-control" id="customerId" name="customerId">
                        </select>
                    </div>
                    <div class="form-group">
                        <label>姓名</label>
                        <input type="text" name="name" class="form-control" placeholder="联系人姓名">
                    </div>
                    <div class="form-group">
                        <label>性别</label>
                        <select class="form-control" name="sex">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>职位</label>
                        <input type="text" name="job" class="form-control" placeholder="联系人职位">
                    </div>
                    <div class="form-group">
                        <label>电话</label>
                        <input type="text" name="mobile" class="form-control" placeholder="联系人电话">
                    </div>
                    <div class="form-group">
                        <label>年龄</label>
                        <input type="text" name="age" class="form-control" placeholder="联系人年龄">
                    </div>
                    <div class="form-group">
                        <label>与客户关系</label>
                        <input type="text" name="relation" class="form-control" placeholder="联系人与客户关系">
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