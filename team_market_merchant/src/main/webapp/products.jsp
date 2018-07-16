<%--
  Created by IntelliJ IDEA.
  User: LIBU2
  Date: 7/15/2018
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>products</title>
</head>
<body>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>DESCRIPTION</th>
            <th>IMAGES</th>
            <th>QUANTITY</th>
            <th>TODO</th>
        </tr>
        <c:forEach items="${products}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.description}</td>
                <td>${p.images}</td>
                <td>${p.quantity}</td>
                <td><a href="product?method=delete&id=${p.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
