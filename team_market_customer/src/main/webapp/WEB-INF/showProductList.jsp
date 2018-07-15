<%--
  Created by IntelliJ IDEA.
  User: LIUJU7
  Date: 7/15/2018
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>该店所有菜品</title>
</head>
<body>
<h1>该店所有菜品</h1>
<hr>
<c:forEach items="${products}" var="product">
    <p>菜品ID：${product.id}</p>
    <p>商家ID：${product.sId}</p>
    <p>菜品名称：${product.name}</p>
    <p>菜品描述：${product.description}</p>
    <p>菜品图片：${product.images}</p>
    <p>菜品价格：${product.price}</p>
    <p>菜品数量：${product.quantity}</p>
    <p>创建时间：${product.createTime}</p>
    <hr>
</c:forEach>
</body>
</html>
