package lesson02;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("马启航",123643568,"030120");
        Account account1 = new Account("马启航gtdhdf",12,"0301206");
        account.showInfo();
        account1.showInfo();
    }
}

class Account {
    private String name;
    private double balance;
    private String password;

    public Account(String name, double balance, String password) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        }
        else {
            System.out.println("姓名的长度必须是2~4位,否则名字变为匿名");
            this.name = "匿名";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
        else {
            System.out.println("账户余额不能为负数");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() == 6){
            this.password = password;
        }
        else {
            System.out.println("请输入正确的密码，密码为6位数，否则密码为默认值");
            this.password = "123456";
        }
    }

    public void showInfo() {
        System.out.println("getName() = " + getName());
        System.out.println("getBalance() = " + getBalance());
        System.out.println("getPassword() = " + getPassword());
    }
}
