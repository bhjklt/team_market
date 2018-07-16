<%--
  Created by IntelliJ IDEA.
  User: CAIKE3
  Date: 7/15/2018
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>商铺审核</title>
</head>
<body>
<h1>商铺审核</h1>
<table border="1" class="table">
    <tr>
        <td>商家姓名</td>
        <td>商家身份证号</td>
        <td>商家身份证图片</td>
        <td>商铺地址</td>
        <td>商铺执照号</td>
        <td>商铺状态</td>
        <td>操作</td>
    </tr>
<c:forEach items="${records}" var="record">

    <tr>
        <td>${record.identity.name}</td>
        <td>${record.identity.idCardNumber}</td>
        <td> <img style="width: 80px; height:80px" src="http://10.222.29.157:8080/merchant/upload/${record.identity.idCardPic}"></td>
        <td>${record.store.address}</td>
        <td>${record.store.license}</td>
        <c:if test="${record.storeFormRecord.status == 0}">
          <td style="color: orange">待审核</td>
            <td>
                <a href="/admin?method=modifyStatus&id=${record.storeFormRecord.id}&status=1">通过</a>
                <a href="/admin?method=modifyStatus&id=${record.storeFormRecord.id}&status=2">不通过</a>
                <a href="/admin?method=modifyStatus&id=${record.storeFormRecord.id}&status=3">驳回</a>
            </td>
        </c:if>
        <c:if test="${record.storeFormRecord.status == 1}">
            <td style="color: green">通过</td>
            <td></td>
        </c:if>
        <c:if test="${record.storeFormRecord.status == 2}">
            <td style="color: red">不通过</td>
            <td></td>
        </c:if>
        <c:if test="${record.storeFormRecord.status == 3}">
            <td style="color: grey">已驳回</td>
            <td></td>
        </c:if>

    </tr>


</c:forEach>
</table>
</body>
</html>
