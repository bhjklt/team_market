<%--
  Created by IntelliJ IDEA.
  User: CHENTH4
  Date: 7/14/2018
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>

<%--
 Author:thomas
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <title>商家系统登陆</title>
</head>
<body>

<form action="user?method=login" method="post">
    <table align="left">
        <tr>
            <td><label class="name">用户名：</label></td>
            <td><input type="text" maxlength="10" name="username"/></td>
        </tr>
        <tr>
            <td><label class="name">密码：</label></td>
            <td><input type="text" maxlength="18" name="password"/></td>
        </tr>
        <tr>
            <td><br/></td>

        </tr>
        <tr>
            <td><input type="submit" value="登陆" /> </td>
            <td><input type="reset" value="重置" /></td>
            <td>
                <a href="register.jsp">
                注册
                </a>
            </td>
        </tr>

    </table>

    <p>${login_error}</p>
</form>
</body>
</html>