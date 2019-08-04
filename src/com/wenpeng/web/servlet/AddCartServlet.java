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
import java.util.HashMap;
import java.util.Map;


/**
 *
 */
@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        ProductService ps = new ProductService();
        try
        {
            Product p = ps.findBookById(id);
            Map<Product, Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
            if (cart == null)
            {
                cart = new HashMap<Product, Integer>();
                cart.put(p, 1);
            }
            else
            {
                if (cart.containsKey(p))
                {
                    cart.put(p, cart.get(p) + 1);
                }
                else
                {
                    cart.put(p, 1);
                }
            }
            request.getSession().setAttribute("cart", cart);
            for (Map.Entry<Product, Integer> entry : cart.entrySet())
            {
                System.out.println(entry.getKey() + "数量:" + entry.getValue());
            }
            //响应给客户端的页面
            String a1 = "<a href=\"" + request.getContextPath() + "/showProductByPage\"> 继续购物</a>";
            String a2 = "&nbsp&nbsp<a href=\"" + request.getContextPath() + "/cart.jsp\"> 查看购物车</a>";
            response.getWriter().write(a1);
            response.getWriter().write(a2);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


    }
}
