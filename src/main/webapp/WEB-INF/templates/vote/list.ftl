<#assign active_nav="vote-list">
<#assign headContent>
<link type="text/css" href="${ctx}/static/css/dataTables.bootstrap.css"/>
<link type="text/css" href="${ctx}/static/css/dataTables.checkboxes.css"/>
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
  <h1>投票列表</h1>
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
              <th>ID编号</th>
              <th>名称</th>
              <th>状态</th>
              <th>创建时间</th>
              <th>投票详情</th>
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
<script src="${ctx}/static/js/jquery.mark.min.js"></script>
<script src="${ctx}/static/js/datatables.mark.min.js"></script>
<script type="application/javascript">
  $(document).ready(function () {
    function displayStatus(data) {
      if (data === 'initiate') return "<span class='label label-info'>initiate</span>";
      else if (data === 'terminate') return "<span class='label label-warning'>terminate</span>";
      else return "<span class='label label-danger'>outmoded</span>";
    }

    var table = $("#datatable").DataTable({
      "deferRender": true,
      "ajax": "${ctx}/v/vote-rest",
      "columnDefs": [{
        "targets": 2,
        "render": function (data, type, row, meta) {
          if (type === 'display') {
            return type === 'display' ? displayStatus(data) : data;
          }
          return data;
        }
      }, {
//          "orderable": false,
//          "searchable": false,
//          "data": 0,
        "targets": 4,
        "render": function (data, type, row, meta) {
          if (type === 'display') {
            return "<a href='${ctx}/v/voting/?id=" + data + "'>参与投票</a>";
          }
          return data;
        }
      }
      ],
      "language": {
        "url": "${ctx}/static/js/datatables-zh_CN.json"
      },
      "mark": true,
      "iDisplayLength": 50,
      "bSortClasses": true,
      "order": [[3, 'desc']]
    });


    setInterval(function () {
      table.ajax.reload();
    }, 5000);

  });


</script>
</#assign>
<#include "../layout/layout-main.ftl" />
