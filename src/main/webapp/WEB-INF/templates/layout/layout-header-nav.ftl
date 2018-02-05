<header class="main-header">
  <nav class="navbar navbar-static-top">
    <div class="navbar-header">
      <a href="${ctx}" class="logo">Jason Statham</a>
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
    </div>

    <div class="navbar-custom-menu">
      <ul class="nav navbar-nav">
        <li class="dropdown user user-menu">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <img src="${ctx}/static/images/dxh.png" class="user-image" alt="User Image">
            <span class="hidden-xs">${principal()}</span>
          </a>
          <ul class="dropdown-menu">
            <li class="user-header">
              <img src="${ctx}/static/images/dxh.png" class="img-circle" alt="User Image">
              <p>
              ${principal()}
              </p>
            </li>
            <li class="user-footer">
              <div class="pull-right">
                <a href="${ctx}/home/logout" class="btn btn-default btn-flat">退出</a>
              </div>
            </li>
          </ul>
        </li>
      </ul>
    </div>

  </nav>
</header>
