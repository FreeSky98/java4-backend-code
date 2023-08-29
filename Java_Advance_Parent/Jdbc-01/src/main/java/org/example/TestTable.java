package org.example;

import java.sql.*;

public class TestTable {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db?serverTimezone=Asia/Shanghai","root","root");
        String sql = "select patientID,password as pwd,birthDate,gender as sex,patientName,phoneNum,email,identityNum idCardNum,address from patient";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        // 结果集元数据
        ResultSetMetaData rsMetaData = rs.getMetaData();
        System.out.println("列数 = " + rsMetaData.getColumnCount());

        for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
            System.out.println("列名(或别名) = " + rsMetaData.getColumnLabel(i));
            //System.out.println("列数据类型 = " + rsMetaData.getColumnTypeName(i));
        }
    }
}