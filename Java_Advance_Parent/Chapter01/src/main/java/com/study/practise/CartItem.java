package com.study.practise;
/**
 * 商品项类
 */
public class CartItem {
    private Goods goods;//商品信息对象
    private int quantity;//购买数量
    private double subTotal;//小计

    public CartItem() {
    }

    public CartItem(Goods goods, int quantity) {
        this.goods = goods;
        this.quantity = quantity;
        this.subTotal = this.goods.getPrice() * this.quantity;//小计
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
