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
    <title>营业资格申请</title>
</head>
<body>

<form action="storeform?mehod=apply" method="post" enctype="multipart/form-data">
    <table align="left">
        <tr>
            <td><label class="name">真实姓名：</label></td>
            <td><input type="text" maxlength="10" name="Identity.name"/></td>
        </tr>
        <tr>
            <td><label class="name">身份证号码：</label></td>
            <td><input type="text" maxlength="18" name="Identity.idCardNumber"/></td>
        </tr>
        <tr>
            <td><label>身份证照片：</label></td>
            <td><input type="file" name="idCardPic"/></td>
        </tr>
        <tr>
            <td><label class="name">店名：</label></td>
            <td><input type="text" maxlength="15" name="Store.name"/></td>
        </tr>
        <tr>
            <td><label class="name">店地址：</label></td>
            <td><input type="text" maxlength="30" name="Store.address"/></td>
        </tr>
        <tr>
            <td><label class="name">营业执照号：</label></td>
            <td><input type="text" maxlength="20" name="Store.license"/></td>
        </tr>
        <tr>
            <td><br/></td>

        </tr>
        <tr>
            <td><input type="submit" value="提交" /> </td>
            <td><input type="reset" value="重置" /></td>
        </tr>
        <tr>
            <td>${error}</td>
        </tr>
    </table>
</form>
</body>
</html>