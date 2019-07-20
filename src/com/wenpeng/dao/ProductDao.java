package com.wenpeng.dao;

import com.wenpeng.model.Product;
import com.wenpeng.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    /**
     * 计算总记录数
     *
     * @param count
     * @return
     */

    public long count(String category) throws SQLException
    {
        long count = 0;
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select count(*) from products where 1=1";
        if (category != null && !"".equals(category))
        {
            sql += " and category=?";
            count = (long) qr.query(sql, new ScalarHandler(), category);
        }
        else
        {
            count = (long) qr.query(sql, new ScalarHandler());
        }
        return count;
    }

    public List<Product> findBooks(String category, int page, int pageSize) throws SQLException
    {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from products where 1=1";
        List<Object> params = new ArrayList<Object>();

        if (category != null && !"".equals(category))
        {
            params.add(category);
            sql += " and category=?";
        }
        sql += "limit ?,?";
        int start = (page - 1) * pageSize;
        int lenght = pageSize;
        params.add(start);
        params.add(lenght);
        return qr.query(sql, new BeanListHandler<Product>(Product.class), params.toArray());
    }


  /*  public static void main(String[] args) throws SQLException
    {
        ProductDao pd = new ProductDao();
        long count = pd.count(null);
        System.out.println(count);
        List<Product> wenxue = pd.findBooks("计算机", 2, 4);
        for (Product b :wenxue
             )
        {
            System.out.println(b);
        }
    }*/

}
