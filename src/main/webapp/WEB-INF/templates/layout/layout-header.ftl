<header class="main-header">
  <a href="${ctx}" class="logo">

    <span style="margin-left: 20px;">
       <img src="//static.foneshare.cn/oss/images/fxiaoke.logo.png" width="36" height="40"/>
    </span>
    <span>投票</span>
  </a>
  <nav class="navbar navbar-static-top" role="navigation" style="height: 50px">
    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
      <span class="sr-only">Toggle navigation</span>
    </a>
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="color:#FFFFFF;line-height: 3.5;">
      <span class="glyphicon glyphicon-th"></span>
      <span class="caret"></span>
    </a>

    <div class="navbar-custom-menu">
      <ul class="nav navbar-nav">
        <li class="dropdown user user-menu">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <img src="//static.foneshare.cn/oss/images/fxiaoke.logo.png" class="user-image" alt="User Image">
            <span class="hidden-xs">
            ${principal()!}
                        </span>
          </a>
          <ul class="dropdown-menu">
            <li class="user-header">
              <img src="//static.foneshare.cn/oss/images/fxiaoke.logo.png" class="img-circle" alt="User Image">
              <p>
              ${principal()!}
              </p>
            </li>
            <li class="user-footer">
              <div class="pull-right">
                <a href="${ctx}/logout" class="btn btn-default btn-flat">退出</a>
              </div>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
</header>
