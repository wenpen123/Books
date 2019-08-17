package com.wenpeng.service;

import com.wenpeng.dao.OrderDao;
import com.wenpeng.dao.OrderItemDao;
import com.wenpeng.model.Order;
import com.wenpeng.model.OrderItem;

import java.sql.SQLException;

public class OrderService {

    private OrderDao orderDao = new OrderDao();
    private OrderItemDao orderItemDao = new OrderItemDao();

    public void createOrder(Order order)
    {

        try
        {
            orderDao.add(order);
            orderItemDao.addOrderItems(order.getItems());

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

}
