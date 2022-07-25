<%@ page import="Model.CustomerManager" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/25/2022
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px solid;
            width: 700px;
            height: 500px;
        }
     table img {
         width: 100px;
         height: 100px;
     }
    </style>
</head>
<body>
<form method="get" action="/DisplayCustomerServlet">
    <table>
        <tr>
            <th colspan="4"><h3>Danh Sách Khách Hàng</h3></th>
        </tr>
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach items="${customers}" var="c">
            <tr>
                <th>${c.getName()}</th>
                <th>${c.getDateOfBirth()}</th>
                <th>${c.getAddress()}</th>
                <th><img src="${c.getImg()}" alt=""></th>
            </tr>
        </c:forEach>

    </table>
    <button>xem danh sách</button>
</form>
</body>
</html>
