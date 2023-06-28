package lesson03.demo;

public class EmployeeTest {
    static Employee[] empList = new Employee[6];
    static {
        empList[0] = new SE("1000","张三",18,90);
        empList[1] = new SE("1001","张大",19,92);
        empList[2] = new SE("1002","张二",20,95);
        empList[3] = new PM("1888","李四",25,5);
        empList[4] = new PM("1889","李吴",27,7);
        empList[5] = new PM("1890","李三光",26,6);
    }
    public static void main(String[] args) {
        for (Employee empLists:empList) {
            empLists.say();
        }
    }
}
