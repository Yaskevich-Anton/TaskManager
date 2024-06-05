<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 19.05.2024
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="post">
    <label for="name">Name:
        <input type="text" name="name" id="name"/>
    </label><br></br>
    <label for="birthday">BirthDay:
        <input type="date" name="birthday" id="birthday"/>
    </label><br></br>
    <label for="email">Email:
        <input type="text" name="email" id="email"/>
    </label><br></br>
    <label for="password">Password:
        <input type="password" name="password" id="password"/>
    </label><br></br>
    <select name="role" id = "role">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value=${role}>${role}</option>
        </c:forEach>
    </select><br></br>

    <button type="submit">Send</button>
</form>

</body>
</html>
