<%@ page import="po.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="po.Selection" %>
<%@ page import="servlet.Tools" %><%--
  Created by IntelliJ IDEA.
  User: wyj
  Date: 2018/6/12
  Time: 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>

<table id="courseTable">
    <tr>
        <th>课程ID</th>
        <th>课程名</th>
        <th>操作</th>
    </tr>
    <% ArrayList<Course> courses = (ArrayList<Course>) session.getAttribute("allCourse");
        ArrayList<Selection> selections = (ArrayList<Selection>) session.getAttribute("myCourse");
        for (Course c: courses) {
            if (Tools.judgeIsIn(selections, c)) {
    %>
    <tr>
        <td><%=c.courseId%></td>
        <td><%=c.courseName%></td>
        <td><a class="selectBtn" href="">退选</a></td>
    </tr>
    <%
    } else {
    %>
    <tr>
        <td><%=c.courseId%></td>
        <td><%=c.courseName%></td>
        <td><a class="selectBtn" href="">选择</a></td>
    </tr>
    <%
            }
        }

    %>
</table>

<script>
    $(".selectBtn").click(function () {
        var id = $(this).parents("tr").children(0).html();

        var data = {
            courseId: id,
        };

        $.ajax({
            type: 'POST',
            url: '/softwareChooseCourse',
            data: data,
            success: function () {
                console.log("555");
            }
        });
    })
</script>

</body>
</html>
