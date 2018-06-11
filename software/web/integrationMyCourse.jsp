<%@ page import="po.Selection" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: wyj
  Date: 2018/6/12
  Time: 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <th>课程ID</th>
        <th>成绩</th>
    </tr>
    <%
        ArrayList<Selection> courses = (ArrayList<Selection>) session.getAttribute("myCourse");
        for (Selection c: courses) {
    %>
    <tr>
        <td><%=c.courseId%></td>
        <td><%=c.grade%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
