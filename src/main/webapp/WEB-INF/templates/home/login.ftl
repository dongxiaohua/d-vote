
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>网络投票用户登录</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="${ctx}/static/css/logStyle.css" />

<body>

<div class="login-container">
    <h1>D-VOTE</h1>

    <div class="connect">
        <p>https://github.com/dongxiaohua/d-vote</p>
    </div>

    <form action="${ctx}/lg/login" method="post" id="loginForm">
        <div>
            <input type="text" name="userName" class="userName" placeholder="用户名" autocomplete="off"/>
        </div>
        <div>
            <input type="password" name="passWord" class="passWord" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
        </div>
        <button id="submit" type="submit">登 陆</button>
    </form>

    <a href="register.ftl">
        <button type="button" class="register-tis">还有没有账号？</button>
    </a>

</div>

<script src="${ctx}/static/js/login.jquery.min.js"></script>
<script src="${ctx}/static/js/common.js"></script>
<!--背景图片自动更换-->
<script src=""></script>
<script src=""></script>
<!--表单验证-->
<script src="${ctx}/static/js/jquery.validate.min.js"></script>

</body>
</html>