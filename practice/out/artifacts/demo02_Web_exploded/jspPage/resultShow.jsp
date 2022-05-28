<%--
  Created by IntelliJ IDEA.
  User: 15231
  Date: 2022/5/7
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    * {
        font-size: 30px;
    }
</style>
<body>
<%
    String a = (String) request.getAttribute("result");
%>
<h1>
    <%= a%>
</h1>
</body>
</html>
