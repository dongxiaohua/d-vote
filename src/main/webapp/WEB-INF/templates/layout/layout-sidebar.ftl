<div class="main-sidebar">
  <!-- Inner sidebar -->
  <div class="sidebar">
    <!-- Sidebar Menu -->
    <ul class="sidebar-menu">  <#--data-widget="tree"-->
      <li class="header">MAIN NAVIGATION</li>
      <li class="treeview">
        <a href="#">
          <i class="fa fa-dashboard"></i> <span>用户投票</span>
          <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">
          <li>
            <a href="${ctx}/error"><i class="fa fa-circle-o"></i> Dashboard v1</a>
          </li>
          <li>
            <a href="${ctx}/home"><i class="fa fa-circle-o"></i> Dashboard v2</a>
          </li>
        </ul>
      </li>

      <li class="treeview">
        <a href="#">
          <i class="fa fa-files-o"></i>
          <span>管理员</span>
          <span class="pull-right-container">
              <#--<span class="label label-primary pull-right">4</span>-->
                <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">
          <li>
            <a href="${ctx}/unauthorized"><i class="fa fa-circle-o"></i> Fixed</a>
          </li>
        </ul>
      </li>

    </ul><!-- /.sidebar-menu -->
  </div><!-- /.sidebar -->
</div><!-- /.main-sidebar -->