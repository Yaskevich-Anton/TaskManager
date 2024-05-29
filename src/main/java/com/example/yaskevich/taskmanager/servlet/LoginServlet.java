package com.example.yaskevich.taskmanager.servlet;

import com.example.yaskevich.taskmanager.dto.UserDto;
import com.example.yaskevich.taskmanager.service.UserService;
import com.example.yaskevich.taskmanager.util.JspHelper;
import com.example.yaskevich.taskmanager.util.UrlPath;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(UrlPath.LOGIN)
public class LoginServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("login"))
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.login(req.getParameter("email"),req.getParameter("password"))
                .ifPresentOrElse(
                      user -> onLoginSuccess(user,req,resp),
                        () -> onLoginFail(req,resp)
                );
    }

    @SneakyThrows
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        resp.sendRedirect("/login?error&email=" + req.getParameter("email"));
    }

    @SneakyThrows
    private void onLoginSuccess(UserDto user,HttpServletRequest req, HttpServletResponse resp){
        req.getSession().setAttribute("user",user);
        resp.sendRedirect("/tasks");
    }
}
