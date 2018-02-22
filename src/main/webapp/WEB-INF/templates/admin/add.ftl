<#assign active_nav="vote-add">
<#assign headContent>
<link href="${ctx}/static/css/bootstrap-select.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/static/css/fileinput.css" rel="stylesheet" type="text/css"/>
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
        <form class="form-horizontal" action="${ctx}/admin/add" method="post" id="myForm" role="form" data-toggle="validator">
          <div class="box-body">
            <div class="form-group">
              <label for="voteName" class="col-sm-2 control-label">投票名称</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" id="voteName" name="voteName" value="" placeholder="必填" required>
                <div class="help-block with-errors"></div>
              </div>
            </div>

            <div class="form-group">
              <label for="pastTime" class="col-sm-2 control-label">过期时间</label>
              <div class="col-sm-4">
                <input type="text" id="pastTime" name="pastTime" onfocus="WdatePicker({onpicking: function(dp) {
                                         return false
//                    if (!confirm('日期框原来的值为: ' + dp.cal.getDateStr() + ', 要用新选择的值:' + dp.cal.getNewDateStr() + '覆盖吗?')) {
//                                        return true;
//                                    }
                                }})" class="form-control Wdate" _vimium-has-onclick-listener="" placeholder="默认2天过期">
              </div>
            </div>

            <br>
            <div class="form-group" id="options">
              <label for="voteName" class="col-sm-2 control-label">选项名称</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" id="optionName1" name="optionName1" value="" placeholder="必填" required>
                <div class="help-block with-errors"></div>
              </div>
              <button type="button" id="addOption" style="margin-left: 50%" class="btn btn-info btn-xs">添加选项</button>
            </div>

          </div>
          <div class="box-footer clearfix">
            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-2">
                <button type="button" id="sub" class="btn btn-primary">创建投票</button>
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
<script src="${ctx}/static/js/fileinput.js"></script>
<script src="http://yanshi.sucaihuo.com/jquery/1/177/demo/My97DatePicker/WdatePicker.js"></script>
<script>
  var num = 1;
  $('#addOption').on('click', function () {
    num++;
    var optionString = '<div class="form-group">' +
            '<label for="voteName" class="col-sm-2 control-label"></label>' +
            '<div class="col-sm-4">' +
            '<input type="text" class="form-control" id="optionName' + num + '" name="voteName' + num + '" value="" placeholder="必填" required>' +
            '<div class="help-block with-errors"></div>' +
            '</div>' +
            '</div>';
    $('#options').append(optionString)
  });
  //    提交按钮
  $('#sub').on('click', function () {
    var voteNamre = $('#voteName').val();
    var pastTime = $('#pastTime').val();
    var options = [];
    for (var i = 1; i < num + 1; i++) {
        var optionName = $('#optionName' + i).val();
        if (optionName !== undefined) {
          options.push(optionName);
        } else {
            continue
        }
    }
    var dataObject = {
      voteName: voteNamre,
      pastTime: pastTime,
      options: options
    };
    console.log(dataObject);
  httpPost("${ctx}/admin/add", dataObject);
  });

  function httpPost(URL, PARAMS) {
    var temp = document.createElement("form");
    temp.action = URL;
    temp.method = "post";
    temp.style.display = "none";

    for (var x in PARAMS) {
      var opt = document.createElement("textarea");
      opt.name = x;
      opt.value = PARAMS[x];
      temp.appendChild(opt);
    }

    document.body.appendChild(temp);
    temp.submit();

    return temp;
  }

</script>
</#assign>
<#include "../layout/layout-main.ftl" />
