<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单列表页面</title>
</head>
<body>
<div class="mt-20">
    <table class="table table-border table-bordered table-bg table-hover table-sort">
        <thead>
        <tr class="text-c">
            <th width="40">ID</th>
            <th width="60">订单名称</th>
            <th width="100">订单时间</th>
            <th>订单人数</th>
            <th width="100">订单详情</th>
            <th width="60">支付方式</th>
            <th>订单状态</th>
        </tr>
        </thead>
        <br>
        <br>
        <tbody>
        <c:forEach items="${ordersList}" var="orders">
            <tr class="text-c va-m">
                <td>${orders.id}</td>
                <td>${orders.orderNum}</td>
                <td>${orders.orderTimeStr}</td>
                <td>${orders.peopleCount}</td>
                <td>${orders.orderDesc}</td>
                <td>${orders.payType}</td>
                <td>${orders.orderStatus}</td>
                <td${orders.product.productDesc}></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
