<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>房地产客户关系管理系统</title>
    <link rel="stylesheet" href="static/lib/bootstrap-3.3.7/dist/css/bootstrap.css">
    <link rel="stylesheet" href="static/css/common.css">
    <style type="text/css">
      .btn-100{
        width: 100%;
      }
      .logo{
        height: 100px;
        line-height: 100px;
        font-size: 16px;
      }
    </style>
  </head>
  <body>
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-12 logo">房地产CRM</div>
        <div class="col-lg-4 col-md-6 col-sm-12">
          <form class="">
            <div class="form-group">
              <input type="email" class="form-control" placeholder="请输入邮箱/手机号">
            </div>
            <div class="form-group">
              <input type="password" class="form-control" placeholder="请输入密码">
            </div>
            <div class="checkbox">
              <label>
                <input type="checkbox">记住密码
              </label>
            </div>
            <button type="submit" class="btn btn-default btn-100">登录</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
