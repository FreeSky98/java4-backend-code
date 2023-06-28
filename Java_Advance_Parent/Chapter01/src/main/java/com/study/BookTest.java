package com.study;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BookTest {
    private static final List<Book> bookList = new LinkedList<>();

    static {
    bookList.add(new Book("Java编程",89.5));
    bookList.add(new Book("JSP编程",54.5));
    bookList.add(new Book("PHP编程",62.8));
}
    public static void main(String[] args) {
        System.out.println("排序前");
        for (Book book : bookList) {
            System.out.println(book);
        }
        System.out.println("排序后");
        Collections.sort(bookList);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
