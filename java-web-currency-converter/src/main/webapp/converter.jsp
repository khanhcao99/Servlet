<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/22/2022
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
    <%
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));
        float vnd = rate * usd;
    %>
<h1>Rate: <%= rate %></h1><br>
<h1>Usd: <%= usd %></h1><br>
<h1>Vnd: <%= vnd %></h1>
</body>
</html>
