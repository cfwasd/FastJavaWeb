<%--
  Created by IntelliJ IDEA.
  User: wzh
  Date: 2023/10/19
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>源码快讯 管理中心 - 新闻列表</title>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <link href="style/general.css" rel="stylesheet" type="text/css">
    <link href="style/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>
    <span class="action-span"><a href="__Group__/Goods/goodsAdd">添加新闻</a></span>
    <span class="action-span1"><a href="__Group__">源码快讯 管理中心</a></span>
    <span id="search-id" class="action-span1"> - 新闻列表</span>
    <div style="clear: both"></div>
</h1>
<div class="form-div">
    <form action="" name="searchForm">
        <img src="img/icon_search.gif" width="26" height="20" border="0" alt="search" />
        <select name="cat_id">
            <option value="0">新闻分类</option>
            <forEach items="at_list" var="val">
                <option value="<{$val.cat_id}>"><{$val.cat_name}></option>
            </forEach>
        </select>

        <select name="intro_type">
            <option value="0">是否推荐</option>
            <option value="is_beast">---全部---</option>
            <option value="is_new">是</option>
            <option value="is_hot">否</option>
        </select>

        关键字<input type="text" name="keyword" size="15"/>
        <input type="submit" value="搜索" class="button"/>
    </form>
</div>
<form method="post" action="" name="listform" onsubmit="">
    <div class="list-div" id="listDiv">
        <table cellpadding="3" cellspacing="1">
            <tr>
                <th>编号</th>
                <th>新闻标题</th>
                <th>新闻类型</th>
                <th>是否推荐</th>
                <th>点击量</th>
                <th>录入时间</th>
                <th>录入人</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${newslist}" var="news">
                <tr>
                    <td align="center">${news.id }</td>
                    <td align="center" class="first-cell">${news.title }</td>
                    <td align="center">${news.type_id }</td>
                    <td align="center" >
<%--                            ${news.isRecommend }--%>
                        <img src="img/yes.gif">
                    <td align="center">${news.viewCount }</td>
                    <td align="center">${news.inputDate }</td>
                    <td align="center">${news.user_id }</td>
                    </td>
                    <td align="center">
                        <a href="" target="_blank" title="查看" ><img src="img/icon_view.gif" width="16" height="16" border="0"> </a>
                        <a href="" target="编辑" title="查看" ><img src="img/icon_edit.gif" width="16" height="16" border="0"> </a>
                        <a href="/news?id=${ news.id }&cmd=delete" target="回收站" title="查看" ><img src="img/icon_trash.gif" width="16" height="16" border="0"> </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
<script>
    function sure(){
        alert("是否删除")
    }
</script>

</body>
</html>
