<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2020/4/27
  Time: 0:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/product/findAll.do">查询所有的商品信息</a> <br>
页面上下文：${pageContext}    <br>
上下文路径：${pageContext.request.contextPath} <br>
<br>

<a href="${pageContext.request.contextPath}/product/toSavePage.do">添加商品信息</a> <br>


<a href="${pageContext.request.contextPath}/user/findAll.do">用户列表</a>
<br>

<a href="${pageContext.request.contextPath}/user/toSavePage.do">保存用户</a>
<br>

</body>
</html>
