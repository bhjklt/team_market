<%--
  Created by IntelliJ IDEA.
  User: CAIKE3
  Date: 7/15/2018
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>商家自荐</title>
</head>
<body>

<h1>商家自荐商铺审核</h1>

<table border="1" class="table">
    <tr>
        <td>商铺名称</td>
        <td>商铺地址</td>
        <td>竞价</td>
        <td>申请时间</td>
        <td>确认时间</td>
        <td>确认管理员</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${ads}" var="ad">
        <tr>
            <td>${ad.store.name}</td>
            <td>${ad.store.address}</td>
            <td>${ad.adForm.price}</td>
            <td>${ad.adForm.createTime}</td>
            <td>${ad.adForm.consumeTime}</td>
            <td>${ad.user.username}</td>
            <c:choose>
                <c:when test="${ad.adForm.consumeTime == null}">
                    <td><a href="http://localhost:9090/admin?method=confirmAd&id=${ad.adForm.id}">通过</a></td>
                </c:when>
                <c:otherwise>
                    <td style="color: green">已确认</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>

</table>

</body>
</html>
