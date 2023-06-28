package com.pb.book;

/**
 * 订单类
 * @author lds
 */
public class Order {
    /**
     * 订单号
     */
    private long orderId;

    /**
     * 订单日期
     */
    private String orderDate;

    /**
     * 订单金额
     */
    private double orderPrice;

    /**
     * 订单状态  true表示已支付 false表示未支付
     */
    private boolean orderStatus;
    /**
     * 订单明细列表
     */
    private OrderDetail[] items;  //一个订单包含多个订单明细  1:N
    /**
     * 无参构造方法
     */
    public Order() {
        this.items = new OrderDetail[Constants.ARRAY_SIZE];
    }

    public OrderDetail[] getItems() {
        return items;
    }

    public void setItems(OrderDetail[] items) {
        this.items = items;
    }

    /**
     *
     * @param orderId 订单号
     * @param orderDate 下单时间
     * @param orderPrice 订单金额
     * @param orderStatus 订单状态
     */
    public Order(long orderId, String orderDate, double orderPrice, boolean orderStatus) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
        this.orderStatus = orderStatus;

        this.items = new OrderDetail[Constants.ARRAY_SIZE];
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderPrice() {
        double totalPrice = 0.0;
        for (OrderDetail item : this.getItems()) {
            if(item != null) {
                totalPrice += item.getSubtotal();
            }
        }
        this.orderPrice = totalPrice;
        return orderPrice;
    }


    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }
}
