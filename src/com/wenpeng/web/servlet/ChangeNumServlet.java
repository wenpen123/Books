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
import java.util.Map;

@WebServlet("/changeNum")
public class ChangeNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //1:获取参数
        String id = request.getParameter("id");
        String num = request.getParameter("num");
        //2:更新购物车数据
        //2.1通过id查找商品
        ProductService ps = new ProductService();
        Product p = null;
        try
        {
            p = ps.findBookById(id);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        //2.2通过商品更新session数据
        Map<Product, Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        //替换
        if (cart.containsKey(p))
        {//判断是否有这个商品
            if ("0".equals(num))
            {
                cart.remove(p);
            }
            else
            {
                cart.put(p, Integer.parseInt(num));
            }

        }
        //重新保存到session
        request.getSession().setAttribute("cart", cart);
        //回到购物车页面
        response.sendRedirect(request.getContextPath() + "/cart.jsp");

    }
}
