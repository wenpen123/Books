package com.wenpeng.service;

import com.wenpeng.dao.OrderDao;
import com.wenpeng.dao.OrderItemDao;
import com.wenpeng.dao.ProductDao;
import com.wenpeng.model.Order;
import com.wenpeng.model.OrderItem;
import com.wenpeng.utils.ManagerThreadLocal;

import java.sql.SQLException;

public class OrderService {

    private OrderDao orderDao = new OrderDao();
    private OrderItemDao orderItemDao = new OrderItemDao();
    private ProductDao pd = new ProductDao();

    public void createOrder(Order order)
    {

        try
        {
            //开启事物
            ManagerThreadLocal.beginTransaction();
            orderDao.add(order);
            orderItemDao.addOrderItems(order.getItems());
            //减库存
            for (OrderItem item : order.getItems())
            {
                pd.updatePnum(item.getProduct().getId(), item.getBuynum());
            }
            //提交事务
            ManagerThreadLocal.commitTransaction();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //事务回滚
            ManagerThreadLocal.rollbackTransaction();
        }

    }

}
