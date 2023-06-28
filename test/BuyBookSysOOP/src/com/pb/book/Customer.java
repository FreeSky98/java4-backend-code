package com.pb.book;

import java.util.Date;

/**
 * 顾客类
 * @author lds
 */
public class Customer {
    /**
     * 用户编号
     */
    private int userId;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 密码
     */
    private String password;
    /**
     * 地址
     */
    private String address;
    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 订单列表
     */
    private Order[] orders; // 一个顾客对应多个订单对象  1:N

    /**
     * 无参构造方法
     */
    public Customer() {
        this.orders = new Order[Constants.ARRAY_SIZE];
    }

    /**
     * 全参构造方法
     * @param userId 用户编号
     * @param realName 真实姓名
     * @param password 密码
     * @param address 地址
     * @param phoneNumber 手机号
     */
    public Customer(int userId, String realName, String password, String address, String phoneNumber) {
        this.userId = userId;
        this.realName = realName;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.orders = new Order[Constants.ARRAY_SIZE];
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 购书
     * @param book 图书对象
     * @param qty  购买数量
     * @return 返回订单明细对象
     */
    public OrderDetail buy(Book book,int qty){
        OrderDetail od = new OrderDetail();
        od.setBook(book);
        od.setQuantity(qty);
        return od;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }
}
