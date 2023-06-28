package com.pb.book;

import java.util.Date;
import java.util.Scanner;

/**
 * 测试类
 * @author lds
 */
public class Application {
    /**
     * 程序入口
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("图书管理系统 》图书列表");
        System.out.println("图书编号\t图书名称\t\t\t\t图书单价\t库存数量");
        System.out.println("-------------------------------------------");
        Book[] list = CacheData.getBookInfos();
        for (Book book : list) {
            if(book == null) continue;
            System.out.println(book.printBookInfo());
        }
        System.out.println("图书管理系统 》购买图书");
        // 创建订单对象
        Order order = new Order();
        order.setOrderId(RandomUtil.randomLong(1000, 9999)); // 订单号
        order.setOrderDate(new Date().toString()); // 下单时间
        order.setOrderStatus(false); // 订单状态：待付款
        // 创建顾客对象
        Customer customer = new Customer();
        customer.setUserId(1);
        customer.setPassword("123456");
        customer.setPhoneNumber("15324498270");
        customer.setRealName("王");
        customer.setAddress("富成大厦4楼");
        int index = 0; // 数组下标
        boolean flag = true; //控制是否继续购买图书标记变量
        do{
            System.out.print("请输入图书编号:");
            int bookId = input.nextInt();
            System.out.print("请输入购买图书数量:");
            int quantity = input.nextInt();
            Book book = CacheData.checkBook(bookId);
            if(book == null) {
                System.out.println("输入的图书编号不存在！");
                continue;
            }
            //获取订单项对象
            OrderDetail orderItem = customer.buy(book, quantity);
            order.getItems()[index++] = orderItem;
            System.out.println("购买图书成功！");
            System.out.print("是否继续购买图书么？（Y/N）");
            String reply = input.next();
            if(!"Y".equalsIgnoreCase(reply)) {
                flag = false;
            }
        }while (flag);
        //将订单对象和顾客对象关联
        customer.getOrders()[0] = order;

        System.out.println("图书管理系统 》图书订单");
        System.out.println("图书订单流水号:" + customer.getOrders()[0].getOrderId());
        System.out.println("图书管理系统 》订单明细");
        System.out.println("图书名称\t\t购买数量\t\t图书小计");
        System.out.println("------------------------------------------");
        for (OrderDetail orderItem : customer.getOrders()[0].getItems()) {
            if(orderItem != null) {
                System.out.println(orderItem.getBook().getBookName() + "\t" + orderItem.getQuantity()+"\t\t" + orderItem.getSubtotal());
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("订单总金额：" + customer.getOrders()[0].getOrderPrice());
        System.out.println("订单日期：" + customer.getOrders()[0].getOrderDate());
        System.out.println("收货地址：" + customer.getAddress());
        System.out.println("联系电话：" + customer.getPhoneNumber());
        System.out.println("联系人：" + customer.getRealName());
    }
}
