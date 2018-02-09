<div class="main-sidebar">
  <!-- Inner sidebar -->
  <div class="sidebar">
    <!-- Sidebar Menu -->
    <#--data-widget="tree"-->
    <ul class="sidebar-menu" data-widget="tree">
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
            <a href="${ctx}/v/list"><i class="fa fa-list-alt"></i> 最新投票列表</a>
          </li>
          <li>
            <a href="${ctx}/history/list"><i class="fa fa-history"></i> 历史投票</a>
          </li>
        </ul>
      </li>

      <li class="treeview">
        <a href="#">
          <i class="fa fa-user"></i>
          <span>管理员</span>
          <span class="pull-right-container">
              <#--<span class="label label-primary pull-right">4</span>-->
                <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">
          <li>
            <a href="${ctx}/unauthorized"><i class="fa fa-circle-o"></i> 列表</a>
          </li>
          <li>
            <a href="${ctx}/unauthorized"><i class="fa fa-circle-o"></i> 创建投票</a>
          </li>
        </ul>
      </li>

    </ul><!-- /.sidebar-menu -->
  </div><!-- /.sidebar -->
</div><!-- /.main-sidebar -->