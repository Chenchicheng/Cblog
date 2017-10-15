<%--登录页--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <title>登录</title>
    <!-- v3 -->
    <link rel="stylesheet" href="${base}/assets/vendors/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${base}/assets/css/login.css">

    <!-- JavaScript -->
    <script type="text/javascript" src="${base}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${base}/assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="${base}/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${base}/assets/vendors/validate/jquery-validate.js"></script>

    <!-- Favicons -->
    <link rel="apple-touch-icon-precomposed" href="http://mtons.com/assets/images/logo/m99.png"/>
    <link rel="shortcut icon" href="http://mtons.com/assets/images/logo/m.png"/>

</head>
<body class="sign">
<div class="login">
    <a href="${base}/index">
        <img src="${base}/assets/images/logo/m92.png" height="72" width="72" style="border-radius:5px;">
    </a>
    <h1>Cblog 分享你的乐趣！</h1>
    <hr>
    <form action="login" method="post">
        <div id="message">
            <c:if test="${message != null}">
                <div class="alert alert-danger">${message}</div>
            </c:if>
        </div>
        <label for="id_email">用户名:</label>
        <div id="id_email">
            <input name="username" class="form-control border" placeholder="用户名" type="text" data-required>
        </div>
        <label for="id_password">密码:</label>
        <div id="id_password">
            <input name="password" class="form-control border" placeholder="密码" type="password" data-required>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="rememberMe" value="1"> 记住密码？
            </label>
        </div>

        <div style="margin-top: 15px;">
            <input type="submit" class="btn btn-success border" value="登录 Use it">

            <div class="forgot">
                <a href="${base}/reg">
                    注册
                </a>
                <a href="${base}/forgot/apply">
                    忘记密码
                </a>
            </div>
        </div>
    </form>
    <div class="with-line">使用第三方帐号登录</div>
    <div class="buttons">
        <a href="${base}/oauth/callback/call_weibo" title="微博帐号登录" rel="nofollow" class="weibo"></a>
        <a href="${base}/oauth/callback/call_qq" title="QQ帐号登录" rel="nofollow" class="qzone"></a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('form').validate({
            onKeyup : true,
            onChange : true,
            eachValidField : function() {
                $(this).closest('div').removeClass('has-error').addClass('has-success');
            },
            eachInvalidField : function() {
                $(this).closest('div').removeClass('has-success').addClass('has-error');
            },
            description : {
                message : {
                    required : '<div class="alert alert-danger">请先输入用户名/密码再进行登录操作</div>'
                }
            }
        });
    })
</script>
</body>
</html>