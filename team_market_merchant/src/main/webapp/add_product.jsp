<%--
  Created by IntelliJ IDEA.
  User: LIBU2
  Date: 7/15/2018
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>

    <form action="product?method=add" method="post" enctype="multipart/form-data">
        名称：<input type="text" name="Product.name">
        介绍：<input type="text" name="Product.description">
        图片：<input type="file" name="Product.images">
        价格：<input type="text" name="Product.price">
        数量：<input type="text" name="Product.quantity">
        <input type="submit" value="添加">
    </form>

</body>
</html>
