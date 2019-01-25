<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layout/constant.jspf"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>房地产客户关系管理系统</title>
  <link rel="stylesheet" href="${STATIC_LIB}/bootstrap-3.3.7/dist/css/bootstrap.css">
  <link rel="stylesheet" href="${STATIC_CSS}/user-list.css">
    <style type="text/css">
        .base-info{ height: 40px; padding-bottom: 10px; padding-top: 10px}
    </style>
</head>
<body>
    <div class="container-main">
        <h1 class="son-title">新增员工</h1>
        <div class="container-fluid base-info">统一默认密码为：123456</div>
        <div class="col-md-12 col-sm-12">
            <div class="form-group">
                <button class="btn btn-success" data-toggle="modal" data-target="#batchAddModal">批量导入</button>
            </div>
            <form action="${CTX}/user?command=save" method="post">
                <div class="form-group">
                    <label>角色名</label>
                    <select class="form-control" name="roleName">
                        <option value="0">管理员</option>
                        <option value="1">普通用户</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>姓名</label>
                    <input value="黎林" type="text" name="name" class="form-control" placeholder="姓名">
                </div>
                <div class="form-group">
                    <label>性别</label>
                    <select class="form-control" name="sex">
                        <option value="0">男</option>
                        <option value="1">女</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>民族</label>
                    <select class="form-control" name="nation">
                        <option value="0">汉族</option>
                        <option value="1">苗族</option>
                        <option value="2">土家族</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>婚姻</label>
                    <select class="form-control" name="married">
                        <option value="0">已婚</option>
                        <option value="1">未婚</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>学历</label>
                    <select class="form-control" name="diploma">
                        <option value="0">小学</option>
                        <option value="1">初中</option>
                        <option value="2">高中</option>
                        <option value="3">专科</option>
                        <option value="4">本科</option>
                        <option value="5">硕士</option>
                        <option value="6">博士</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>移动电话</label>
                    <input value="13677603400" type="text" name="mobile" class="form-control" placeholder="手机号码">
                </div>
                <div class="form-group">
                    <label>地址</label>
                    <input value="重庆市渝北区" type="text" name="address" class="form-control" placeholder="长居住地址">
                </div>
                <div class="form-group">
                    <label>固话</label>
                    <input value="023-12431256" type="text" name="tel" class="form-control" placeholder="固定电话">
                </div>
                <div class="form-group">
                    <label>身份证号</label>
                    <input value="500231199303126052" type="text" name="idnum" class="form-control" placeholder="身份证号">
                </div>
                <div class="form-group">
                    <label>邮箱</label>
                    <input value="996052600@qq.com" type="text" name="email" class="form-control" placeholder="邮箱">
                </div>
                <div class="form-group">
                    <label>爱好</label>
                    <input value="篮球,足球,羽毛球" type="text" name="hobby" class="form-control" placeholder="爱好">
                </div>

                <div class="form-group">
                    <label>银行卡号</label>
                    <input value="100000000000000" type="text" name="bankCard" class="form-control" placeholder="银行卡号">
                </div>

                <div class="form-group">
                    <label>是否激活</label>
                    <select class="form-control" name="used">
                        <option value="0">是</option>
                        <option value="1">否</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-success">
                    <input type="reset" class="btn btn-success">
                </div>
            </form>
        </div>
    </div>



    <!-- 批量上传model -->
    <div class="modal fade" id="batchAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">批量导入员工信息</h4>
                </div>
                <form action="${CTX}/common?command=uploadFile" enctype="multipart/form-data" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <label>文件导入</label>
                            <input type="hidden" value="user_info" name="code">
                            <input type="file" name="file" class="form-control" >
                            <p class="help-block"><span style="color: red;">*</span>&nbsp;导入前请下载<a href="${CTX}/static/xlsx/user_info_templet.xlsx">《批量导入模板》</a>并按照格式填写</p>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">确认上传</button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="${STATIC_LIB}/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
</body>
</html>