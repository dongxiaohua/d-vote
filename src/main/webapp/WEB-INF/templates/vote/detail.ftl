<#assign active_nav="vote-add">
<#assign headContent>

</#assign>
<#assign breadcrumbContent>
<section class="content-header">
  <h1>投票详情</h1>
  <ol class="breadcrumb">
    <li><a href="../"><i class="fa fa-dashboard"></i>任务主页</a></li>
    <li><a href=""><i class="fa fa-dashboard"></i>详情</a></li>
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
          <a href="${ctx}/v/voting?id=${voteId!}" class="btn btn-xs btn-warning">我要参与</a>
        </div>
        <div class="box-body">
        <#--视图区域-->
          <div id="container"></div>
        </div>
        <div class="box-footer clearfix">
          <div class="form-group">
            <div class="col-sm-offset-4 col-sm-2">
              <span type="button" id="chartType" class="btn btn-info btn-sm">查看曲线图</span>
              <span type="button" id="chartColor" class="btn btn-default btn-sm">更改颜色</span>
            </div>
          </div>
          <div class="clearfix"></div>
        </div>
      </div>
    </div>
  </div>
</section>
</#assign>
<#assign scriptContent>
<script src="${ctx}/static/js/validator.min.js"></script>
<script src="${ctx}/static/js/highcharts.js"></script>
<script>
  $(document).ready(function () {
    var voteNames = [];
    var voteOptions = [];
      <#if voteOptionList??>
          <#list voteOptionList as voteOption>
            voteNames.push('${voteOption.optionName}');
            voteOptions.push(${voteOption.optionPoll});
          </#list>
      </#if>
    var chartType = 'column';
    var chartColor = '#3A9AFF';
    chart(chartType, voteNames, voteOptions, chartColor);
    $('#chartType').on('click', function () {
      if (chartType === 'areaspline') {
        chartType = 'column';
        $('#chartType').html('查看曲线图')
      } else {
        chartType = 'areaspline';
        $('#chartType').html('查看柱状图')
      }
      chart(chartType, voteNames, voteOptions, chartColor);
    });
    $('#chartColor').on('click', function () {
      if (chartColor === "#3A9AFF") {
        chartColor = '#47B648';
        $('#chartType').removeClass('btn btn-info btn-sm');
        $('#chartType').addClass('btn btn-success btn-sm');
      } else if (chartColor === "#47B648") {
        chartColor = '#F71F1F';
        $('#chartType').removeClass('btn btn-success btn-sm');
        $('#chartType').addClass('btn btn-danger btn-sm');
      } else if (chartColor === '#F71F1F') {
        chartColor = '#3A9AFF';
        $('#chartType').removeClass('btn btn-danger btn-sm');
        $('#chartType').addClass('btn btn-info btn-sm');
      }
      chart(chartType, voteNames, voteOptions, chartColor);
    });
  });

  function chart(chartType, voteNames, voteOptions, chartColor) {
    $('#container').highcharts({
      chart: {
//              柱状图
        type: chartType
//      type:'line'
      },
      title: {
        text: "${voteName!}"
      },
      subtitle: {
        text: '数据来源: 网络投票'
      },
      xAxis: {
//        type: 'datetime',
        categories: voteNames,
//        categories:pNameList,
        crosshair: true,
        title: {
          text: '选项名称'
        }
      },
      yAxis: {
        min: 0,
        tickInterval: 2, // 刻度值
        title: {
          text: '得票数量'
        }
      },
      credits: {
        enabled: true, // 禁用版权信息
        href: 'https://github.com/dongxiaohua/d-vote',
        text: 'Copyright:dongxiaohua',
        style: {
          cursor: 'pointer',
          color: '#909090',
          fontSize: '10px'
        }
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
        name: '得票数',
        data: voteOptions,
        color: chartColor
      }
      ]
    });
  }


</script>
</#assign>
<#include "../layout/layout-main.ftl" />
