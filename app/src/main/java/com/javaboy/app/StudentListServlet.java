package com.javaboy.app;

import com.javaboy.model.Student;
import com.javaboy.util.DaoSupport;
import com.javaboy.util.JsonUtil;
import com.javaboy.util.R;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//http://localhost:8080/student/list
@WebServlet("/student/list")
public class StudentListServlet extends HttpServlet {

    // 只能处理客户端HTTP GET请求
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        /*
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "郭文雅", 18));
        list.add(new Student(2, "千哥", 16));
        list.add(new Student(3, "王配全", 13));
        list.add(new Student(4, "锦哥", 15));
        list.add(new Student(5, "黄哥", 12));
        String json = JSON.toJSONString(list );*/

        DaoSupport ds = new DaoSupport();
        String sql = "SELECT id,`name`,age,sex,dept,address from student order by id desc limit 30";
        List<Student> list = ds.query(Student.class, sql);
        JsonUtil.writeJson(R.success(list), response);
    }

}
