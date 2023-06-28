package lesson02;

public class Clerk {
    private int code;
    private String name;

    private String phoneNumber;

    private String idCardNo;

    private String gender;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        if(code < 0) {
            System.err.println("工号不能是负数");
            return;
        }
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!name.matches("[\\u4E00-\\u9FA5]{2,}")) {
            System.err.println("姓名必须是中文，至少2位以上");
            return;
        }
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(! phoneNumber.matches("1[345789]\\d{9}")) {
            System.err.println("手机号码格式错误！");
            return;
        }
        this.phoneNumber = phoneNumber;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        if(! idCardNo.matches("\\d{17}[\\d|X|x]")){
            System.out.println("身份证号码格式错误！");
            return;
        }
        this.idCardNo = idCardNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(!("男".equals(gender) || "女".equals(gender))) {
            System.out.println("性别不合法，只能是男或者女!");
            return;
        }
        this.gender = gender;
    }
}