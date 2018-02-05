<#assign headContent>
<link href="${ctx}/static/css/bootstrap-select.min.css" rel="stylesheet" type="text/css"/>
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
                    <input type="checkbox" value="${option.id!}" name="optionId">${option.optionName!}
                  </label>
                </div>
              </div>
            </#list>
            <div class="form-group">
              <div class="checkbox">
                <label class="col-sm-offset-2">
                  <input type="checkbox" value="${vote.id!}" name="voteId">
                  <input type="text" class="form-control" id="otherOption" name="otherOption" value="" placeholder="你可以有其他选择">
                </label>
              </div>
            </div>

          </div>
          <div class="box-footer clearfix">
            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-2">
                <button type="submit" class="btn btn-primary">确认投票</button>
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



</#assign>

<#include "../layout/layout-main.ftl" />
