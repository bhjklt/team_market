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
    <title>商铺审核</title>
</head>
<body>
<c:forEach items="${records}" var="record">
    <tr>
        <td>${record.identity.name}</td>
        <td>${record.identity.idCardNumber}</td>
        <td>${record.identity.idCardPic}</td>
        <td>${record.store.address}</td>
        <td>${record.store.license}</td>
        <td>${record.store.status}</td>

    </tr>


</c:forEach>

</body>
</html>
