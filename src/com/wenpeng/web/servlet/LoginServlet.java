package com.wenpeng.web.servlet;

import com.wenpeng.exception.UserException;
import com.wenpeng.model.User;
import com.wenpeng.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用servic
        UserService us = new UserService();
        try
        {
            User user = us.login(username, password);
            //登录成功.返回主页
            request.getSession().setAttribute("user", user);
            //request.getRequestDispatcher("/index.jsp").forward(request, response);
            //重定向到主页.避免重复提交到servlet
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        catch (UserException e)
        {
            //登录失败,返回主页
            e.printStackTrace();
            request.setAttribute("login_msg", e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
