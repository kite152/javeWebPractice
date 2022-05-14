<%--
  Created by IntelliJ IDEA.
  User: 15231
  Date: 2022/4/30
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<label>得到的姓名为：<%= request.getParameter("name") %>
</label>
<label>得到的密码为：<%= request.getParameter("psd") %>
</label>
</body>
</html>
