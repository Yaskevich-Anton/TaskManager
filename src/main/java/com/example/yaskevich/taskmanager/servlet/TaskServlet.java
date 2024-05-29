package com.example.yaskevich.taskmanager.servlet;

import com.example.yaskevich.taskmanager.service.TaskService;
import com.example.yaskevich.taskmanager.util.JspHelper;

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

        var taskID = Long.valueOf(req.getParameter("taskID"));
        req.setAttribute("tasks",taskService.findById(taskID));
        req.getRequestDispatcher(JspHelper.getPath("tasks")).forward(req,resp);

    }
}
