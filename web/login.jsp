<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>房地产客户关系管理系统</title>
    <link rel="stylesheet" href="static/lib/bootstrap-3.3.7/dist/css/bootstrap.css">
    <link rel="stylesheet" href="static/css/common.css">
    <style type="text/css">
      .row{
        display: flex;
        justify-content: center;
      }
      .btn-100{
        width: 100%;

      }
      .logo{
        height: 100px;
        line-height: 100px;
        font-size: 16px;
        text-align: center;
        font-weight: bold;
      }
      .checkbox{
        display: flex;
        justify-content: space-between;
      }
    </style>
  </head>
  <body>
    <div class="container-fluid" >
      <div class="row">
        <div class="col-lg-12 logo">微胜房地产CRM</div>
      </div>
      <div class="row">
        <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12">
          <form class="" method="post" action="/user?command=login">
            <div class="form-group">
              <input type="text" name="code" class="form-control" value="100000" placeholder="请输入邮箱/手机号">
            </div>
            <div class="form-group">
              <input type="password" name="password" class="form-control" value="123456" placeholder="请输入密码">
            </div>
            <div class="checkbox">
              <label>
                <input type="checkbox">记住密码
              </label>
              <a href="" >忘记密码?</a>
            </div>
            <button type="submit" class="btn btn-success btn-100">登录</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
