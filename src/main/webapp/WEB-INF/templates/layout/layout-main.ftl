<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="renderer" content="webkit">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="format-detection" content="telephone=no">
  <title>D-VOTE</title>

  <link href="${ctx}/static/css/datatables.min.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link href="${ctx}/static/css/ionicons.min.css" rel="stylesheet" type="text/css"/>
  <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <link href="${ctx}/static/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/static/css/_all-skins.min.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/static/css/global.css" rel="stylesheet" type="text/css"/>


${headContent}
</head>

<#if header_nav??>
<#--skin可变换模板颜色-->
<body class="hold-transition skin-blue sidebar-mini fixed sidebar-collapse" data-spy="scroll" data-target="#scrollspy">
<#elseif no_nav??>
<body class="hold-transition skin-blue" data-spy="scroll" data-target="#scrollspy">
<#else >
<body class="hold-transition skin-blue fixed sidebar-mini" data-spy="scroll" data-target="#scrollspy">
</#if>
<div class="wrapper">
<#if !no_nav??>
    <#include "layout-header.ftl" />
    <#include "layout-sidebar.ftl" />
</#if >

  <div class="content-wrapper" #if(no_nav)style="margin:0px;" #end>

  ${breadcrumbContent}

    <#include "layout-note.ftl" />

    ${bodyContent}

  </div>

<#if !header_nav?? && !no_nav??>
    <#include "layout-footer.ftl" />
</#if>
<#if !no_nav??>
    <#include "layout-control-sidebar.ftl" />
</#if>

</div>

<script src="${ctx}/static/js/jquery.min.js"></script>
<#--<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>-->
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/datatables.min.js"></script>
<script src="${ctx}/static/js/jquery.slimscroll.min.js"></script>
<script src="${ctx}/static/js/fastclick.min.js"></script>
<script src="${ctx}/static/js/AdminLTE.min.js"></script>
<script src="${ctx}/static/js/jquery.mark.min.js"></script>
<script src="${ctx}/static/js/bootstrap-select.min.js"></script>
<script src="${ctx}/static/js/dataTables.checkboxes.min.js"></script>
<script src="${ctx}/static/js/global.js"></script>
<script src="http://yanshi.sucaihuo.com/jquery/1/177/demo/My97DatePicker/WdatePicker.js"></script>
<#--<script src="${ctx}/static/js/app.js"></script>-->

${scriptContent}

<script>
    <#--控制导航栏的js-->
    $("ul.treeview-menu a").each(function () {
      if (window.location.href.startsWith(this.href)) {
        $(this).parent("li").addClass("active");
        $(this).parents().parents().parents("li").addClass("active");
      }
    });
    //  版本控制
    $('#versionData').html("Copyright &copy; 2011- " + new Date().getFullYear() + " <a href='https://github.com/dongxiaohua/d-vote'>dongxiaohua</a>.")
</script>
</body>
</html>
