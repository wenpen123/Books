package com.wenpeng.web.servlet;

import com.wenpeng.exception.UserException;
import com.wenpeng.model.User;
import com.wenpeng.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String checkcode_client = request.getParameter("checkcode_client");
        String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
        System.out.println(checkcode_client);
        System.out.println(checkcode_session);
        if (!checkcode_client.equals(checkcode_session))
        {
            //客户端提交的验证码和服务器的不一致
            request.setAttribute("register_err", "验证码不一致");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        User user = new User();

        try
        {
            //封装模型
            BeanUtils.populate(user, request.getParameterMap());
            //给无数据的属性赋值
            user.setActiveCode(UUID.randomUUID().toString());
            user.setRole("普通用户");
            user.setRegistTime(new Date());
            //注册
            UserService us = new UserService();
            us.register(user);
            //注册成功跳转到成功页面
            request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
        }
        catch (UserException e)
        {
            //注册失败跳转页面
            e.printStackTrace();
            request.setAttribute("register_err", e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("参数转模型失败");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println(request.getParameter("username"));
    }
}
