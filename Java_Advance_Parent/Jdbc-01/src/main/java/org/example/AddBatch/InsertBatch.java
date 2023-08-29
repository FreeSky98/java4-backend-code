package org.example.AddBatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBatch {
    private static final long TIMES = 50000;

    public static void main(String[] args)  {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///hospital_db", "root", "wangquanquan317");
            con.setAutoCommit(false);
            ps = con.prepareStatement("INSERT INTO student (`name`,age,sex,dept,address,idCard)VALUES(?,?,?,?,?,?)");

//            StopWatch stopWatch = new StopWatch("测试批量插入数据任务");
//            stopWatch.start("任务-1");

            for (int i = 1; i <= TIMES; i++) {
                ps.setString(1, MockDataUtil.getName());
                ps.setInt(2, MockDataUtil.getAge());
                ps.setInt(3, MockDataUtil.getSex());
                ps.setString(4, MockDataUtil.getDept());
                ps.setString(5, MockDataUtil.getProCity());
                ps.setString(6,MockDataUtil.getRandomId());
                ps.addBatch();
                if (i % 5000 == 0) {
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            ps.executeBatch();
            ps.clearBatch();
            con.commit();

//            stopWatch.stop();
//            System.out.println("总执行耗时(s)" + stopWatch.getTotalTimeSeconds());

            System.out.println("批量插入完毕！");
        }
        catch (Exception error) {
            error.printStackTrace();
            if(con != null) {
                try {
                    con.rollback();
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
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
