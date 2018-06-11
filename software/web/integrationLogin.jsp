<%--
  Created by IntelliJ IDEA.
  User: wyj
  Date: 2018/6/12
  Time: 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/integrationLogin" method="post">
    <label for="studentId">学号:</label>
    <input type="text" name="studentId" id="studentId" />
    <label for="name">姓名:</label>
    <input type="text" name="name" id="name">
    <label for="department">院系:</label>
    <input type="text" name="department" id="department">

    <input type="submit" value="Login">
</form>

</body>
</html>
