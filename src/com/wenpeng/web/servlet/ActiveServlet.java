package com.wenpeng.web.servlet;

import com.wenpeng.exception.UserException;
import com.wenpeng.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/active")
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //获取参数
        String activeCode = request.getParameter("activeCode");
        //调用业务方法
        UserService us = new UserService();
        try
        {
            us.activeUser(activeCode);
            response.getWriter().write("激活成功");
        }
        catch (UserException | IOException e)
        {
            e.printStackTrace();
            response.getWriter().write("激活失败");
        }

    }
}
