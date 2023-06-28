package com.study.practise;

public class Goods {
    //    //使用HashMap<K,V>模拟购物车业务
    //    //需求：
    //    //1.将商品放入购物车中（已放入购物车中商品再次加入，数量加1）
    //    //2.将商品从购物车中移除（如果购物车中商品数量大于1，数量减1）
    //    //3.展示购物车中所有商品信息列表
    //    //4.清空购物车
    //    //5.更改购物车中商品购买数量（小计和总计重新计算）
    //    //6.计算购物车中商品总消费金额
    //    //7.创建订单
    private long id;//编号
    private String title;//标题
    private double price;//价格
    private int stock;//库存

    public Goods() {
    }

    public Goods(long id, String title, double price, int stock) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
