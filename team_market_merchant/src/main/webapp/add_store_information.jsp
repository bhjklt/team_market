<%--
  Created by IntelliJ IDEA.
  User: LIBU2
  Date: 7/16/2018
  Time: 8:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Store Information</title>
</head>
<body>

    <c:if test="${storeInformation != null}">
        <form action="store_information?method=update" method="post" enctype="multipart/form-data">

            ID：<input type="text" name="StoreInformation.id" value="${storeInformation.id}"><br>
            SID：<input type="text" name="StoreInformation.sId" value="${storeInformation.SId}"><br>
            开店时间：<input type="text" name="StoreInformation.open" value="${storeInformation.open}"><br>
            闭店时间：<input type="text" name="StoreInformation.close" value="${storeInformation.close}"><br>
            店铺简介：<input type="text" name="StoreInformation.description" value="${storeInformation.description}"><br>
            配送范围：<input type="text" name="StoreInformation.deliveryArea" value="${storeInformation.deliveryArea}"><br>
            <img src="http://10.222.29.157:8080/merchant/upload/${storeInformation.images}" style="width: 200px; height: 200px;">
            店铺照片：<input type="file" name="StoreInformation.images" value="${storeInformation.images}"><br>
            <input type="submit" value="更新店铺信息">

        </form>
    </c:if>

    <c:if test="${storeInformation == null}">
        <form action="store_information?method=add" method="post" enctype="multipart/form-data">

            开店时间：<input type="text" name="StoreInformation.open"><br>
            闭店时间：<input type="text" name="StoreInformation.close"><br>
            店铺简介：<input type="text" name="StoreInformation.description"><br>
            配送范围：<input type="text" name="StoreInformation.deliveryArea"><br>
            店铺照片：<input type="file" name="StoreInformation.images"><br>
            <input type="submit" value="添加店铺信息">

        </form>
    </c:if>


</body>
</html>
