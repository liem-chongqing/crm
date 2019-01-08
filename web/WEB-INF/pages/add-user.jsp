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
        <div class="container-fluid base-info">用户编号(登录账号)：100001，默认密码为：123456</div>
        <div class="col-md-12 col-sm-12">
            <div class="form-group">
                <input type="button" value="批量上传" class="btn btn-success">
                <a href="" class="btn btn-success">下载模板</a>
            </div>
            <div class="form-group">
                <label>部门名称</label>
                <input type="text" class="form-control" placeholder="部门名称">
            </div>
            <div class="form-group">
                <label>角色名</label>
                <input type="text" class="form-control" placeholder="角色名">
            </div>
            <div class="form-group">
                <label>角色权重</label>
                <select class="form-control">
                    <option>一级</option>
                    <option>二级</option>
                </select>
            </div>
            <div class="form-group">
                <label>姓名</label>
                <input type="text" class="form-control" placeholder="姓名">
            </div>
            <div class="form-group">
                <label>性别</label>
                <select class="form-control">
                    <option>男</option>
                    <option>女</option>
                </select>
            </div>
            <div class="form-group">
                <label>民族</label>
                <select class="form-control">
                    <option>汉族</option>
                    <option>苗族</option>
                    <option>土家族</option>
                </select>
            </div>
            <div class="form-group">
                <label>婚姻</label>
                <select class="form-control">
                    <option>已婚</option>
                    <option>未婚</option>
                </select>
            </div>
            <div class="form-group">
                <label>学历</label>
                <select class="form-control">
                    <option>初中</option>
                    <option>高中</option>
                    <option>专科</option>
                    <option>本科</option>
                    <option>硕士</option>
                    <option>博士</option>
                </select>
            </div>
            <div class="form-group">
                <label>移动电话</label>
                <input type="text" class="form-control" placeholder="手机号码">
            </div>
            <div class="form-group">
                <label>地址</label>
                <input type="text" class="form-control" placeholder="长居住地址">
            </div>
            <div class="form-group">
                <label>固话</label>
                <input type="text" class="form-control" placeholder="固定电话">
            </div>
            <div class="form-group">
                <label>身份证号</label>
                <input type="text" class="form-control" placeholder="身份证号">
            </div>
            <div class="form-group">
                <label>邮箱</label>
                <input type="text" class="form-control" placeholder="邮箱">
            </div>
            <div class="form-group">
                <label>爱好</label>
                <input type="text" class="form-control" placeholder="爱好">
            </div>

            <div class="form-group">
                <label>银行卡号</label>
                <input type="text" class="form-control" placeholder="银行卡号">
            </div>

            <div class="form-group">
                <label>是否激活</label>
                <select class="form-control">
                    <option>是</option>
                    <option>否</option>
                </select>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-success">
                <input type="reset" class="btn btn-success">
            </div>
        </div>
    </div>
    <script type="text/javascript" src="${STATIC_LIB}/jquery-1.12.4.min.js"></script>
</body>
</html>