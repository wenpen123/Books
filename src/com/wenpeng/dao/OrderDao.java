package com.wenpeng.dao;

import com.wenpeng.model.Order;
import com.wenpeng.utils.C3P0Utils;
import com.wenpeng.utils.ManagerThreadLocal;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public void add(Order order) throws SQLException
    {
        String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
        List<Object> parmes = new ArrayList<Object>();
        parmes.add(order.getId());
        parmes.add(order.getMoney());
        parmes.add(order.getReceiverAddress());
        parmes.add(order.getReceiverName());
        parmes.add(order.getReceiverPhone());
        parmes.add(order.getPaystate());
        parmes.add(order.getOrdertime());
        parmes.add(order.getUser().getId());
        //执行sql
      /*  QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        qr.update(sql, parmes.toArray());*/

        QueryRunner qr = new QueryRunner();
        qr.update(ManagerThreadLocal.getConnection(),sql, parmes.toArray());


    }

}
