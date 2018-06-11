<%--
  Created by IntelliJ IDEA.
  User: wyj
  Date: 2018/6/11
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Software-login</title>
  </head>
  <body>
    <form action="/softwareAllCourse" method="post">
      <label for="studentId">学号:</label>
      <input type="text" name="studentId" id="studentId" />
      <label for="name">姓名:</label>
      <input type="text" name="name" id="name">

      <input type="submit" value="Login">
    </form>

  </body>
</html>
