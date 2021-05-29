<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<#-- Freemarker -->
<#--一个用java编写的模板引擎，适合作为web项目中的视图层组件，是生成文本的工具。-->
<#--freemarker区分大小写   比如，list List-->
<#--在ftl文件中，分为如下组成部分：-->
<#--文本(静态的)，插值(动态的)，标签，注释-->
    Hi Freemarker,现在时间是 ${now}
    <br>
    ${"Hi Freemarker,现在时间是 ${.now}"}
    <br>
    ${"Hi Freemarker,现在时间是 "+.now}

<#-- =(==):判断两个值是否相等 -->
<#-- !=:不相等 -->
<#-- >(gt):判断左边是否大于右边 -->
<#-- >=(gte): -->
<#-- <(lt): -->
<#-- <=(lte): -->

<#-- 定义变量 -->
    <#assign info1 = ' how to do?'>
<#--    字符串的拼接-->
    <p>Hello ${info + info1}</p>
<#--    字符串的内嵌函数(有参数就有括号，没参数没括号)-->
    <p>${info1?substring(1,4)}</p>
    <p>${info1?length}</p>

<#--    if条件判断-->
    <#assign num = 666>
    <#if num == 666>
        <p>666</p>
    <#elseif num == 888>
        <p>888</p>
    <#else>
        <p>000</p>
    </#if>

    <#-- switch -->
    <#switch num>
        <#case 666>
            <p>666</p>
            <#break>
        <#case 888>
            <p>888</p>
            <#break>
        <#default>
            <p>000</p>
    </#switch>

    <!-- list的使用 别名_index（下标） 别名_has_next（当前项是否有下一项）-->
    <h5>无序数组</h5>
    <#assign myList = [6,2,3,4,5,1]>
    <#list myList as item>
        <p>${item_index + ' ' +  item}</p>
    </#list>
<hr>
<#--升序用sort_by()-->
<#--<#list list?sort_by("字段") as x>-->
<#--</#list>-->
<#--降序用sort_by()?reverse-->
<#--<#list list?sort_by("字段")?reverse as x>-->
<#--</#list>-->
    <h5>有序数组</h5>
    <#list myList?sort as item>
        <p>${item}</p>
    </#list>
<hr>
    <#list [7,8,9] as item>
        <p>${item}</p>
    </#list>
<hr>
    <#list 10..12 as item>
        <p>${item}</p>
    </#list>
<hr>
    <#list personList as item>
        <p>${item_index + ' ' +  item.name + ' ' + item.age}</p>
    </#list>
<hr>
    <#list personList as item>
        <#if item_has_next>
            <p>${item_index + ' ' +  item.name + ' ' + item.age}</p>
        </#if>
    </#list>
<hr>
    <#list personList as item>
        <#if item.age != 19>
            <p>${item_index + ' ' +  item.name + ' ' + item.age}</p>
        <#else>
            <#break>
        </#if>
    </#list>
<hr>
    <#-- 判断变量是否为空 -->
    <#assign str = 'null'>
    <p>${str!'str是空'}</p>
    <p>${testNull!'testNull是空'}</p>
<hr>
    <#-- 在当前文件中导入其他ftlh文件 读取修改其中变量的值 -->
    <#import "other.ftlh" as otherFtlh>
    <p>${otherFtlh.importVar}</p>
    <#assign importVar = 'cur variable' in otherFtlh>
    <p>${otherFtlh.importVar}</p>

</body>
</html>