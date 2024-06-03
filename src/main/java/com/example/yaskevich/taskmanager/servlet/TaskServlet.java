package com.example.yaskevich.taskmanager.servlet;

import com.example.yaskevich.taskmanager.dto.CreateTaskDto;
import com.example.yaskevich.taskmanager.dto.TaskDto;
import com.example.yaskevich.taskmanager.service.TaskService;
import com.example.yaskevich.taskmanager.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {
    private final TaskService taskService = TaskService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var taskIDString = req.getParameter("taskID");

        if (taskIDString != null && !taskIDString.isEmpty()) {
            try {
                Long taskID = Long.parseLong(taskIDString);
                Optional<TaskDto> taskDtoOptional = taskService.findById(taskID);
                if (taskDtoOptional.isPresent()) {
                    TaskDto taskDto = taskDtoOptional.get();
                    req.getRequestDispatcher(JspHelper.getPath("tasks")).forward(req,resp);
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    resp.getWriter().println("AAAA.");
                }
            } catch (NumberFormatException e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().println("BBBB");

            }
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().println("CCCC.");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var taskDto = CreateTaskDto.builder()
                .taskName(req.getParameter("name"))
                .status(req.getParameter("status"))
                .deadLine(req.getParameter("deadline"))
                .build();

    }
}
