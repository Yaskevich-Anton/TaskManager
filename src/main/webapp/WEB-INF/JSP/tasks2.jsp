<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Сохранение задачи</title>
</head>
<body>
<h1>Сохранение задачи</h1>
<form action="/tasks" method="POST">
    <label for="taskName">Название задачи:</label>
    <input type="text" id="taskName" name="taskName" required><br><br>

    <label for="deadline">Дедлайн:</label>
    <input type="date" id="deadline" name="deadline" required><br><br>

    <label for="status">Статус:</label>
    <select id="status" name="status" required>
        <option value="Новая">Новая</option>
        <option value="В процессе">В процессе</option>
        <option value="Завершена">Завершена</option>
    </select><br><br>

    <input type="submit" value="Сохранить">
</form>

<%-- Отображение созданных задач --%>
<h2>Созданные задачи:</h2>
<%-- Предполагая, что у вас есть список объектов Task, содержащий созданные задачи --%>
<c:forEach var="task" items="${taskList}">
    <p>Название: ${task.taskName}</p>
    <p>Дедлайн: ${task.deadline}</p>
    <p>Статус: ${task.status}</p>
    <hr>
</c:forEach>

<%-- Включение необходимых библиотек JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</body>
</html>