<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/26/2022
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Delete customer</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>

<h1>Delete customer</h1>
<p>
    <button><a href="/customers">Back to customer list</a></button>

</p>
<form method="post" action="">
    <h3>Are you sure?</h3>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message"> ${requestScope["message"]}</span>
        </c:if>
    </p>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Id: </td>
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
            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td><button><a href="/customers">Back to customer list</a></button>  </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
