<%@ page import="java.util.List" %>
<%@ page import="com.sunshine.bean.Product" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/15 0015
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mybatis与servlet整合</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<% List<Product> lists = (List<Product>) request.getAttribute("lists");%>
<table class="table table-bordered table-hover">
    <tr class="info">
        <th>编号</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>产品名称</th>
        <th>产品标题</th>
        <th>产品价格</th>
        <th>产品数量</th>
        <th>产品厂家</th>
        <th>产品颜色</th>
        <th>产品重量</th>
        <th>产品状态</th>
        <th>操作</th>
    </tr>
    <% for (Product p : lists) {
    %>
    <tr>
        <td><%=p.getId()%>
        </td>
        <td><%=p.getCreateDate()%>
        </td>
        <td><%=p.getModifyDate()%>
        </td>
        <td><%=p.getProductName()%>
        </td>
        <td><%=p.getProductTitle()%>
        </td>
        <td><%=p.getProductPrice()%>
        </td>
        <td><%=p.getProductCount()%>
        </td>
        <td><%=p.getProductType()%>
        </td>
        <td><%=p.getProductColor()%>
        </td>
        <td><%=p.getProductWeight()%>
        </td>
        <td><%=p.getProductStatus()%>
        </td>
        <td>
            <a href="/DeleteById?id=<%=p.getId()%>" onclick="return confirm('是否删除此行？')" class="btn btn-primary">删除</a>
        </td>
    </tr>
    <%
        }%>
</table>
</body>
</html>