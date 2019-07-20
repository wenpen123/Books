package com.wenpeng.dao;

import com.wenpeng.model.User;
import com.wenpeng.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //添加用户
    public void addUser(User user) throws Exception
    {
        //获取连接
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //创建查询语句
        String sql = "insert into user";
        sql += " (username,PASSWORD,gender,email,telephone,introduce,activeCode,state,role,registTime)";
        sql += " values(?,?,?,?,?,?,?,?,?,?)";
        List<Object> list = new ArrayList<Object>();
        list.add(user.getUsername());
        list.add(user.getPassword());
        list.add(user.getGender());
        list.add(user.getEmail());
        list.add(user.getTelephone());
        list.add(user.getIntroduce());
        list.add(user.getActiveCode());
        list.add(user.getState());
        list.add(user.getRole());
        list.add(user.getRegistTime());
        //执行查询
        qr.update(sql, list.toArray());

    }

    //通过激活码查找用户
    public User findUserByActiveCode(String activeCode) throws SQLException
    {
        //获取连接
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //创建查询语句
        String sql = "select * from user where activeCode=?";
        return qr.query(sql, new BeanHandler<User>(User.class), activeCode);

    }

    //通过激活码更新用户状态
    public void updateState(String activeCode) throws SQLException
    {
        //获取连接
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //创建查询语句
        String sql = "update user set state= 1 where activeCode = ?";
        //执行查询
        qr.update(sql, activeCode);

    }

    public User findUserByUsernameAndPassword(String username, String password) throws SQLException
    {
        //获取连接
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //创建查询语句
        String sql = "select * from user where username= ? and PASSWORD = ?";
        //执行查询
        return qr.query(sql, new BeanHandler<User>(User.class), username, password);
    }
    public User findUserById(String id) throws SQLException
    {
        //获取连接
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //创建查询语句
        String sql = "select * from user where id= ?";
        //执行查询
        return qr.query(sql, new BeanHandler<User>(User.class), id);
    }

}
