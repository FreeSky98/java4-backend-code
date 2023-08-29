package org.example.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jdbc_05 {
    private static boolean isNotBlank(String str) {
        if(str == null || str.trim().length() == 0) {
            return false;
        }
        return true;
    }
    //1、多条件任意组合（病人姓名<支持模糊查询>、性别<精确查询>、手机号<支持模糊查询>、出生日期<支持范围查询>），同时翻页功能。
    public static void main(String[] args) throws Exception{
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db?serverTimezone=Asia/Shanghai","root","wangquanquan317");
       String patientName = "";
       String gender = "女";
       String phoneNum = null;
       String startDate = null;
       String endDate = null;
       int pageIndex = 1; //页码
       int pageSize = 5; //页大小
       List<Object> paramList = new ArrayList<>();
        //paramList.clear();
       StringBuilder sb = new StringBuilder("select * from patient where 1=1");
       if(isNotBlank(patientName)) {
           sb.append(" and patientName like concat('%',?,'%')");
           paramList.add(patientName);
       }
       if(isNotBlank(gender)) {
           sb.append(" and gender=?");
           paramList.add(gender);
       }
        if(isNotBlank(phoneNum)) {
            sb.append(" and phoneNum like concat('%',?,'%')");
            paramList.add(phoneNum);
        }

        if(isNotBlank(startDate)) {
            sb.append(" and birthDate >= STR_TO_DATE(?,'%Y-%m-%d')");
            paramList.add(startDate);
        }

        if(isNotBlank(endDate)) {
            sb.append(" and birthDate <= STR_TO_DATE(?,'%Y-%m-%d')");
            paramList.add(endDate);
        }

        sb.append(" limit ?,?");
        paramList.add((pageIndex - 1) * pageSize);
        paramList.add(pageSize);
        PreparedStatement ps = conn.prepareStatement(sb.toString());

        if(paramList.size() > 0) {
            for (int i = 0; i < paramList.size(); i++) {
                // 循环遍历给？设置参数值
                ps.setObject(i+1, paramList.get(i));
            }
        }

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            //patientID as pid,password as pwd,birthDate,gender as sex,phoneNum,email,identityNum idCardNum,address
            int pid = rs.getInt("patientID");
            String pwd = rs.getString("password");
            Date birthDate = rs.getDate("birthDate");
            System.out.println("病人编号：" + pid);
            System.out.println("密码：" + pwd);
            System.out.println("出生日期：" + birthDate.toString());
            System.out.println("-----------------------------------------");
        }
        rs.close();
        ps.close();
        conn.close();
    }
}
