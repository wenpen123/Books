package com.wenpeng.web.servlet;

import com.wenpeng.model.Product;
import com.wenpeng.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/productInfo")
public class ProductInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //1:获取id
        String id =   request.getParameter("id");
        //2:通过id查询到数据库书的信息
        ProductService ps = new ProductService();
        Product Book = null;
        try
        {
            Book = ps.findBookById(id);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        //3:把商品信息存在request.并跳转到product_info.jsp显示;
        request.setAttribute("Book",Book);
        request.getRequestDispatcher("/product_info.jsp").forward(request,response);


    }
}
