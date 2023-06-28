package lesson02;

import java.util.Scanner;

public class Book {
    private String bookName;
    private int totalPages;

    public Book(String bookName, int totalPages) {
        setBookName(bookName);
        setTotalPages(totalPages);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        if (totalPages >= 200) {
            this.totalPages = totalPages;
        }
        else {
            System.err.println("页数不能少于200页，此书默认页数为200页");
            this.totalPages = 200;
        }
    }
    public void details() {
        System.out.println("书名："+getBookName() +"\n总页数:"+getTotalPages()+"页");
    }
}

class BookTest {
    public static void main(String[] args) {
        Book book = new Book("null",200);
        Scanner input = new Scanner(System.in);
        System.out.print("请输入您想录入的书名：");
        String bookName = input.next();
        book.setBookName(bookName);
        System.out.print("请输入您想录入的页数：");
        int pages = input.nextInt();
        book.setTotalPages(pages);
        System.out.println("这本书的名字是：" + book.getBookName());
        System.out.println("这本书的页数是: " + book.getTotalPages()+"页");
        book.details();
    }
}
