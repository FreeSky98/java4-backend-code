package com.javaboy.test;

import cn.hutool.core.date.StopWatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBatch {
    private static final long TIMES = 1_000_000;

    public static void main(String[] args)  {
        //StopWatch stopWatch = new StopWatch("测试批量插入数据任务");


        Connection con = null;
        PreparedStatement ps = null;
        int counter = 1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///hospital_db", "root", "root");

            con.setAutoCommit(false); // 禁用自动提交模式

            ps = con.prepareStatement("INSERT INTO student (`name`,age,sex,dept,address,idcard)VALUES(?,?,?,?,?,?)");

            for (int i = 1; i <= TIMES; i++) {

                ps.setString(1, MockDataUtil.getName());
                ps.setInt(2, MockDataUtil.getAge());
                ps.setInt(3, MockDataUtil.getSex());
                ps.setString(4, MockDataUtil.getDept());
                ps.setString(5, MockDataUtil.getAddress());
                ps.setString(6, MockDataUtil.getIdCard().toString());
                ps.addBatch();
                if (i % 5000 == 0) {
                    //stopWatch.start("任务阶段" + (counter++));
                    ps.executeBatch();
                    ps.clearBatch();
                    con.commit(); // 提交事务
                   // stopWatch.stop();
                    //System.out.println("每5000条记录插入耗时(ms)：" + stopWatch.getLastTaskTimeMillis());
                }
            }

            ps.executeBatch();
            ps.clearBatch();
            con.commit(); // 提交事务

           // stopWatch.stop();
            //System.out.println("总耗时(s)" + stopWatch.getTotalTimeSeconds());

            System.out.println("批量插入完毕！");
        }
        catch (Exception error) {
            error.printStackTrace();
            if(con != null) {
                try {
                    con.rollback(); //回滚事务
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(con != null) {
                try {
                    con.setAutoCommit(true); // 启动事务提交模式
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
