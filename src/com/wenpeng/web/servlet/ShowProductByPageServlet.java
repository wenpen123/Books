package com.wenpeng.web.servlet;

import com.wenpeng.model.PageResult;
import com.wenpeng.model.Product;
import com.wenpeng.service.ProductService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/showProductByPage")
public class ShowProductByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取页面参数
        String category = request.getParameter("category");
        String pageStr = request.getParameter("page");
        int page = 1;
        if (pageStr != null && !"".equals(pageStr))
        {
            page = Integer.parseInt(pageStr);//把字符串转成int
        }
        ProductService ps = new ProductService();
        try
        {
            PageResult<Product> pageResult = ps.findBooks(category, page);
            request.setAttribute("pageResult",pageResult);
            //跳转到商品列表页面
           request.getRequestDispatcher("/product_list.jsp").forward(request,response);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
