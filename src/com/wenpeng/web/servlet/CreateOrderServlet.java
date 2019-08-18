package com.wenpeng.web.servlet;

import com.wenpeng.model.Order;
import com.wenpeng.model.OrderItem;
import com.wenpeng.model.Product;
import com.wenpeng.model.User;
import com.wenpeng.service.OrderService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/createOrder")
public class CreateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取session 的user
        User user = (User) request.getSession().getAttribute("user");
        Map<Product, Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        if (cart == null || cart.size() == 0)
        {
            response.getWriter().write("购物车没有商品");

        }
        if (user == null)
        {
            response.getWriter().write("非法访问");
            return;

        }
        Order order = new Order();
        try
        {
            //把请求参数封装成order
            BeanUtils.populate(order, request.getParameterMap());

            //不全order信息
            order.setId(UUID.randomUUID().toString());
            order.setOrdertime(new Date());
            order.setUser(user);
            //封装订单详情
            List<OrderItem> itemes = new ArrayList<OrderItem>();
            //取购物车数据
            double totalPrice = 0;
            for (Map.Entry<Product, Integer> entry : cart.entrySet())
            {
                OrderItem item = new OrderItem();
                item.setBuynum(entry.getValue());
                item.setProduct(entry.getKey());
                item.setOrder(order);
                totalPrice += entry.getKey().getPrice() * entry.getValue();
                itemes.add(item);
            }
            //设置order的items
            order.setItems(itemes);
            //设置总价格
            order.setMoney(totalPrice);
            System.out.println(order);
            for (OrderItem item : itemes)
            {
                System.out.println(item.getProduct().getName() + "===" + item.getBuynum());
            }
            OrderService os = new OrderService();
            os.createOrder(order);
            //订单成功.移除购物车数据
            request.getSession().removeAttribute("cart");
            //减少库存

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
