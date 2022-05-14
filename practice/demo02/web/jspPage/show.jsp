<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: 15231
  Date: 2022/5/14
  Time: 15:16
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    tr {
        height: 80px;
    }
</style>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="50%" border="2px" align="center" style="text-align: center; font-size: 20px">
    <tr>
        <td>学号</td>
        <td>姓名</td>
    </tr>
    <c:forEach var="student" items="${list}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
