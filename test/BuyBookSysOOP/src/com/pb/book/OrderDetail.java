package com.pb.book;

/**
 * @author lds
 * 订单明细
 */
public class OrderDetail {

    /**
     * 图书对象
     */
    private Book book;  //订单清单对应哪本图书对象 1:1

    /**
     * 购买数量
     */
    private int quantity;

    /**
     * 小计（计算属性）
     */
    private double subtotal;



    /**
     * 无参构造方法
     */
    public OrderDetail() {
        this.book = new Book();
    }

    /**
     * 有参数构造方法
     * @param quantity
     */
    public OrderDetail(Book book,int quantity) {
        this.quantity = quantity;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return this.book.getBookPrice() * this.quantity;
    }
}
