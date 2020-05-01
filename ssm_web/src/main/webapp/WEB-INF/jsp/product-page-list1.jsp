<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <jsp:include page="meta.jsp"></jsp:include>
    <title>产品列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script>
       function changePageSize() {
           var pageS = $(changePageSize).val();
           location.href = "${pageContext.request.contextPath}/product/testPage.do?page=1&size="+pageS;
       }

    </script>
</head>
<body class="pos-r">
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="left-side.jsp"></jsp:include>
<div class="pos-a" style="width:200px;left:0;top:0; bottom:0; height:100%; border-right:1px solid #e5e5e5; background-color:#f5f5f5; overflow:auto;">
    <ul id="treeDemo" class="ztree"></ul>
</div>
<div style="margin-left:200px;">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 产品管理 <span class="c-gray en">&gt;</span> 产品列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="${pageContext.request.contextPath}/javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="page-container">
        <div class="text-c"> 日期范围：
            <input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" class="input-text Wdate" style="width:120px;">
            <input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" class="input-text Wdate" style="width:120px;">
            <input type="text" name="" id="" placeholder=" 产品名称" style="width:250px" class="input-text">
            <button class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜产品</button>
        </div>
        <div class="cl pd-5 bg-1 bk-gray mt-20">
            <span class="l">
                <a href="${pageContext.request.contextPath}/javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
                <a class="btn btn-primary radius" href="${pageContext.request.contextPath}/product/toProdectaddPage.do" ><i class="Hui-iconfont">&#xe600;</i> 添加产品</a>
            </span> <span class="r">共有数据：<strong>54</strong> 条</span>
        </div>

        <div class="mt-20">
            <table class="table table-border table-bordered table-bg table-hover table-sort">
                <thead>
                <tr class="text-c">
                    <th width="40"><input name="" type="checkbox" value=""></th>
                    <th width="40">ID</th>
                    <th width="60">编号</th>
                    <th width="100">产品名称</th>
                    <th>出发城市</th>
                    <th width="100">出发时间</th>
                    <th width="60">产品价格</th>
                    <th>产品描述</th>
                    <th width="100">状态</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfo.list}" var="product">
                    <tr class="text-c va-m">
                        <td><input name="ids" type="checkbox"></td>
                        <td>${product.id}</td>
                        <td>${product.productNum}</td>
                        <td>${product.productName}</td>
                        <td>${product.cityName}</td>
                        <td>${product.departureTimeStr}</td>
                        <td >${product.productPrice}</td>
                        <td>${product.productDesc}</td>
                        <td>
                            <c:choose>
                            <c:when test="${product.productStatus} == 1">开启</c:when>
                            <c:otherwise>关闭</c:otherwise>
                            </c:choose>
                        </td>
                        <td class="text-center">
                            <button type="button" class="">订单</button>
                            <button type="button" class="">详情</button>
                            <button type="button" class="">编辑</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="dropdown">
            每页
            <div class="dropdown">
                <button onchange="changePageSize()" class="btn btn-light dropdown-toggle" type="button" id="changePageSize" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown
                </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="#">1</a>
                <a class="dropdown-item" href="#">2</a>
                <a class="dropdown-item" href="#">3</a>
            </div>
            条
        </div>



        <div class="btn-group" role="group" aria-label="Basic example">
            <a href="${pageContext.request.contextPath}/product/testPage.do?page=1&size=${pageInfo.pageSize}" aria-label="首页"><button type="button" class="btn btn-primary">首页</button></a>
            <a href="${pageContext.request.contextPath}/product/testPage.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}" aria-label="Previous"><button type="button" class="btn btn-primary">上一页</button></a>
           <c:forEach begin="1" end="${pageInfo.pages}" var="pageIndex">
               <a href="${pageContext.request.contextPath}/product/testPage.do?page=${pageIndex}&size=${pageInfo.pageSize}" aria-label="${pageIndex}"><button type="button" class="btn btn-primary">${pageIndex}</button></a>
           </c:forEach>
            <a href="${pageContext.request.contextPath}/product/testPage.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}" aria-label="Next"><button type="button" class="btn btn-primary">下一页</button></a>
            <a href="${pageContext.request.contextPath}/product/testPage.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}" aria-label="尾页"><button type="button" class="btn btn-primary">尾页</button></a>
        </div>

<%--        <div class="box-tools pull-right">--%>
<%--            <ul class="pagination">--%>
<%--                <li>--%>
<%--                    <a href="${pageContext.request.contextPath}/product/testPage.do?page=1&size=${pageInfo.pageSize}" aria-label="Previous">首页</a>--%>
<%--                </li>--%>
<%--                <li><a>上一页</a></li>--%>
<%--                <li><a>1</a></li>--%>
<%--                <li><a>2</a></li>--%>
<%--                <li><a>3</a></li>--%>
<%--                <li><a>4</a></li>--%>
<%--                <li><a>5</a></li>--%>
<%--                <li><a>下一页</a></li>--%>
<%--                <li>--%>
<%--                    <a href="${pageContext.request.contextPath}/product/testPage.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}" aria-label="Next">尾页</a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>


    </div>
</div>

<!--_footer 作为公共模版分离出去-->
<jsp:include page="footer.jsp"></jsp:include>
 <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/product/product-list.js"></script>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>