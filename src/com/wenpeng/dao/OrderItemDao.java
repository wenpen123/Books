package com.wenpeng.dao;

import com.wenpeng.model.OrderItem;
import com.wenpeng.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.List;

public class OrderItemDao {

    public void addOrderItems(List<OrderItem> items) throws SQLException
    {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into orderitem(order_id,product_id,buynum) values(?,?,?)";
        for (OrderItem item : items)
        {
            qr.update(sql, item.getOrder().getId(), item.getProduct().getId(), item.getBuynum());
        }

    }
}
