<#assign headContent>
<link href="${ctx}/static/css/bootstrap-select.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/static/css/fileinput.css" rel="stylesheet" type="text/css"/>
</#assign>
<#assign breadcrumbContent>
<section class="content-header">
  <h1>投票</h1>
  <ol class="breadcrumb">
    <li><a href="../"><i class="fa fa-dashboard"></i>任务主页</a></li>
    <li><a href=""><i class="fa fa-dashboard"></i>投票</a></li>
  </ol>
</section>
</#assign>
<#assign bodyContent>
<section class="content">
  <div class="row">
    <div class="col-md-12">
      <div class="box box-info">
        <div class="box-header with-border">
          <h4 class="box-title">当前投票名称:</h4>
          <h3 class="box-title btn btn-info">${vote.voteName!}</h3>
        </div>
        <form class="form-horizontal" action="${ctx}/v/voting" method="post" id="myForm" role="form" data-toggle="validator">
          <div class="box-body">
              <#list optionList as option>
                <div class="form-group">
                  <div class="checkbox">
                    <label class="col-sm-offset-2">
                      <input type="radio" value="${option.id!}" name="optionId"> ${option.optionName!}
                    </label>
                  </div>
                </div>
              </#list>
            <div class="form-group">
              <div class="checkbox">
                <label class="col-sm-offset-2">
                <input type="radio" checked="checked" value="" id="otherOptionVal" name="optionId"> 新添加选项
                  <input type="text" class="form-control" id="otherOption" name="otherOption" value="" placeholder="你可以填写其他选择">
                </label>
              </div>
            </div>

          </div>
          <div class="box-footer clearfix">
            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-2">
                <button type="button" id="submitBut" class="btn btn-primary">确认投票</button>
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
<div class="modal fade" id="optionModal" tabindex="-1" role="dialog" aria-labelledby="sqlModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                class="sr-only">Close</span></button>
        <h4 class="modal-title" id="stopModalLabel">提示信息</h4>
      </div>
      <div class="modal-body">
        请选择或添加新选项！
      </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
</#assign>
<#assign scriptContent>
<script src="${ctx}/static/js/validator.min.js"></script>
<script src="${ctx}/static/js/fileinput.js"></script>
<script type="text/javascript">

  $(document).ready(function () {
    $('#submitBut').on('click', function () {
      var optionId = "";
      var radio = document.getElementsByName("optionId");
      //此处循环需加1，提供了添加选项功能

      for (var i = 0; i < radio.length +1; i++) {
        if (radio[i].checked === true) {
          optionId = radio[i].value;
          break;
        }
      }
      var otherOption = $('#otherOption').val();
      if (optionId === "" && otherOption !== "") {
        optionId = 0;
      }
      if (optionId === "" && otherOption === "") {
        $('#optionModal').modal('show');
        return;
      }
      console.log(optionId);
      var voteId = '${vote.id!}';
      var dataObject = {
        optionId:optionId,
        otherOption:otherOption,
        voteId:voteId
      };
      httpPost("${ctx}/v/voting",dataObject)
    });
  });

//  js发送post请求
  function httpPost(URL, dataObject) {
    var temp = document.createElement("form");
    temp.action = URL;
    temp.method = "post";
    temp.style.display = "none";
    for (var x in dataObject) {
      var opt = document.createElement("textarea");
      opt.name = x;
      opt.value = dataObject[x];
      temp.appendChild(opt);
    }
    document.body.appendChild(temp);
    temp.submit();
    return temp;
  }

</script>
</#assign>

<#include "../layout/layout-main.ftl" />
