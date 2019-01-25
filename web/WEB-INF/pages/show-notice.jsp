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
    <h1 class="son-title">公告信息</h1>
    <div class="search-box">
        <button class="btn btn-success btn-sm" data-toggle="modal" data-target="#addModal">新增</button>
        <button class="btn btn-success btn-sm" onclick="deleteBatch('notice_info')" >批量删除</button>
    </div>
    <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered text-center">
            <thead>
            <tr>
                <td><input id="totalCB" type="checkbox"></td>
                <td>序号</td>
                <td>发布人</td>
                <td>主题</td>
                <td>内容</td>
                <td>发布时间</td>
                <td>结束时间</td>
                <td>状态</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach varStatus="v" items="${pageUtil.pageList}" var="notice">
                <tr>
                    <td><input value="${notice.id}" type="checkbox"></td>
                    <td>${(pageUserList.thisPage-1)*pageUserList.pageSize+v.count}</td>
                    <td>${notice.userName}</td>
                    <td>${notice.item}</td>
                    <td width="30%">${notice.content }</td>
                    <td><fmt:formatDate value="${notice.time }" pattern="yyyy-MM-dd HH:mm"/></td>
                    <td><fmt:formatDate value="${notice.endTime }" pattern="yyyy-MM-dd HH:mm"/></td>
                    <td>${notice.used == 0 ? '有效':'无效'}</td>
                    <td>
                        <span onclick="deleteOne('notice_info',${notice.id})" data-toggle="modal" data-target="#deleteData" ><span class="glyphicon glyphicon-trash"  data-toggle="tooltip" data-placement="bottom" title="删除"></span></span>
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
                <li><a href="${CTX}/notice?command=showNotice&thisPage=${pageUtil.thisPage-1}">&larr; 上一页</a></li>
            </c:if>
            <c:if test="${pageUtil.thisPage < pageUtil.totalPage}">
                <li><a href="${CTX}/notice?command=showNotice&thisPage=${pageUtil.thisPage+1}">下一页 &rarr;</a></li>
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
                <h4 class="modal-title" id="myModalLabel">新增公告信息</h4>
            </div>
            <form action="${CTX}/notice?command=save" method="post">
                <div class="modal-body">
                    <input type="hidden" name="userId" value="${user.id}" />
                    <div class="form-group">
                        <label>主题</label>
                        <input type="text" name="item" class="form-control" placeholder="请输入主题">
                    </div>
                    <div class="form-group">
                        <label>公告内容</label>
                        <textarea name="content" class="form-control" placeholder="请输入主题内容" ></textarea>
                    </div>
                    <div class="form-group">
                        <label>公告时间</label>
                        <input type="datetime-local" name="time" class="form-control" placeholder="结束时间">
                    </div>
                    <div class="form-group">
                        <label>结束时间</label>
                        <input type="datetime-local" name="endTime" class="form-control" placeholder="结束时间">
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
        </div>
    </div>
</div>

<script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${STATIC_LIB}/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<%@ include file="/WEB-INF/layout/delete-model.jspf"%>
</body>
</html>