package com.wenpeng.web.servlet;

import com.wenpeng.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/myaccount")
public class MyAccountServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user = (User) request.getSession().getAttribute("user");
        //如果登录了就进入myaccount.jsp
        if(user!=null){
            response.sendRedirect(request.getContextPath()+"/myAccount.jsp");
        }else{
            //如果未登录,就进入登录login.jsp
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }
}
