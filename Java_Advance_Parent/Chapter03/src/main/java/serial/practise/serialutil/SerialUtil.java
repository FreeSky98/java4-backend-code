package serial.practise.serialutil;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/*
   一个类在默认情况下是不允许序列化，要实现某个对象序列化操作，
   必须要实现一个标记序口（java.util.Serializable）
 */
class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 4206901481893124872L;
    // 序列化版本号
    //private static final long serialVersionUID = 1L;

    private int id; // 学号
    private String name; //姓名
    private String password; //密码  敏感数据
    private int age; //年龄
    private Date birthDate; //出生日期


    public Student() {
    }

    public Student(int id, String name, String password, int age, Date birthDate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

class IOUtil {
    //使用文本文件保存学生对象数据
    public static void saveToFile(File targetFile,List<Student> studentList) {
        //缓冲流（字符流） 创建一个写入器对象
        //try-with-resources 实现自动关闭资源
        // 注意事项，释放对象必须实现 `AutoCloseable` 或 `Closeable` 接口
        try(
                PrintWriter writer = new PrintWriter(new FileWriter(targetFile),true)
        ){
            StringBuffer sb = new StringBuffer();
            sb.append(studentList.size()).append("\r\n");
            for (Student student : studentList) {
                sb.append(student.getId())
                        .append("|")
                        .append(student.getName())
                        .append("|")
                        .append(student.getPassword())
                        .append("|")
                        .append(student.getAge())
                        .append("|")
                        .append(DateUtil.toStr(student.getBirthDate(), "yyyy-MM-dd")).append("\r\n");
            }
            writer.write(sb.toString());
            //writer.flush();
            System.out.println("保存学生数据成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> loadFromFile(File sourceFile) {
        List<Student> tempList = new ArrayList<>();
        // 创建读取器对象
        try(BufferedReader reader = new BufferedReader(new FileReader(sourceFile))){
            int size = Integer.parseInt(reader.readLine());
            Student stu;
            String line;
            for (int i = 0; i < size; i++) {
                //1000|王千|wq123456|18|2005-03-10
                line = reader.readLine();
                String[] values = line.split("\\|"); // |	指明两项之间的一个选择。要匹配 |，请使用 \|。
                // 创建学生对象
                stu = new Student();
                stu.setId(Integer.parseInt(values[0]));
                stu.setName(values[1]);
                stu.setPassword(values[2]);
                stu.setAge(Integer.parseInt(values[3]));
                stu.setBirthDate(DateUtil.toDate(values[4],"yyyy-MM-dd"));
                tempList.add(stu);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempList;
    }

    // 升级   对象输出流 -- 序列化 （将对象转换为字节序列的过程）
    public static void saveObject(File destFile,Object object) {
        //创建输出流对象
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destFile))){
            oos.writeObject(object);
            oos.flush();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // 升级版 对象输入流---读操作  反序列化（把字节序列恢复为对象的过程称为对象的反序列化）
    public static Object readObject(File file){
        ObjectInput ois = null;
        try{
            ois = new ObjectInputStream(new FileInputStream(file));
            return ois.readObject();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}

class DateUtil {
    public static Date toDate(String dateStr,String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String toStr(Date date,String pattern) {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);
            return sdf.format(date);
        }catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}

public class SerialUtil {
    // 不使用序列化和反序列化方式    保存内存中
    private static final List<Student> studentList = new ArrayList<>();

    static {
        // 初始化学生信息
        studentList.add(new Student(1000,"王千","wq123456",18,DateUtil.toDate("2005-03-10", "yyyy-MM-dd")));
    }

    public static void main(String[] args) {
        File file = new File("data/students.dat");
        if(file.exists()) {
            List<Student> students = (List<Student>)IOUtil.readObject(file);
            System.out.println("读取磁盘上的学生数据>>>>>>>>>>>>>>>>>>>>>>>>");
            for (Student student : students) {
                System.out.println("学号：" + student.getId() + ",姓名：" + student.getName() + ",密码：" + student.getPassword() + ",年龄：" + student.getAge() + ",出生日期：" + DateUtil.toStr(student.getBirthDate(), "yyyy年MM月dd日"));
            }
        }
        else {
            //输出学生信息
            System.out.println("添加之前>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            for (Student student : studentList) {
                System.out.println("学号：" + student.getId() + ",姓名：" + student.getName() + ",密码：" + student.getPassword() + ",年龄：" + student.getAge() + ",出生日期：" + DateUtil.toStr(student.getBirthDate(), "yyyy年MM月dd日"));
            }
            Scanner input = new Scanner(System.in);
            String answer;
            do {
                System.out.println("请输入学号:");
                int id = input.nextInt();
                System.out.println("请输入姓名:");
                String name = input.next();
                System.out.println("请输入密码:");
                String password = input.next();
                System.out.println("请输入年龄:");
                int age = input.nextInt();
                System.out.println("请输入出生日期(格式：yyyy-MM-dd):");
                String birthDate = input.next();
                Student newStudent = new Student(id, name, password, age, DateUtil.toDate(birthDate, "yyyy-MM-dd"));
                studentList.add(newStudent);
                System.out.println("继续输入么(Y/N)?");
                answer = input.next();
            }while ("y".equalsIgnoreCase(answer));

            System.out.println("添加之后>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            for (Student student : studentList) {
                System.out.println("学号：" + student.getId() + ",姓名：" + student.getName() + ",密码：" + student.getPassword() + ",年龄：" + student.getAge() + ",出生日期：" + DateUtil.toStr(student.getBirthDate(), "yyyy年MM月dd日"));
            }
            IOUtil.saveObject(new File("data/students.dat"),studentList);
        }
    }
}
