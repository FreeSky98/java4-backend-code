package ReviewOOP;

//公司类
public class Company {

    private String name; //公司名称
    private String address; //公司地址

    public Company() {
    }

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Staff[] getStaffList() {
        return staffList;
    }

    public static void setStaffList(Staff[] staffList) {
        Company.staffList = staffList;
    }

    private static Staff[] staffList = new Staff[10];

    static {
        staffList[0] = new Coder("1000","王千",24,"男",12000,60);
        staffList[1] = new Coder("1001","方志文",26,"男",15000,70);
        staffList[2] = new Coder("1002","邵馨悦",22,"女",14000,90);
        staffList[3] = new Manager("1088","黄赵",29,"男",24000,70);
    }



}
