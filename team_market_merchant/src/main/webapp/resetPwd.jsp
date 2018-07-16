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
    <title>密码修改</title>
</head>
<body>

<form action="storeform?method=apply" method="post" enctype="multipart/form-data">
    <table align="left">
        <tr>
            <td><label class="name">原密码：</label></td>
            <td><input type="text" maxlength="10" name="Identity.name"/></td>
        </tr>
        <tr>
            <td><label class="name">新密码：</label></td>
            <td><input type="text" maxlength="18" name="Identity.idCardNumber"/></td>
        </tr>
        <tr>
            <td><label class="name">确认新密码：</label></td>
            <td><input type="text" maxlength="18" name="Identity.idCardNumber"/></td>
        </tr>
        <tr>
            <td><br/></td>

        </tr>
        <tr>
            <td><input type="submit" value="提交" /> </td>
            <td><input type="reset" value="重置" /></td>
        </tr>
    </table>
    <p>${error}<p>
</form>
</body>
</html>