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

@WebServlet("/finduserbyid")
public class FindUserByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取参数
        String id = request.getParameter("id");
        //从数据库里面查询
        UserService us = new UserService();
        try
        {
            User user = us.findUserById(id);
            //放在request中
            request.setAttribute("u",user);
            //加到modifuser 显示到页面中
            request.getRequestDispatcher("/modifyuserinfo.jsp").forward(request,response);
        }
        catch (UserException e)
        {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }


    }
}
