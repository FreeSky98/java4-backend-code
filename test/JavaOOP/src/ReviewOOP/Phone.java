package ReviewOOP;

public class Phone {
    private String brand;
    private String type;
    private double price;
    private String color;

    public Phone() {
    }

    public Phone(String brand, String type, double price, String color) {
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String showInfo() {
        return "品牌：" + getBrand() + "\n型号：" + getType() + "\n价格：" + getPrice() + "\n颜色：" + getColor();
    }

    //发短消息
    public String sendMessage(String message, String toPhone) {
        System.out.println("手机短信内容：" + message);
        System.out.println("收信人：" + toPhone);
        return "发送短信成功!";
    }

    //打电话
    public void call(String toPhone) throws InterruptedException {
        System.out.println("正在呼叫" + toPhone + "，请稍后...");
        Thread.sleep(1000L);
        System.out.println("已接通电话，正在通知中 ...");
        Thread.sleep(3000L);
        System.out.println("通话结束!");
    }
}
