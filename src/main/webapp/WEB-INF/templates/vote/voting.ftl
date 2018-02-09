<#assign headContent>
<link href="${ctx}/static/css/bootstrap-select.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/static/css/fileinput.css" rel="stylesheet" type="text/css"/>
<style>
  html {
    background-color: #000;
  }
  body{
    height: 100%;
    top: 0px;
    bottom: 0px;
  }
  @keyframes spinsun {
    0% { transform: rotate(0); }
    100%   { transform: rotate(-360deg); }
  }
  @keyframes shadow {
    0% { background-position: 130% 0%; }
    33%{ background-position: 50% 0%; }
    55% { background-position: 0% 0%; }
    80%{ background-position: -50% 0%; }
    100%{ background-position: -50% 0%; }
  }
  @keyframes orbitmercury {
    0% { z-index:2; transform: rotateY(0); }
    49% { z-index:2; }
    50% { z-index:-2; }
    99% { z-index:-2; }
    100%   { z-index:2; transform: rotateY(360deg); }
  }
  @keyframes orbitvenus {
    0% { z-index:3; transform: rotateY(0); }
    49% { z-index:3; }
    50% { z-index:-3; }
    99% { z-index:-3; }
    100%   { z-index:3; transform: rotateY(360deg); }
  }
  @keyframes orbitearth {
    0% { z-index:4; transform: rotateY(0); }
    49% {z-index:4;}
    50% {z-index:-4;}
    99% {z-index:-4;}
    100%   { z-index:4; transform: rotateY(360deg);}
  }
  @keyframes orbitmars {
    0% { z-index:5; transform: rotateY(0); }
    49% { z-index:5; }
    50% { z-index:-5; }
    99% { z-index:-5; }
    100%   { z-index:5; transform: rotateY(360deg); }
  }
  @keyframes orbitjupiter {
    0% { z-index:6; transform: rotateY(270); }
    49% { z-index:6; }
    50% { z-index:-6; }
    99% { z-index:-6; }
    100%   { z-index:6; transform: rotateY(360deg); }
  }
  @keyframes orbitsaturn {
    0% { z-index:7; transform: rotateY(270); }
    49% { z-index:7; }
    50% { z-index:-7; }
    99% { z-index:-7; }
    100%   { z-index:7; transform: rotateY(360deg); }
  }
  /* Keep planet image flat */
  @keyframes anti-spin {
    from { transform: rotateY(0); }
    to   { transform: rotateY(-360deg); }
  }
  @keyframes anti-spin-rings {
    from { transform: rotateY(0) rotateX(73deg); }
    to   { transform: rotateY(-360deg) rotateX(73deg); }
  }

  /* scene wrapper */
  .wrapper{
    position:relative;
    margin: 0 auto;
    display:block;
    margin-top: -10px;
    perspective: 1000px;
    perspective-origin: 60% 50%;
    /*   transform: rotate(-10deg); */

  }
  .wrapper > div {
    position: relative;
    margin: 0 auto;
    transform-style: preserve-3d;
    height: 0px;
  }
  .sun {
    width: 250px;
    position: absolute;
    top: 0px;
    z-index: 1;
    height: 125px !important;
  }
  .sun .star {
    width: 150px;
    height: 150px;
    background: url(http://www.waynedunkley.com/img/solar_system/sun.png) no-repeat;
    background-size: cover;
    border-radius: 250px;
    margin: 0 auto;
    animation: spinsun 40s infinite linear;
  }
  .planet {
    background-size: cover;
    background-repeat: no-repeat;
    background-color: transparent;
    animation-iteration-count: infinite;
    overflow:hidden;
  }
  .shadow {
    position: absolute;
    left: 0px;
    right: 0px;
    top: 0px;
    bottom: 0px;
    background: transparent url(http://www.waynedunkley.com/img/solar_system/shadow.png) 0% 0% no-repeat;
    background-size: cover;
    border-radius: 100%;
  }
  .mercury {
    position: absolute;
    width: 400px;
    z-index:2;
    animation: orbitmercury 12s infinite linear;
    top: -7.5px; /*half of planets height to keep orbits in line*/
  }
  .mercury .planet {
    width:15px;
    height:15px;
    background-image: url(http://www.waynedunkley.com/img/solar_system/mercury.png);
    animation: anti-spin 12s infinite linear;
  }
  .mercury .shadow {
    animation: shadow 12s infinite linear;
  }
  .venus {
    position: absolute;
    width: 506px;
    z-index:3;
    animation: orbitvenus 15s infinite linear;
    top: -19px;
  }
  .venus .planet {
    width:38px;
    height:38px;
    background-image: url(http://www.waynedunkley.com/img/solar_system/venus.png);
    animation: anti-spin 15s infinite linear;
  }
  .venus .shadow {
    animation: shadow 15s infinite linear;
  }
  .earth {
    position: absolute;
    width: 610px;
    z-index:4;
    animation: orbitearth 20s infinite linear;
    top: -20px;
  }
  .earth .planet {
    width:40px;
    height:40px;
    background-image: url(http://www.waynedunkley.com/img/solar_system/earth.png?v=2);
    animation: anti-spin 20s infinite linear;
  }
  .earth .shadow {
    animation: shadow 20s infinite linear;
  }
  .mars {
    position: absolute;
    width: 706px;
    z-index:5;
    animation: orbitmars 30s infinite linear;
    top: -11px;
  }
  .mars .planet {
    width:22px;
    height:22px;
    background-image: url(http://www.waynedunkley.com/img/solar_system/mars.png);
    animation: anti-spin 30s infinite linear;
  }
  .mars .shadow {
    animation: shadow 30s infinite linear;
  }
  .jupiter {
    position: absolute;
    width: 1100px;
    z-index:6;
    animation: orbitjupiter 50s infinite linear;
    top: -64px;
  }
  .jupiter .planet {
    width:88px;
    height:88px;
    background-image: url(http://www.waynedunkley.com/img/solar_system/jupiter.png);
    animation: anti-spin 50s infinite linear;
  }
  .jupiter .shadow {
    animation: shadow 50s infinite linear;
  }

</style>
</#assign>
<#assign breadcrumbContent>
<section class="content-header">
  <h1>投票</h1>
  <ol class="breadcrumb">
    <li><a href="../../"><i class="fa fa-dashboard"></i>主页</a></li>
    <li><a href=""><i class="fa fa-dashboard"></i>投票</a></li>
  </ol>
</section>
</#assign>
<#assign bodyContent>
<section class="content">
<#--3D-->
  <div style="height: 200px;width: 100%;">
    <ul class="wrapper">
      <div class="sun">
        <div class="star"></div>
      </div>
      <div class="mercury">
        <div class="planet">
          <div class="shadow"></div>
        </div>
      </div>
      <div class="venus">
        <div class="planet">
          <div class="shadow"></div>
        </div>
      </div>
      <div class="earth">
        <div class="planet"><div class="shadow"></div></div>
      </div>
      <div class="mars">
        <div class="planet"><div class="shadow"></div></div>
      </div>
      <div class="jupiter">
        <div class="planet"><div class="shadow"></div></div>
      </div>
    </ul>
  </div>
  <div class="row">
    <div class="col-md-12">
      <#--最新投票展示-->
      <div class="box box-info">
        <h6 class="btn btn-info btn-xs">热门投票</h6>
        <table id="datatable" class="table table-hover table-bordered" cellspacing="0" width="100%">
          <thead>
          <tr>
            <th>${vote.voteName}</th>
            <th>${vote.voteName}</th>
            <th>${vote.voteName}</th>
          </tr>
          </thead>
        </table>
      </div>
        <#--投票-->
      <div class="box box-info">
        <div class="box-header with-border">
          <h4 class="box-title">当前投票名称:</h4>
          <button value="${vote.id!}" class="box-title btn btn-default" id="voteDetail">${vote.voteName!}</button>
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
        <h4 class="modal-title" id="stopModalLabel">提示信息&nbsp;
          <img src="${ctx}/static/images/jg.png" style="width: 25px;height: 20px">
        </h4>
      </div>
      <div class="modal-body">
        请添加新选项！
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

    /**
     * 点击名称进入详情页
     */
    $('#voteDetail').on('click',function () {
      var voteId = this.value;
      window.location.href="${ctx}/v/detail?voteId=" + voteId;
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
