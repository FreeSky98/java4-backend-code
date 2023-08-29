package com.javaboy.app;

import com.alibaba.fastjson2.JSON;
import com.javaboy.model.Student;
import com.javaboy.util.DaoSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//http://localhost:8080/student/list
@WebServlet("/student/list")
public class StudentController extends HttpServlet {

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
        String sql = "SELECT id,`name`,age,sex,dept,address from student";
        List<Student> list = ds.query(Student.class, sql);
        String json = JSON.toJSONString(list );
        // 将json字符串写到客户端去
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(json);
        out.close();
    }

}
