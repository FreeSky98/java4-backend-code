package lesson02;

import java.util.Scanner;

public class Book2 {
    private final String title;//书名
    private final String author;//作者
    private String press;//出版社名
    private double price;//价格

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 10) {
            this.price = price;
        }
        else {
            System.err.println("图书价格必须大于10元");
        }
    }

    public Book2(String title, String author, String press, double price) {
        this.title = title;
        this.author = author;
        setPress(press);
        setPrice(price);
    }
    public void showBookInfo() {
        System.out.println("这本书名为："+getTitle()+"作者是："+getAuthor()+"。出版社为："+getPress()+"。价格为"+getPrice()+"元");
    }
}

class Book2Test {
    public static void main(String[] args) {
        Book2 book2 = new Book2("蔡徐坤为什么火遍全网？","孙笑川","小黑子出版社",114.514);
        Scanner input = new Scanner(System.in);
        book2.showBookInfo();

        System.out.print("如需要修改出版社，请在此输入新信息：");
        String press = input.next();
        book2.setPress(press);
        System.out.print("如需要修改此书的价格，请在此输入新信息：");
        double price = input.nextDouble();
        book2.setPrice(price);
        book2.showBookInfo();
    }
}
