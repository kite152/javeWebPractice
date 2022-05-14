<%--
  Created by IntelliJ IDEA.
  User: 15231
  Date: 2022/5/7
  Time: 16:06
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
<form action="../dispatch" method="post">
    <input name="dpt" value="1" style="display: none"><br>
    <label>
        学号:<input type="number" name="id">
    </label><br>
    <label>
        姓名:<input type="text" name="name">
    </label><br>
    <input type="submit" value="增加">
</form>
</body>
</html>
