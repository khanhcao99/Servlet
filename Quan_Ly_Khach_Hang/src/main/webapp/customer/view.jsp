<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/26/2022
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View customer</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>

<h1>Customer details</h1>
<p>
    <button> <a href="/customers">Back to customer list</a></button>

</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["customer"].getId()}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${requestScope["customer"].getName()}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${requestScope["customer"].getEmail()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope["customer"].getAddress()}</td>
    </tr>
</table>
</body>
</html>
