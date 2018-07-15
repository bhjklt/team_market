<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>后台管理主页</title>
</head>
<body>
<c:if test="${not empty admin}">
    欢迎，${admin.username}登录后台管理, <a href="/adminLogin?method=logout">登出</a>
    <a href="/admin?method=storeRecords">开店申请审核管理</a>
    <a href="#">商家信息管理</a>
    <a href="#">商家自荐审核</a>
</c:if>
</body>
</html>
