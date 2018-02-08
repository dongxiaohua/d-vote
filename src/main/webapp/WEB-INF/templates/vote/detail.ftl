<#assign active_nav="vote-add">
<#assign headContent>

</#assign>
<#assign breadcrumbContent>
<section class="content-header">
  <h1>创建投票</h1>
  <ol class="breadcrumb">
    <li><a href="../"><i class="fa fa-dashboard"></i>任务主页</a></li>
    <li><a href=""><i class="fa fa-dashboard"></i>创建投票</a></li>
  </ol>
</section>
</#assign>
<#assign bodyContent>
<section class="content">
  <div class="row">
    <div class="col-md-12">
      <div class="box box-info">
        <div class="box-header with-border">
          <h3 class="box-title"></h3>
        </div>
        <form class="form-horizontal" action="${ctx}/v/add" method="post" id="myForm" role="form" data-toggle="validator">
          <div class="box-body">

            <div id="container"></div>

          </div>
          <div class="box-footer clearfix">
            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-2">
                <button type="submit" class="btn btn-primary">执行刷库</button>
                <button type="button" class="btn btn-default" onclick="history.back()">返回</button>
              </div>
            </div>
            <div class="clearfix"></div>
          </div>
        </form>
      </div>
    </div>
  </div>
</section>
</#assign>
<#assign scriptContent>
<script src="${ctx}/static/js/validator.min.js"></script>
<script src="${ctx}/static/js/highcharts.js"></script>
<script>

  $('#container').highcharts({
    chart: {
//              柱状图
      type: 'column'
    },
    title: {
      text: '投票详情'
    },
    subtitle: {
      text: '数据来源: 网络投票'
    },
    xAxis: {
//        type: 'datetime',
      categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
//        categories:pNameList,
      crosshair: true,
      title: {
        text: '选项名称'
      }
    },
    yAxis: {
      min: 0,
      tickInterval:2, // 刻度值
      title: {
        text: '得票数量'
      }
    },
    credits: {
      enabled: false // 禁用版权信息
    },
//      自定义提示内容------------将柱状图信息合并
    tooltip: {
      headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
      pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
      '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
      footerFormat: '</table>',
      shared: true,
      useHTML: true
    },
    plotOptions: {
      column: {
        borderWidth: 0
      }
    },
    series: [{
      name: '总Case数',
      data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4],
      color:'#3A9AFF'
    }, {
      name: '成功Case数',
      data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3],
      color:'#47B648'
    }, {
      name: '失败Case数',
      data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2],
      color:'#F71F1F'
    }, {
      name: 'Skip数',
      data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1],
      color:'#1B1B1B'
    }
    ]
  });


  });

</script>
</#assign>
<#include "../layout/layout-main.ftl" />
