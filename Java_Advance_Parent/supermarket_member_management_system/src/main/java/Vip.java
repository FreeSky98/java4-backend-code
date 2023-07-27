public class Vip {
    private String username; //用户名
    private Integer cardNo; //卡号
    private String password; //密码
    private Integer point; //积分
    private String openDate; //开卡日期

    public Vip() {
    }

    public Vip(String username, Integer cardNo, String password, Integer point, String openDate) {
        this.username = username;
        this.cardNo = cardNo;
        this.password = password;
        this.point = point;
        this.openDate = openDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCardNo() {
        return cardNo;
    }

    public void setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }
}
