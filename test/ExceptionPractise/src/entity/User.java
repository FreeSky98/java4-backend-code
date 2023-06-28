package entity;

public class User {
    private String account;
    private String password;
    private Boolean status;//用户状态    true：锁定 false：正常

    public User(String account, String password, Boolean status) {
        this.account = account;
        this.password = password;
        this.status = status;
    }

    public User() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
