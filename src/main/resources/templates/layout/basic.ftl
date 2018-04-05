<#compress>
<!DOCTYPE html>
<html>
<head>
    <title>${title!"DefaultPage"}</title>
    <#-- 媒体头插入点 -->
    <#include "/meta/"+defaultMetaName+".ftl" parse=true encoding="utf-8">

    <#-- CSS引入插入点 -->
    <#include "/style/"+defaultStyleName+".ftl" parse=true encoding="utf-8">

    <#-- JS脚本引入插入点 -->
    <#include "/script/"+defaultScriptName+".ftl" parse=true encoding="utf-8">

</head>
<body>
    <#-- 页面内容引入插入点 -->
    <#include "/pages/"+pageName+".ftl" parse=true encoding="utf-8">

</body>
</html>
</#compress>