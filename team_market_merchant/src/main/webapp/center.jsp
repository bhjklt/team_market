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
    <title>Merchant Dashboard</title>
    <!-- import CSS -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
</head>
<body>
<div id="app">

    <h2>Merchant Dashboard</h2>

    <el-menu mode="horizontal" :default-active="activeIndex">
        <el-menu-item index="1">Dashboard Home</el-menu-item>
        <c:if test="${storeForm.storeFormRecord.status == 1}">
            <el-menu-item index="2"><a href="product?method=all" target="_blank">Order Management</a></el-menu-item>
        </c:if>
        <el-menu-item index="3">My Account</el-menu-item>
        <el-menu-item index="4"><a href="user?method=logout">Logout</a></el-menu-item>
    </el-menu>

    <!--申请开店-->
    <c:if test="${createStorePermission}">
        <div style="margin: 50px;">
            <p>No Store Found, Create One?</p>
            <a href="applicant.jsp"><el-button type="primary">Create Store</el-button></a>
        </div>
    </c:if>

    <c:if test="${storeForm.storeFormRecord.status == 2}">
        <h2>身份已进入黑名单</h2>
    </c:if>

    <c:if test="${storeForm.storeFormRecord.status != 2}">
        <c:if test="${storeForm.storeFormRecord.status == 3}">
            <h2>Your request has been reject, please modify your information!</h2>
        </c:if>
        <!--店铺信息-->
        <el-main>
            <c:if test="${!createStorePermission}">
                <h3>Store Information：</h3>
                <br>
                <el-form action="storeform?method=apply" size="small" label-width="150px" method="post" enctype="multipart/form-data" >
                    <el-form-item label="FORM ID">
                        <el-input value="${storeForm.storeFormRecord.id}" :disabled="true"></el-input>
                    </el-form-item>

                    <el-form-item label="STORE ID">
                        <el-input value="${storeForm.store.id}" :disabled="true"></el-input>
                    </el-form-item>

                    <el-form-item label="店铺名称">
                        <c:if test="${storeForm.storeFormRecord.status == 3}">
                            <el-input value="${storeForm.store.name}" name="Store.name"></el-input>
                        </c:if>
                        <c:if test="${storeForm.storeFormRecord.status != 3}">
                            <el-input value="${storeForm.store.name}" :disabled="true"></el-input>
                        </c:if>
                    </el-form-item>

                    <el-form-item label="店铺地址">
                        <c:if test="${storeForm.storeFormRecord.status == 3}">
                            <el-input value="${storeForm.store.address}" name="Store.address"></el-input>
                        </c:if>
                        <c:if test="${storeForm.storeFormRecord.status != 3}">
                            <el-input value="${storeForm.store.address}" :disabled="true"></el-input>
                        </c:if>
                    </el-form-item>

                    <el-form-item label="店铺许可证号">
                        <c:if test="${storeForm.storeFormRecord.status == 3}">
                            <el-input value="${storeForm.store.license}" name="Store.license"></el-input>
                        </c:if>
                        <c:if test="${storeForm.storeFormRecord.status != 3}">
                            <el-input value="${storeForm.store.license}" :disabled="true"></el-input>
                        </c:if>
                    </el-form-item>

                    <el-form-item label="经营者姓名">
                        <c:if test="${storeForm.storeFormRecord.status == 3}">
                            <el-input value="${storeForm.identity.name}" name="Identity.name"></el-input>
                        </c:if>
                        <c:if test="${storeForm.storeFormRecord.status != 3}">
                            <el-input value="${storeForm.identity.name}" :disabled="true"></el-input>
                        </c:if>
                    </el-form-item>

                    <el-form-item label="经营者证件号">
                        <c:if test="${storeForm.storeFormRecord.status == 3}">
                            <el-input value="${storeForm.identity.idCardNumber}" name="Store.license"></el-input>
                        </c:if>
                        <c:if test="${storeForm.storeFormRecord.status != 3}">
                            <el-input value="${storeForm.identity.idCardNumber}" :disabled="true"></el-input>
                        </c:if>
                    </el-form-item>

                    <el-form-item label="经营者证件照片">
                        <c:if test="${storeForm.storeFormRecord.status == 3}">
                            <img src="upload/${storeForm.identity.idCardPic}" alt="">
                            <el-input value="${storeForm.identity.idCardPic}" :disabled="true" name="Identity.idCardPic"></el-input>
                            <input type="file" name="idCardPic"/>
                        </c:if>
                        <c:if test="${storeForm.storeFormRecord.status != 3}">
                            <el-input value="${storeForm.identity.idCardPic}" :disabled="true"></el-input>
                        </c:if>
                    </el-form-item>

                    <el-form-item label="申请时间">
                        <el-input value="${storeForm.submitTime}" :disabled="true"></el-input>
                    </el-form-item>

                    <el-form-item label="审核状态">
                        <c:if test="${storeForm.storeFormRecord.status == 0}">
                            <el-input value="待审核" :disabled="true"></el-input>
                        </c:if>
                        <c:if test="${storeForm.storeFormRecord.status == 1}">
                            <el-input value="通过" :disabled="true"></el-input>
                        </c:if>
                        <c:if test="${storeForm.storeFormRecord.status == 2}">
                            <el-input value="未通过" :disabled="true"></el-input>
                        </c:if>
                        <c:if test="${storeForm.storeFormRecord.status == 3}">
                            <el-input value="驳回" :disabled="true"></el-input>
                        </c:if>
                    </el-form-item>

                    <el-form-item label="审核时间">
                        <el-input value="${storeForm.storeFormRecord.consumeTime}" :disabled="true"></el-input>
                    </el-form-item>

                    <c:if test="${storeForm.storeFormRecord.status == 3}">
                        <el-input type="submit" value="提交修改"></el-input>
                    </c:if>

                </el-form>

                <c:if test="${storeForm.storeFormRecord.status == 1}">
                    <a href="store_information?method=index"><el-button type="primary">管理店铺信息</el-button></a>
                </c:if>

                <c:if test="${storeForm.storeFormRecord.status == 1}">
                    <a href="add_product.jsp"><el-button type="primary">添加菜品</el-button></a>
                </c:if>

                <c:if test="${storeForm.storeFormRecord.status == 1}">
                    <a href="ad_request.jsp"><el-button type="primary">申请广告</el-button></a>
                </c:if>

            </c:if>
        </el-main>
    </c:if>



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
            return { activeIndex: '1' }
        }
    })
</script>
</html>
