<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <jsp:include page="meta.jsp"></jsp:include>

</head>
<body>
<div >
    <form action="${pageContext.request.contextPath}/product/saveProduct.do" method="post" >
        <tr class="text-c">
            <th width="60">编号</th>
            <th width="100">产品名称</th>
            <th>出发城市</th>
            <th width="100">出发时间</th>
            <th width="60">产品价格</th>
            <th>产品描述</th>
            <th width="100">状态</th>
        </tr>
        <br>
        <tr>
            <td><input type="text" name="productNum"></td>
            <td><input type="text" name="productName"></td>
            <td><input type="text" name="cityName"></td>
            <td><input type="text" name="departureTime"></td>
            <td><input type="text" name="productPrice"></td>
            <td><input type="text" name=productDesc"></td>
            <td><input type="text" name="productStatus"></td>
        </tr>
        <br>
        <input type="submit" value="提交">
    </form>
</div>

<!--_footer 作为公共模版分离出去-->
<jsp:include page="footer.jsp"></jsp:include>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->

</body>
</html>