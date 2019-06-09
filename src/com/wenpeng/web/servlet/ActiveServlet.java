package com.wenpeng.web.servlet;

import com.wenpeng.model.User;
import com.wenpeng.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/active")
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取参数
        String activeCode = request.getParameter("activeCode");
        //调用业务方法
        UserService us= new UserService();
        us.activeUser(activeCode);

    }
}
