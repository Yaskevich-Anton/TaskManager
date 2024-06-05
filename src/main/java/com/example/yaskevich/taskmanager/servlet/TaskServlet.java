package com.example.yaskevich.taskmanager.servlet;

import com.example.yaskevich.taskmanager.dao.TaskDao;
import com.example.yaskevich.taskmanager.dto.CreateTaskDto;
import com.example.yaskevich.taskmanager.entity.Task;
import com.example.yaskevich.taskmanager.service.TaskService;
import com.example.yaskevich.taskmanager.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/createTask")
public class TaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Task> tasks = TaskDao.INSTANCE.findAll();
        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher(JspHelper.getPath("tasks"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String taskIdParam = req.getParameter("taskId");
        if (taskIdParam != null) {
            int taskId = Integer.parseInt(taskIdParam);


            boolean isDeleted = TaskDao.INSTANCE.delete(taskId);

            if (isDeleted) {

                resp.sendRedirect(req.getContextPath() + "/createTask");
                return;
            } else {

                resp.sendRedirect(req.getContextPath() + "/tasks.jsp?error=delete_failed");
                return;
            }
        }

        var taskDto = CreateTaskDto.builder()
                .taskName(req.getParameter("taskName"))
                .deadLine(req.getParameter("deadline"))
                .status(req.getParameter("status"))
                .build();
        TaskService.save(taskDto);

        resp.sendRedirect(req.getContextPath() + "/createTask");
    }
}