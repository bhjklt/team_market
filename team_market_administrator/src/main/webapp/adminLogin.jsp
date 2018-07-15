<%--
  Created by IntelliJ IDEA.
  User: CAIKE3
  Date: 7/14/2018
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body>
<form action="admin?method=login" method="post">
    用户名:<input type="text" name="User.username"/>
    密码:<input type="password" name="User.password"/>
    <input type="submit" value="登录">
</form>

</body>
</html>
