<div class="main-sidebar">
  <!-- Inner sidebar -->
  <div class="sidebar">
    <!-- Sidebar Menu -->
    <ul class="sidebar-menu">
      <li class="header">导航栏</li>
      <#if active_nav == "monitorList" || active_nav == "suitList" || active_nav == "caseList" || active_nav == "jobList">
        <li class="active treeview">
      <#else>
        <li class="treeview">
      </#if>
        <a href="">
          <i class="fa fa-code-fork"></i>
          <span>集成测试</span>
          <i class="fa fa-angle-left pull-right"></i>
        </a>
        <ul class="treeview-menu">
          <#if active_nav == "monitorList">
            <li class="active treeview">
              <a href="${ctx}/monitor/"><i class="fa fa-spinner"></i>监控列表</a>
            </li>
          <#else>
            <li>
              <a href="${ctx}/monitor/"><i class="fa fa-spinner"></i>监控列表</a>
            </li>
          </#if>
        </ul>
      <#--用例模块-->
        <ul class="treeview-menu">
          <#if active_nav == "suitList">
            <li class="active treeview">
              <a href="${ctx}/case/suitList"><i class="fa fa-list-alt"></i>用例集</a>
            </li>
          <#else>
            <li>
              <a href="${ctx}/case/suitList"><i class="fa fa-list-alt"></i>用例集</a>
            </li>
          </#if>
            <#if active_nav == "caseList">
              <li class="active treeview">
                <a href="${ctx}/case/"><i class="fa fa-briefcase"></i>用例</a>
              </li>
            <#else>
              <li>
                <a href="${ctx}/case/"><i class="fa fa-briefcase"></i>用例</a>
              </li>
            </#if>
        </ul>
      <#--任务模块-->
        <ul class="treeview-menu">
          <#if active_nav == "jobList">
            <li class="active treeview">
              <a href="${ctx}/job/"><i class="fa fa-list-ul"></i>任务列表</a>
            </li>
          <#else>
            <li>
              <a href="${ctx}/job/"><i class="fa fa-list-ul"></i>任务列表</a>
            </li>
          </#if>
        </ul>
      </li>

    <#--项目和框架模块-->
    <#if active_nav == "projectList" || active_nav == "frameworkList">
      <li class="active treeview">
    <#else>
      <li class="treeview">
    </#if>
      <a href="">
        <i class="fa fa-cog"></i>
        <span>设置</span>
        <i class="fa fa-angle-left pull-right"></i>
      </a>
      <ul class="treeview-menu">
      <#if active_nav == "projectList">
        <li class="active treeview">
          <a href="${ctx}/project/"><i class="fa fa-align-center"></i>项目列表</a>
        </li>
      <#else>
        <li>
          <a href="${ctx}/project/"><i class="fa fa-align-center"></i>项目列表</a>
        </li>
      </#if>

      <#if active_nav == "frameworkList">
        <li class="active treeview">
          <a href="${ctx}/framework/"><i class="fa fa-puzzle-piece"></i>测试框架列表</a>
        </li>
      <#else>
        <li>
          <a href="${ctx}/framework/"><i class="fa fa-puzzle-piece"></i>测试框架列表</a>
        </li>
      </#if>
        <li>
          <a href="${ctx}/swagger-ui.html" target="_blank"><i class="fa fa-calendar-o"></i>开放API</a>
        </li>
      </ul>
    </li>
    </ul><!-- /.sidebar-menu -->
  </div><!-- /.sidebar -->
</div><!-- /.main-sidebar -->
