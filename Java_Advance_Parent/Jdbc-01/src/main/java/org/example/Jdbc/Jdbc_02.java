package org.example.Jdbc;

import java.sql.*;
import java.util.Scanner;

public class Jdbc_02 {
    private static final String driverClass = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "wangquanquan317";
    private static final String URL = "jdbc:mysql:///stu_db?serverTimezone=Asia/Shanghai";//数据库连接地址

    static {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败！");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("操作数据库出错");
            e.printStackTrace();
            return null;
        }
    }

    public void closeAll(ResultSet rs,Statement stmt,Connection conn) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != stmt) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = input.next();

        System.out.println("请输入性别（0未知1男2女）：");
        int gender = input.nextInt();

        System.out.println("请输入出生日期：");
        String birthDate = input.next();

        System.out.println("请输入手机号：");
        String phone = input.next();

        System.out.println("请输入邮箱：");
        String email = input.next();

        System.out.println("请输入地址：");
        String address = input.next();

        System.out.println("请输入密码：");
        String password = input.next();

        System.out.println("请输入身份证号：");
        String idNumber = input.next();

        System.out.println("请输入班级（1~7）：");
        int classId = input.nextInt();

        Jdbc_02 o_OII = new Jdbc_02();
        //获取数据库连接对象
        Connection connection = o_OII.getConnection();
        System.out.println(!connection.isClosed() ? "连接成功" : "连接失败");
        String sql = "insert into student(name,gender,birth_date,phone,email,address,password,id_number,class_id)" +
                "values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,name);
        ps.setInt(2,gender);
        ps.setString(3,birthDate);
        ps.setString(4,phone);
        ps.setString(5,email);
        ps.setString(6,address);
        ps.setString(7,password);
        ps.setString(8,idNumber);
        ps.setInt(9,classId);
        int rows = ps.executeUpdate();//执行DML语句，返回影响行数
        if (rows > 0) {
            System.out.println("添加成功！");
        }
        o_OII.closeAll(null,ps,connection);
    }
}
