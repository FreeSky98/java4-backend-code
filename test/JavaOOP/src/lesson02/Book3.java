package lesson02;

import java.util.Arrays;

public class Book3 {
    private int id;
    private String title;
    private double price;
    static int bookPages;

    static {
        bookPages = 1000;
    }

    public Book3(String title, double price) {
        bookPages++;
        this.id = bookPages;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public static int getBookPages() {
        return bookPages;
    }

    public static void setBookPages(int bookPages) {
        Book3.bookPages = bookPages;
    }


    public String toString() {          //定义toString方法返回
        return "编号：" + getId() + ", 书名：" + getTitle() + ", 价格为：" + getPrice();
    }
}

class Book03Test {
    public static void main(String[] args) {
        Book3[] book03 = {
                new Book3("标题", 250.5),
                new Book3("标题2", 201.2),
                new Book3("标题3", 158.5)
        };
        System.out.println(Arrays.toString(book03));
    }
}
