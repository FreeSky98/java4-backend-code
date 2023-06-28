package com.pb.book;

/**
 * 图书类
 * @author lds
 */
public class Book {
    /**
     * 图书编号
     */
    private int bookId;

    /**
     * 图书标题
     */
    private String bookName;

    /**
     * 图书价格
     */
    private double bookPrice;

    /**
     * 图书库存量
     */
    private int storage;

    /**
     * 图书作者
     */
    private String bookAuthor;

    /**
     * 出版社
     */
    private String bookPress;

    /**
     * 国际标准书号
     */
    private String ISBN;

    /**
     * 无参构造方法
     */
    public Book() {
    }

    /**
     * 有参构造方法
     * @param bookId 图书编号
     * @param bookName 图书名称
     * @param bookPrice 图书价格
     * @param storage 图书库存量
     */
    public Book(int bookId, String bookName, double bookPrice, int storage) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.storage = storage;
    }

    /**
     * 全参构造方法
     * @param bookId 图书编号
     * @param bookName 图书名称
     * @param bookPrice 图书价格
     * @param storage 库存量
     * @param bookAuthor 图书作者
     * @param bookPress 出版社
     * @param ISBN 国际标准书号
     */
    public Book(int bookId, String bookName, double bookPrice, int storage, String bookAuthor, String bookPress, String ISBN) {
        // this(参数列表) 调用本类其他构造方法，作者初始化对象属性
        this(bookId, bookName, bookPrice, storage);
        this.bookAuthor = bookAuthor;
        this.bookPress = bookPress;
        this.ISBN = ISBN;
    }

    /**
     * 输出图书基本信息
     */
    public String printBookInfo(){
        return this.bookId + "\t\t" + this.bookName + "\t\t" + this.bookPrice + "\t\t" + this.storage;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
