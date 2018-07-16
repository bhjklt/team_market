<%--
  Created by IntelliJ IDEA.
  User: LIUJU7
  Date: 7/15/2018
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Custom Index</title>
</head>
<body>
<h1>Custom Index</h1>
<hr>
<h2>商家广告图片</h2>
<c:forEach items="${pics}" var="pic">
    <img src="http://10.222.29.157:8080/merchant/upload/${pic}" style="height: 100px;width: 100px;">
</c:forEach>

<hr>
<h2>商家列表</h2>
<hr>
<c:forEach items="${storeDetailInfomations}" var="storeDetailInformation">
    <p>商店名称：${storeDetailInformation.name}</p>
    <p>商店地址：${storeDetailInformation.address}</p>
    <p>营业执照：${storeDetailInformation.license}</p>
    <p>开店时间：${storeDetailInformation.open}</p>
    <p>关店时间：${storeDetailInformation.close}</p>
    <p>配送范围：${storeDetailInformation.deliveryArea}</p>
    <p>商店描述：${storeDetailInformation.description}</p>
    <img src="http://10.222.29.157:8080/merchant/upload/${storeDetailInformation.images}" style="height: 100px;width: 100px;">
    <a href="<%=basePath%>product?method=getList&sid=${storeDetailInformation.sId}">查看所有菜品</a>
    <hr>
</c:forEach>
</body>
</html>
