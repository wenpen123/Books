package com.wenpeng.dao;

import com.wenpeng.model.OrderItem;
import com.wenpeng.utils.C3P0Utils;
import com.wenpeng.utils.ManagerThreadLocal;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.List;

public class OrderItemDao {

    public void addOrderItems(List<OrderItem> items) throws SQLException
    {
        /*QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into orderitem(order_id,product_id,buynum) values(?,?,?)";
        for (OrderItem item : items)
        {
            qr.update(sql, item.getOrder().getId(), item.getProduct().getId(), item.getBuynum());
        }

*/
        //用批处理方式
        String sql = "insert into orderitem(order_id,product_id,buynum) values(?,?,?)";
        Object[][] params = new Object[items.size()][];
        for (int i = 0; i < items.size(); i++)
        {
            OrderItem item = items.get(i);
            params[i] = new Object[]{item.getOrder().getId(), item.getProduct().getId(), item.getBuynum()};
        }
        //执行批处理语句
       /* QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        qr.batch(sql, params);*/

        QueryRunner qr = new QueryRunner();
        qr.batch(ManagerThreadLocal.getConnection(),sql, params);

    }
}
