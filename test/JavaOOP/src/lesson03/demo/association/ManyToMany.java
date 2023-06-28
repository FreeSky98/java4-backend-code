package lesson03.demo.association;

/**
 * 读者类
 */
class Reader {
    private Book[] books;
    public Reader(int size) {
        books = new Book[size];
    }
}

/**
 * 图书类
 */
class Book {

    private Reader[] readers;

    public Book(int size) {
        readers = new Reader[size];
    }
}

public class ManyToMany {
}
