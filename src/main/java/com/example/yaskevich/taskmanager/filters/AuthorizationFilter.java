package com.example.yaskevich.taskmanager.filters;


import com.example.yaskevich.taskmanager.dto.UserDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

import static com.example.yaskevich.taskmanager.util.UrlPath.*;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    public static final Set<String> PUBLIC_PATH = Set.of(LOGIN, REGISTRATION);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var uri = ((HttpServletRequest) servletRequest).getRequestURI();
       if(isPublicPath(uri) || isUserLoggedIn(servletRequest)){
           filterChain.doFilter(servletRequest,servletResponse);
       } else {
           var prefPage = ((HttpServletRequest) servletRequest).getHeader("referer");
           ((HttpServletResponse) servletResponse).sendRedirect(prefPage != null ? prefPage : LOGIN);
       }

    }

    private boolean isUserLoggedIn(ServletRequest servletRequest) {
        var user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return user != null;
    }

    private boolean isPublicPath(String uri) {
        return PUBLIC_PATH.stream().anyMatch(uri::startsWith);
    }


}
