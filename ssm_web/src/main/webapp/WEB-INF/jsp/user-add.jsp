<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="meta.jsp"></jsp:include>

</head>
<body>
<div >
    <form action="${pageContext.request.contextPath}/user/save.do" method="post" >
            <th width="60">email</th>
            <th width="100">username</th>

            <th width="100">password</th>
            <th width="60">phoneNum</th>
            <th width="100">状态</th>
        <br>
            <td><label>
                <input type="text" name="email">
            </label></td>

            <td><label>
                <input type="text" name="username">
            </label></td>
            <td><label>
                <input type="text" name="password">
            </label></td>

            <td><label>
                <input type="text" name="phoneNum">
            </label></td>
            <td><label>
                <input type="text" name=status">
            </label></td>
        <br>
        <input type="submit" value="提交">
    </form>
</div>


</body>
</html>
