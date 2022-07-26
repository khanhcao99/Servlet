<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/25/2022
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
    <h1>Customer</h1>
    <p>
        <a href="/customers?action=create">Create new customer</a>
    </p>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Email</td>
            <td>Address</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items='${requestScope["customers"]}' var="c" >
            <tr>
                <td><a href="/customers?action=view&id=${c.getId()}">${c.getName()}</a></td>
                <td>${c.getEmail()}</td>
                <td>${c.getAddress()}</td>
                <td><a href="/customers?action=edit&id=${c.getId()}">edit</a></td>
                <td><a href="/customers?action=delete&id=${c.getId()}">delete</a></td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
