package lesson05.homework04;

public class News implements Comparable{
    //定义新闻类，包括编号（int类型）、标题、内容和点击数，实现Comparable接口，按照编号正序排列；
    private int number;
    private String title;
    private String contents;//内容
    private int clicks;//点击数

    public News(int number, String title, String contents, int clicks) {
        this.number = number;
        this.title = title;
        this.contents = contents;
        this.clicks = clicks;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof News other)) {
            throw new IllegalArgumentException("传入的对象不是新闻对象！");
        }
        return this.number - other.number;
    }
    public String toString() {
        return "编号："+getNumber()+"，标题："+getTitle()+"，内容："+getContents()+"，点击数："+getClicks();
    }
}
