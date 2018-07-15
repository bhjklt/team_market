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
    <form action="/merc/user?method=register" method="post">
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
                <td><input type="submit" value="确认" /> </td>
                <td><input type="reset" value="重置" /></td>
            </tr>

        </table>

        <p>${register_error}</p>
    </form>
</body>
</html>
