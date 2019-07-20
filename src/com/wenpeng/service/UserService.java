package com.wenpeng.service;

import com.wenpeng.dao.UserDao;
import com.wenpeng.exception.UserException;
import com.wenpeng.model.User;
import com.wenpeng.utils.SendJMail;

import java.sql.SQLException;

public class UserService {
    UserDao ud = new UserDao();

    public void register(User user) throws Exception
    {
        try
        {
            ud.addUser(user);
            String link = "http://localhost:8099/BookStor_war_exploded/active?activeCode=" + user.getActiveCode();

            String html = "欢迎你注册网上书城帐号,请点击以下链接激活:\n" + link + "";
            System.out.println(html);
            SendJMail.sendEmil(user.getEmail(), html);

        }
        catch (Exception e)
        {
            throw new UserException("用户注册失败,用户名重复");
        }
    }

    public void activeUser(String activeCode) throws UserException
    {
        //1:先查询激活码的用户是否存在
        try
        {
            User user = ud.findUserByActiveCode(activeCode);
            if (user == null)
            {
                throw new UserException("非法用户,激活失败");
            }
            if (user != null && user.getState() == 1)
            {
                throw new UserException("该用户已激活!");
            }
            //以上两种情况都不满足,就激活用户
            ud.updateState(activeCode);
        }
        catch (SQLException e)
        {
            throw new UserException("激活失败");
        }
    }

    public User login(String username, String password) throws UserException
    {
        UserDao ud = new UserDao();
        try
        {
            User user = ud.findUserByUsernameAndPassword(username, password);
            if (user == null)
            {
                throw new UserException("用户名或密码不正确");
            }
            if (user.getState() == 0)
            {
                throw new UserException("用户未激活,请登录邮箱(" + user.getEmail() + ")激活");
            }
            return user;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new UserException("登录失败");
        }

    }

    public User findUserById(String id) throws UserException
    {
        UserDao ud = new UserDao();
        try
        {
            User user = ud.findUserById(id);
            if (user == null)
            {
                throw new UserException("用户不存在");
            }

            return user;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new UserException("未知错误");
        }

    }

}
