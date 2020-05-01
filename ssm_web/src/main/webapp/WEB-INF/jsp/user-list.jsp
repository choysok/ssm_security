
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="meta.jsp"></jsp:include>
</head>
<body>

<div class="mt-20">
    <table>
        <thead>
        <tr class="">
            <th width="40"><input name="" type="checkbox" value=""></th>
            <th width="40">ID</th>
            <th width="60">用户名</th>
            <th width="100">密码</th>
            <th>手机号</th>
            <th width="100">邮件</th>
            <th width="100">状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user">
            <tr class="text-c va-m">
                <td><input name="ids" type="checkbox"></td>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.phoneNum}</td>
                <td>${user.email}</td>
                <td>${user.status}</td>
                <td>${user.statusStr}</td>
                <td class="text-center">
                    <button type="button" class="">添加</button>
                    <button type="button" class="">详情</button>
                    <button type="button" class="">编辑</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
