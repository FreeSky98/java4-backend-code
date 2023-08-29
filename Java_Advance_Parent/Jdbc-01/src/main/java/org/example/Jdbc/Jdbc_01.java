package org.example.Jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class Jdbc_01
{
    private static final String USER = "root";
    private static final String PASSWORD = "wangquanquan317";
    private static final String URL = "jdbc:mysql:///stu_db?serverTimezone=Asia/Shanghai";//数据库连接地址
//    private static final String URL = "jdbc:mysql:///127.0.0.1:3306/stu_db?serverTimezone=Asia/Shanghai";//数据库远程连接地址
    public static void main( String[] args )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //1.查询学生表所有学生数据
        try {
            Class.forName(Driver.class.getName());//加载 mysql数据库驱动类
            connection = DriverManager.getConnection(URL, USER, PASSWORD);//创建数据库链接
            String sql = "SELECT * FROM student";//构建sql语句获得预编译对象
            preparedStatement = connection.prepareStatement(sql);//通过sql语句获得预编译对象
            resultSet = preparedStatement.executeQuery();//通过预编译对象执行sql代码
            System.out.println("学号\t\t姓名\t\t生日\t\t");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date birthDate = resultSet.getDate("birth_date");
                Timestamp createDate = resultSet.getTimestamp("create_date");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                boolean status = resultSet.getBoolean("status");
                String password = resultSet.getString("password");
                String idNumber = resultSet.getString("id_number");
                int classId = resultSet.getInt("class_id");
                System.out.println("--------------------------------------------------------------------");
                System.out.println(id + "\t" + name +"\t" + birthDate + "\t");
            }//循环遍历结果集
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != preparedStatement) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
