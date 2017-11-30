<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="renderer" content="webkit">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="format-detection" content="telephone=no">
  <title>${title!}</title>
  <#--<link href="//static.foneshare.cn/oss/datatables-1.10.13/datatables.min.css" rel="stylesheet" type="text/css"/>-->
  <link href="//static.foneshare.cn/oss/datatables-1.10.15/datatables.min.css" rel="stylesheet" type="text/css"/>
  <link href="//static.foneshare.cn/oss/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  <link href="//static.foneshare.cn/oss/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
  <link href="//static.foneshare.cn/oss/ionicons-2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css"/>
  <link href="//static.foneshare.cn/oss/AdminLTE/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
  <link href="//static.foneshare.cn/oss/AdminLTE/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/static/css/global.css" rel="stylesheet" type="text/css"/>
${headContent}
</head>

<#if header_nav??>
<body class="hold-transition skin-blue fixed sidebar-collapse" data-spy="scroll" data-target="#scrollspy">
<#elseif no_nav??>
<body class="hold-transition skin-blue" data-spy="scroll" data-target="#scrollspy">
<#else >
<body class="hold-transition skin-blue fixed" data-spy="scroll" data-target="#scrollspy">
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

<script src="//http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="//https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<#--<script src="//static.foneshare.cn/oss/AdminLTE/plugins/fastclick/fastclick.min.js"></script>-->
<#--<script src="//static.foneshare.cn/oss/AdminLTE/dist/js/app.js"></script>-->
<script src="//cdn.bootcss.com/jQuery-slimScroll/1.3.6/jquery.slimscroll.min.js"></script>
<#--<script src="//static.foneshare.cn/oss/mark.js/8.6.0/jquery.mark.min.js"></script>-->
<#--<script src="//static.foneshare.cn/oss/datatables.mark.js/2.0.0/datatables.mark.min.js"></script>-->
<script src="${ctx}/static/js/global.js"></script>

${scriptContent}

</body>
</html>
