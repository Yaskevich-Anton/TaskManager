<%@ page import="com.example.yaskevich.taskmanager.service.TaskService" %>
<%@ page import="com.example.yaskevich.taskmanager.dto.TaskDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 10.05.2024
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Список задач:</h1>
<ul>
<c: forEach var="tasks" items="${requestScope.tasks}">
    <li>
        <a href="${pageContext.request.contextPath}/tasks?taskId=${task.id}"></a>
    </li>

</c:>
</ul>
</body>
</html>
