<%--
  Created by IntelliJ IDEA.
  User: wzh
  Date: 2023/10/8
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<table border="1">
  <tr>
    <th>序号</th>
    <th>商品名称</th>
    <th>零售价</th>
    <th>供应商</th>
    <th>成本价</th>
  </tr>
  <jsp:useBean id="list" scope="request" type="java.util.List"/>
  <c:forEach items="${ list }" var="pro">
    <tr>
      <td>${pro.id }</td>
      <td>${pro.productName }</td>
      <td>${pro.salePrice }</td>
      <td>${pro.supplier }</td>
      <td>${pro.costPrice }</td>
    </tr>
  </c:forEach>
</table>


</body>
</html>
