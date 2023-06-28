package com.pb.book;

/**
 * 缓存数据类
 * @author lds
 */
public class CacheData {
    /**
     * 定义图书列表
     */
    private static Book[] books = new Book[Constants.ARRAY_SIZE];

    /**
     * 初始化图书列表
     */
    static {
        books[0] = new Book(1, "Java从入门到精通", 63.1D, 89);
        books[1] = new Book(2, "Java从入门到放弃", 28.8D, 10);
        books[2] = new Book(3, "Java从入门到入魔", 88.5D, 29);
    }

    /**
     * 获得所有图书列表
     * @return 返回图书列表
     */
    public static Book[] getBookInfos() {
        return books;
    }

    /**
     * 检查图书是否存在
     * @param bookId 图书编号
     * @return 返回图书对象，如果不存在，则返回null
     */
    public static Book checkBook(int bookId) {
        for (Book book : books) {
            if(book != null && book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
}
