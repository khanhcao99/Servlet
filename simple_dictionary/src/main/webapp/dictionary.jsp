<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/22/2022
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%
  Map<String, String> dic  = new HashMap<>();
    dic.put("hello", "Xin chào");
    dic.put("how", "Thế nào");
    dic.put("book", "Quyển vở");
    dic.put("computer", "Máy tính");
    String value = request.getParameter("txtSearch");
    String result = dic.get(value);

  PrintWriter writer = response.getWriter();
    if (result != null){
        writer.println("Word: " + value + "<br>");
        writer.println("Result: " + result);
    }else {
      writer.println("Not found");
    }
%>
</body>
</html>
