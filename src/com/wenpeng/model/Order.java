package com.wenpeng.model;

import java.util.Date;
import java.util.List;

public class Order {
    private String id;
    private double money;
    private String receiverAddress;
    private String receiverName;
    private String receiverPhone;
    private String paystate;
    private Date ordertime;
    private int user_id;
    private User user;

    private List<OrderItem> items;

    public List<OrderItem> getItems()
    {
        return items;
    }

    public void setItems(List<OrderItem> items)
    {
        this.items = items;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public double getMoney()
    {
        return money;
    }

    public void setMoney(double money)
    {
        this.money = money;
    }

    public String getReceiverAddress()
    {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress)
    {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName()
    {
        return receiverName;
    }

    public void setReceiverName(String receiverName)
    {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone()
    {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone)
    {
        this.receiverPhone = receiverPhone;
    }

    public String getPaystate()
    {
        return paystate;
    }

    public void setPaystate(String paystate)
    {
        this.paystate = paystate;
    }

    public Date getOrdertime()
    {
        return ordertime;
    }

    public void setOrdertime(Date ordertime)
    {
        this.ordertime = ordertime;
    }

    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "Order{" + "id='" + id + '\'' + ", money=" + money + ", receiverAddress='" + receiverAddress + '\'' + ", receiverName='" + receiverName + '\'' + ", receiverPhone='" + receiverPhone + '\'' + ", paystate='" + paystate + '\'' + ", ordertime=" + ordertime + ", user_id=" + user_id + ", user=" + user + '}';
    }
}
