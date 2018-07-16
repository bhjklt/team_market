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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Merchant Login</title>
    <!-- import CSS -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
</head>
<body>
<div id="app">
    <el-form action="user?method=login" method="post">

        <div style="width: 420px;">
            <h2>Merchant Login</h2>
            <el-input type="text" name="username" placeholder="username" style="margin-bottom: 10px;"></el-input>
            <el-input type="password" name="password" placeholder="password" style="margin-bottom: 10px;"></el-input>
            <el-input type="submit" value="Login" style="margin-bottom: 10px;"></el-input>
            <a href="register.jsp"><el-button style="width: 100%;">Register</el-button></a>
            <p>${login_error}</p>
        </div>

    </el-form>
</div>
</body>
<!-- import Vue before Element -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<script>
    new Vue({
        el: '#app',
        data: function() {
            return { visible: false }
        }
    })
</script>
</html>
