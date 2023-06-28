package lesson04.homework04;

public class SeafoodPizza extends Pizza{
    private String topping;//配料信息
    public SeafoodPizza(double price, int size,String topping) {
        super(price, size);
        this.setName("海鲜披萨");
        this.topping = topping;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
    public String showInfo() {
        return super.showInfo()+"配料："+getTopping();
    }
}
