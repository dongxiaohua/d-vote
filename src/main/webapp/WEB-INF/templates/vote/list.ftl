<#assign headContent>
<link href="//static.foneshare.cn/oss/AdminLTE/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css"/>
<link type="text/css" href="//static.foneshare.cn/oss/datatables-checkboxes/dataTables.checkboxes.css" rel="stylesheet"/>
<style>
  /*#datatable td:nth-child(5) {*/
    /*text-align: right;*/
  /*}*/

  /*#datatable td:nth-child(7) {*/
    /*text-align: right;*/
  /*}*/
</style>
</#assign>
<#assign breadcrumbContent>
<section class="content-header">
  <h1>任务列表</h1>
  <ol class="breadcrumb">
    <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
  </ol>
</section>
</#assign>

<#assign bodyContent>
<section class="content">
  <div class="row">
    <div class="col-md-12">
      <div class="box box-info">
        <div class="box-body">
          <table id="datatable" class="table table-hover table-bordered" cellspacing="0" width="100%">
            <thead>
            <tr>
              <th>ID</th>
              <th>状态</th>
              <th>创建人</th>
              <th>创建时间</th>
              <th>修改时间</th>
              <th>耗时</th>
              <th>刷库详情</th>
            </tr>
            </thead>
          </table>
        </div>
        <div class="box-footer clearfix">
        </div>
      </div>
    </div>
  </div>
</section>
</#assign>
<#assign scriptContent>
<script src="//static.foneshare.cn/oss/mark.js/8.6.0/jquery.mark.min.js"></script>
<script src="//static.foneshare.cn/oss/datatables.mark.js/2.0.0/datatables.mark.min.js"></script>
<script type="application/javascript">
  $(document).ready(function () {
    var table = $("#datatable").DataTable({
      "deferRender": true,
      "ajax": "${ctx}/v/vote-rest",
      "columnDefs": [
        {
          "targets": 1,
          "render": function (data, type, row, meta) {
            if (type === 'display') {
              return displayStatus(data);
            }
            return data;
          }
        },
        {
          "targets": 5,
          "render": function (data, type, row, meta) {
            if (type === 'display') {
              return msToTime(data);
            }
            return data;
          }
        },
        {
          "orderable": false,
          "searchable": false,
          "data": 0,
          "targets": 6,
          "render": function (data, type, row, meta) {
            if (type === 'display') {
              return "<a href='${ctx}/db/detail/?taskId=" + data + "'>投票详情</a>";
            }
            return data;
          }
        }
      ],
      "language": {
        "url": "${ctx}/static/js/datatables-zh_CN.json"
      },
      "mark": true,
      "iDisplayLength":50,
      "bSortClasses":true,
      "order": [[4, 'desc']]
    });


    setInterval(function () {
      table.ajax.reload();
    }, 5000);

  });


</script>
</#assign>
<#include "../layout/layout-main.ftl" />
