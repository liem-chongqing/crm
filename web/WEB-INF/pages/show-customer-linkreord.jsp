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
    <h1 class="son-title">客户联系记录</h1>
    <div class="search-box">
        <button class="btn btn-success btn-sm"  onclick="getCustomerInfo()" data-toggle="modal" data-target="#addModal">新增</button>
        <button class="btn btn-success btn-sm"  onclick="deleteBatch('customer_linkreord')" >批量删除</button>
    </div>
    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered text-center">
            <thead>
            <tr>
                <td><input id="totalCB" type="checkbox"></td>
                <td>序号</td>
                <td>客户名称</td>
                <td>客户类型</td>
                <td>主题内容</td>
                <td>情况备注</td>
                <td>联系时间</td>
                <td>联系人</td>
                <td>下次联系时间</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach varStatus="v" items="${pageUtil.pageList}" var="linkreord">
                <tr>
                    <td><input value="${linkreord.id}" type="checkbox"></td>
                    <td>${(pageUtil.thisPage-1)*pageUtil.pageSize+v.count}</td>
                    <td>${linkreord.customerName}</td>
                    <td>${linkreord.type}</td>
                    <td>${linkreord.theme }</td>
                    <td>${linkreord.remark }</td>
                    <td><fmt:formatDate type="date" value="${linkreord.time }" /></td>
                    <td>${linkreord.whoLink }</td>
                    <td><fmt:formatDate type="date" value="${linkreord.nextTime }" /></td>
                    <td>
                        <span onclick="deleteOne('customer_linkreord',${linkreord.id})" data-toggle="modal" data-target="#deleteData" ><span class="glyphicon glyphicon-trash"  data-toggle="tooltip" data-placement="bottom" title="删除"></span></span>
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
                <li><a href="${CTX}/customer?command=showLinkreord&thisPage=${pageUtil.thisPage-1}">&larr; 上一页</a></li>
            </c:if>
            <c:if test="${pageUtil.thisPage < pageUtil.totalPage}">
                <li><a href="${CTX}/customer?command=showLinkreord&thisPage=${pageUtil.thisPage+1}">下一页 &rarr;</a></li>
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
                <h4 class="modal-title" id="myModalLabel">新增与客户联系信息</h4>
            </div>
            <form action="${CTX}/customer?command=saveLinkreord" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label>客户名称</label>
                        <select class="form-control" id="customerId" name="customerId">
                        </select>
                    </div>
                    <div class="form-group">
                        <label>客户类型</label>
                        <input type="text" name="type" class="form-control" placeholder="客户类型">
                    </div>
                    <div class="form-group">
                        <label>主题内容</label>
                        <input type="text" name="theme" class="form-control" placeholder="主题内容">
                    </div>
                    <div class="form-group">
                        <label>情况备注</label>
                        <textarea name="remark" class="form-control" placeholder="情况备注"></textarea>
                    </div>
                    <div class="form-group">
                        <label>联系时间</label>
                        <input type="date" name="time" class="form-control" placeholder="联系时间">
                    </div>
                    <div class="form-group">
                        <label>联系人</label>
                        <input type="text" name="whoLink" class="form-control" placeholder="联系人">
                    </div>
                    <div class="form-group">
                        <label>下次联系时间</label>
                        <input type="date" name="nextTime" class="form-control" placeholder="下次联系时间">
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