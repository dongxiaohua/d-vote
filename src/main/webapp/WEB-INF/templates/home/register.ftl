<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>网络投票用户注册</title>
  <link rel="stylesheet" href="${ctx}/static/css/logStyle.css"/>
</head>
<body>

<div class="register-container">
  <h1>Registered</h1>

  <div class="connect">
    <p>https://github.com/dongxiaohua/d-vote</p>
  </div>

  <form action="${ctx}/lg/register" method="post" id="">
    <div>
      <input type="text" name="userName" class="userName" placeholder="您的用户名" autocomplete="off"/>
    </div>
    <div>
      <input type="password" name="passWord" class="passWord" placeholder="输入密码" oncontextmenu="return false" onpaste="return false"/>
    </div>
    <div>
      <input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false"/>
    </div>
  <#--<div>-->
  <#--<input type="text" name="phoneNumber" class="phoneNumber" placeholder="输入手机号码" autocomplete="off" id="number"/>-->
  <#--</div>-->
  <#--<div>-->
  <#--<input type="email" name="email" class="email" placeholder="输入邮箱地址" oncontextmenu="return false" onpaste="return false" />-->
  <#--</div>-->
    <button id="submit" type="submit">注 册</button>
  </form>
  <a href="login.ftl">
    <button type="button" class="register-tis">已经有账号？</button>
  </a>

</div>


<script src="${ctx}/static/js/login.jquery.min.js"></script>
<script src="${ctx}/static/js/common.js"></script>
<!--背景图片自动更换-->
<script src=""></script>
<script src=""></script>
<!--表单验证-->
<script src="${ctx}/static/js/jquery.validate.min.js"></script>

<script type="text/javascript">
  $('.userName').change(function () {

  })
</script>

</body>
</html>
<!--
本代码由js代码收集并编辑整理;
尊重他人劳动成果;
转载请保留js代码链接 - www.jsdaima.com
-->