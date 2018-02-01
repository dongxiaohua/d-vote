<#assign headContent>
<link href="//static.foneshare.cn/oss/css/bootstrap-select.min.css" rel="stylesheet" type="text/css"/>
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

            <div id="selectBiz" class="form-group">
              <label for="bizId" class="col-sm-2 control-label">环境</label>
              <div class="col-sm-4">
                <select id="biz" name="biz" class="selectpicker show-tick form-control" title="请选择" data-live-search="true" required>
                  <#--<option value="1" selected="selected"></option>-->
                    <#list bizConfigList! as biz>
                      <#if biz == "foneshare">
                        <option value=${biz} selected="selected">${biz}</option>
                      <#else>
                        <option value=${biz}>${biz}</option>
                      </#if>
                    </#list>
                </select>
                <div class="help-block with-errors"></div>
              </div>
            </div>

            <div class="form-group">
              <label for="eids" class="col-sm-2 control-label">租户</label>
              <div class="col-sm-4">
                <textarea id="eidsAll" name="eidsAll" class="form-control" style="height: 140px" placeholder="输入'All'代表全刷" required></textarea>
                <div class="help-block with-errors"></div>
              </div>
            </div>

            <div class="form-group">
              <label for="hook" class="col-sm-2 control-label">处理地址</label>
              <div class="col-sm-4 input-group" style="padding-left: 15px;padding-right: 10px;">
                <span class="input-group-addon" id="basic-addon3">${headUrl!''}</span>
                <input type="text" class="form-control" id="hook" name="hook" value="" placeholder="必填" required>
              </div>
              <div class="help-block with-errors" style="padding-left: 290px;"></div>
            </div>


            <div class="form-group">
              <label for="sql" class="col-sm-2 control-label">查询语句</label>
              <div class="col-sm-4">
                  <textarea id="sql" name="sql" class="form-control" style="height: 140px" placeholder="
           例如：SELECT * FROM table WHERE ei=$!{ei}...或 WHERE tenant_id=$!{ei}..." required></textarea>
                <div class="help-block with-errors"></div>
              </div>
            </div>

            <div class="form-group">
              <label for="describe" class="col-sm-2 control-label">描述</label>
              <div class="col-sm-4">
              <#--<input type="text" class="form-control" id="describe" name="describe" value="" placeholder="必填" required>-->
                <textarea id="describe" name="describe" class="form-control" style="height: 100px"></textarea>
                <div class="help-block with-errors"></div>
              </div>
            </div>


          <#--&lt;#&ndash;文档上传&ndash;&gt;-->
            <#--<label for="sql" class="col-sm-3 control-label">SQL语句可上传</label>-->
            <#--<input type="file" name="upload" id="upload"/>-->
          <#--&lt;#&ndash; accept="text/plain" 属性规定只能是.txt文件&ndash;&gt;-->
          <#--&lt;#&ndash;文档上传end&ndash;&gt;-->

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
    <script src="//static.foneshare.cn/oss/jquery/bootstrap-select.min.js"></script>
<script src="//static.foneshare.cn/oss/bootstrap-3.3.6/js/validator.min.js"></script>
<script>

  <#--if ('${biz}' === "foneshare") {-->
    <#--$('#selectBiz').addClass('hide')-->
  <#--}-->

  //        文档上传
  /**
   * 上传函数
   * @param fileInput DOM对象
   * @param callback 回调函数
   */
  var getFileContent = function (fileInput, callback) {
    //限制文件类型
    var fileName = $('#upload').prop('files')[0].name;
    var index1 = fileName.lastIndexOf(".");
    var index2 = fileName.length;
    var fileType = fileName.substring(index1, index2);
//            限制文件大小
    var fileSize = $('#upload').prop('files')[0].size;
    if (fileType !== '.txt' && fileType !== '.sql') {
      alert('只允许上传".txt"或".sql"文件');
      return;
    } else if (fileSize > 2097152) {
      alert('文件不可超过2M');
      return;
    }
    if (fileInput.files && fileInput.files.length > 0 && fileInput.files[0].size > 0) {
      //下面这一句相当于JQuery的：var file =$("#upload").prop('files')[0];
      var file = fileInput.files[0];
      if (window.FileReader) {
        var reader = new FileReader();
        reader.onloadend = function (evt) {
          if (evt.target.readyState === FileReader.DONE) {
            callback(evt.target.result);
          }
        };
        // 包含中文内容用gbk编码
        reader.readAsText(file, 'utf-8');
      }
    }
  };
  /**
   * upload内容变化时载入内容
   */
//  document.getElementById('upload').onchange = function () {
//    var content = document.getElementById('sql');
//
//    getFileContent(this, function (str) {
//      content.value = str;
//    });
//  };
  //        /文档上传end


</script>
</#assign>
<#include "../layout/layout-main.ftl" />
