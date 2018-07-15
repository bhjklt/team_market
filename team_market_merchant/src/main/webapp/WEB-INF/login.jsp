<%--
  Created by IntelliJ IDEA.
  User: LIUJU7
  Date: 7/14/2018
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h1>登录</h1>
    <form method="POST" action="user?method=login">
        <input type="text" name="User.usernane">用户名 <br>
        <input type="text" name="User.password">密码 <br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
