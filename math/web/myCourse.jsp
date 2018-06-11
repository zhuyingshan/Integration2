<%@ page import="java.util.ArrayList" %>
<%@ page import="po.Course" %>
<%@ page import="po.Selection" %><%--
  Created by IntelliJ IDEA.
  User: wyj
  Date: 2018/6/10
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="courseList.jsp">全部课程</a>
<br>
<br>

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
