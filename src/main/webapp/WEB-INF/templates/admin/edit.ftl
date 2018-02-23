<#assign active_nav="vote-add">
<#assign headContent>
<link href="${ctx}/static/css/bootstrap-select.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/static/css/fileinput.css" rel="stylesheet" type="text/css"/>
</#assign>
<#assign breadcrumbContent>
<section class="content-header">
  <h1>编辑投票</h1>
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
        <form class="form-horizontal" action="${ctx}/admin/edit" method="post" id="myForm" role="form" data-toggle="validator">
          <div class="box-body">

            <div class="form-group">
              <label for="id" class="col-sm-2 control-label">投票ID</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" id="id" name="id" value="${vote.id!}" placeholder="必填" readonly>
                <div class="help-block with-errors"></div>
              </div>
            </div>

            <div class="form-group">
              <label for="voteName" class="col-sm-2 control-label">投票名称</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" id="voteName" name="voteName" value="${vote.voteName!}" placeholder="必填" required>
                <div class="help-block with-errors"></div>
              </div>
            </div>

            <div class="form-group">
              <label for="pastTime" class="col-sm-2 control-label">过期时间</label>
              <div class="col-sm-4">
                <input type="text" id="pastTime" name="pastTime" onfocus="WdatePicker({minDate:new Date(),onpicking: function(dp) {
                                         return false
                                }})" class="form-control Wdate" _vimium-has-onclick-listener="" value="${(vote.pastTime?string("yyyy-MM-dd"))!}" placeholder="默认2天过期">
              </div>
            </div>

            <div class="form-group">
              <label for="id" class="col-sm-2 control-label">投票选项</label>
              <div class="col-sm-4" id="options">
                <#list vote.optionNameList as optionName>
                  <input type="text" class="form-control" id="" name="" value="${optionName!}" placeholder="必填" >
                  <div class="help-block with-errors"></div>
                </#list>
              </div>
            </div>

          </div>
          <div class="box-footer clearfix">
            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-2">
                <button type="submit" class="btn btn-primary">确认提交</button>
                <button type="button" class="btn btn-default" onclick="history.back()">返回</button>
              </div>
              <div class="col-sm-offset-2 col-sm-3">
                <#--<a href="" class="btn btn-success btn-xs">复制新建</a>-->
                <a class="btn btn-xs btn-danger delete" data-toggle="modal" data-target="#myModal">删除</a>
              </div>
            </div>
            <div class="clearfix"></div>
          </div>
        </form>
      </div>
    </div>
  </div>
</section>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">危险</h4>
      </div>
      <div class="modal-body">删除之后不可恢复!!!</div>
      <div class="modal-footer">
        <a type="button" class="btn btn-default" data-dismiss="modal">取消</a>
        <a type="button" href="${ctx}/admin/delete?id=${vote.id!}" class="btn btn-danger actionDelete">确认删除</a>
      </div>
    </div>
  </div>
</div>
</#assign>
<#assign scriptContent>
<script src="${ctx}/static/js/validator.min.js"></script>
<script src="${ctx}/static/js/fileinput.js"></script>

<script>

</script>
</#assign>
<#include "../layout/layout-main.ftl" />
