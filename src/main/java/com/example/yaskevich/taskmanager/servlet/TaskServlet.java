package com.example.yaskevich.taskmanager.servlet;

import com.example.yaskevich.taskmanager.service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {
    private final TaskService taskService = TaskService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html");
         resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
         var printWriter = resp.getWriter();
         printWriter.write("<h1>Список задач<h1>");
         printWriter.write("ul");
         taskService.findAll().forEach(taskDto -> {
             printWriter.write("""
                     <li>
                     <a href="/description?id=%d"> %s</a>
                     </li>
                     """.formatted(taskDto.getId(),taskDto.getDescription()));
         });
        printWriter.write("/ul");

    }
}
