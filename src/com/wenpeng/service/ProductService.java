package com.wenpeng.service;

import com.wenpeng.dao.ProductDao;
import com.wenpeng.model.PageResult;
import com.wenpeng.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    public PageResult<Product> findBooks(String category, int page) throws SQLException
    {
        //创建模型
        PageResult<Product> pr = new PageResult<Product>();
        //设置总记录数
        ProductDao pd = new ProductDao();
        long totalCount = pd.count(category);
        pr.setTotalCount(totalCount);
        //设置总页数
        int totalPage = (int) Math.ceil(totalCount * 1.0 / pr.getPageSize());
        pr.setTotalPage(totalPage);
        //设置当前页数
        pr.setCurrentPage(page);
        //当前页的数据
        List<Product> list = pd.findBooks(category, page, pr.getPageSize());
        pr.setList(list);
        return pr;
    }
}
























