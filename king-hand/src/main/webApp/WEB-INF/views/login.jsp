<%--
  Created by IntelliJ IDEA.
  User: wangxin
  Date: 2018/4/3
  Time: 上午10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<link rel="stylesheet" href="resources/static/css/bootstrap-4/css/bootstrap.css">
<link rel="stylesheet" href="resources/static/css/login.css">
<body>
        <div class="m-login-main">

            <div class="container">
                <form id="m-form" method="post" href="/login">
                    <div class="form-group row">
                        <label for="staticText" class="col-sm-2 col-form-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control-plaintext" id="account" value="" placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="staticPassword" class="col-sm-2 col-form-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password"  class="form-control-plaintext" id="password" value="" placeholder="请输入密码">
                        </div>
                    </div>

                </form>
            </div>

        </div>
<script href="resources/static/js/jquery-3.1.1.min.js"></script>
<script>




</script>
</body>
</html>
