package com.wenpeng.model;

public class OrderItem {

private  int buynum;
private Product product;
private Order order;

    @Override
    public String toString()
    {
        return "OrderItem{" + "buynum=" + buynum + ", product=" + product + ", order=" + order + '}';
    }

    public int getBuynum()
    {
        return buynum;
    }

    public void setBuynum(int buynum)
    {
        this.buynum = buynum;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }
}
