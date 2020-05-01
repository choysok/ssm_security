<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2020/4/27
  Time: 0:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
查询所有产品的结果：
<table>
<c:forEach items="${productLIst}" var="product">
     <tr>
         <td><input name="ids" type="checkbox"></td>
         <td>${product.id}</td>
         <td>${product.productNum}</td>
         <td>${product.productName}</td>
         <td>${product.cityName}</td>
         <td>${product.departureTime}</td>
         <td>${product.departureTimeStr}</td>
         <td class="text-center">${product.productPrice}</td>
         <td>${product.productDesc}</td>
         <td>${product.productStatus}</td>
         <td class="text-center">${product.productStatusStr}</td>
         <td class="text-center">
             <button type="button" class="">订单</button>
             <button type="button" class="">详情</button>
             <button type="button" class="">编辑</button>
         </td>
     </tr>
</c:forEach>
</table>


</body>
</html>
