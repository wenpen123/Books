package com.wenpeng.web.servlet;

import com.wenpeng.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/settleAccount")
public class SettleAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user = (User) request.getSession().getAttribute("user");
        //判断是否登录,如果登录跳转到订单页面,否则登录
        if(user!=null){
            response.sendRedirect(request.getContextPath()+"/order.jsp");

        }else {
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }

    }
}
