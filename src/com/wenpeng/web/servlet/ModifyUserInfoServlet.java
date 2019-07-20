package com.wenpeng.web.servlet;

import com.wenpeng.model.User;
import com.wenpeng.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/modifyuser")
public class ModifyUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取表单的参数
        User user = new User();
        try
        {
            BeanUtils.populate(user,request.getParameterMap());
            UserService us = new UserService();
            us.modifyUserInfo(user);
            //修改成功跳转
            response.sendRedirect(request.getContextPath()+"/modifyUserInfoSuccess.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
