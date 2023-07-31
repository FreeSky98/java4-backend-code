package homework0731;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product implements Serializable{
    @Serial
    private static final long serialVersionUID = 5164117008766568951L;
    private String productId;//产品号
    private String name;//产品名
    private int quantity;//数量
    private double unitPrice;//总价

    public Product(String productId, String name, int quantity, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return quantity * unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}

class Order implements Serializable{
    @Serial
    private static final long serialVersionUID = -7767297367489292506L;
    private int orderId;//订单编号
    private List<Product> productList;//产品列表

    public Order(int orderId) {
        this.orderId = orderId;
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }//添加产品功能

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : productList) {
            totalPrice += product.getTotalPrice();
        }
        return totalPrice;
    }//获取总价功能

    public void displayOrderDetails() {
        System.out.println("订单编号: " + orderId);
        System.out.println("产品清单:");
        for (Product product : productList) {
            System.out.println("产品名="+product.getName() + ",数量=" + product.getQuantity() + ",单价=" + product.getUnitPrice() + "元");
        }
        System.out.println("总价为:" + getTotalPrice() + "元");
    }//显示功能

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

class Customer implements Serializable{
    private String name;
    private Order order;

    public Customer(String name) {
        this.name = name;
        this.order = null;
    }

    public void createNewOrder(int orderId) {
        order = new Order(orderId);
    }

    public void addProductToOrder(Product product) {
        if (order != null) {
            order.addProduct(product);
        }
    }

    public void displayOrderDetails() {
        if (order != null) {
            order.displayOrderDetails();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

public class HW01 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        File orderFile = new File("orderInfo.bin");
        String choose;

        if (orderFile.exists()) {
            try(
                    FileInputStream fis = new FileInputStream(orderFile);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    ) {
                Order existingOrder = (Order) ois.readObject();//获取存在的订单对象
                existingOrder.displayOrderDetails();//显示信息
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("请输入用户名: ");
            String customerName = scanner.nextLine();

            System.out.print("请输入订单号:");
            int orderId = scanner.nextInt();

            Customer customer = new Customer(customerName);
            customer.createNewOrder(orderId);

            do {
                System.out.println("请输入产品:");
                System.out.print("产品号:");
                String productId = scanner.next();
                scanner.nextLine();

                System.out.print("名称:");
                String productName = scanner.nextLine();

                System.out.print("购买数量: ");
                int productQuantity = scanner.nextInt();

                System.out.print("产品单价: ");
                double productUnitPrice = scanner.nextDouble();

                Product product = new Product(productId, productName, productQuantity, productUnitPrice);
                customer.addProductToOrder(product);

                customer.displayOrderDetails();
                System.out.println("是否继续?Y/N");
                choose = scanner.next();
            } while (choose.equalsIgnoreCase("y"));
            try(
                    FileOutputStream fos = new FileOutputStream(orderFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    ) {
                oos.writeObject(customer.getOrder());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}