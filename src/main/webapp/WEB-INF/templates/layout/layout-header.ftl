<header class="main-header">
  <a href="${ctx}" class="logo">

    <span style="margin-left: -10px;">
      <#--头像-->
       <img src="${ctx}/static/images/dxh.png" width="40" height="37" class="img-circle"/>
    </span>
    <span>网络投票</span>
  </a>
  <nav class="navbar navbar-static-top" role="navigation" style="height: 50px">
    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
      <span class="sr-only">Toggle navigation</span>
    </a>

    <#--登录-->
    <div class="navbar-custom-menu">
      <ul class="nav navbar-nav">
        <li class="dropdown user user-menu">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <#--头像-->
            <img src="${ctx}/static/images/dxh.png" class="user-image" alt="User Image">
            <span class="hidden-xs">
            <#--${principal()!}-->
                        </span>
          </a>
          <ul class="dropdown-menu">
            <li class="user-header">
              <#--头像-->
              <img src="${ctx}/static/images/dxh.png" class="img-circle" alt="User Image">
              <p>
              <#--${principal()!}-->
              </p>
            </li>
            <li class="user-footer">
              <div class="pull-right">
                <a href="${ctx}/lg/login" class="btn btn-default btn-flat">退出</a>
              </div>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
</header>
