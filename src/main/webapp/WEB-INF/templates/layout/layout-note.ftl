<#if success??>
<div class="pad margin no-print" style="padding: 5px; border-radius: 0px;">
  <div class="callout callout-success" style="margin-bottom: 0!important;">
    <h4><i class="icon fa fa-check"></i> Success:</h4>
  ${success}
  </div>
</div>
</#if>

<#if info??>
<div class="callout callout-info" style="margin-bottom: 0!important; padding: 5px; border-radius: 0px;">
  <h4><i class="icon fa fa-info"></i> Note:</h4>
${info}
</div>
</#if>

<#if warning??>
<div class="alert alert-warning alert-dismissible" style="padding: 5px; border-radius: 0px;">
  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
  <h4><i class="icon fa fa-warning"></i> Warning:</h4>
${warning}
</div>
</#if>

<#if error??>
<div class="alert alert-danger alert-dismissible" style="padding: 5px; border-radius: 0px;">
  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
  <h4><i class="icon fa fa-ban"></i> Error:</h4>
${error}
</div>
</#if>

<#if message??>
<div class="alert alert-danger alert-dismissible" style="padding: 5px; border-radius: 0px;">
  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
  <h4><i class="icon fa fa-warning"></i> Message:</h4>
${message}
</div>
</#if>
