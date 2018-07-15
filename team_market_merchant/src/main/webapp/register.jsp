<%--
  Created by IntelliJ IDEA.
  User: LIUJU7
  Date: 7/14/2018
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <h1>注册</h1>
    <form method="POST" action="user?method=register">
        <input type="text" name="User.usernane">用户名 <br>
        <input type="text" name="User.password">密码 <br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
