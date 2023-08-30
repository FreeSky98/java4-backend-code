package com.javaboy.app;
import com.javaboy.util.DaoSupport;
import com.javaboy.util.JsonUtil;
import com.javaboy.util.R;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//    http://localhost:8080/student/add

@WebServlet("/student/add")   //@WebServlet 请求地址的映射
public class StudentAddServlet extends HttpServlet {
    //请求方式
    //重写doPost方法  -----    添加/修改/删除
    //重写doGet方法  -------  查询 (用户登录除外)


    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        //接收客户端请求参数 -------     request  请求对象
        /*InputStream is = request.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while((line = reader.readLine()) != null) {
            sb.append(line);
        }
        System.out.println(sb);
        Student student = JSON.parseObject(sb.toString(), Student.class);*/

        // 接收前端请求参数数据
        // 表单数据   请求体（key:value）
        // 查询字符串参数(http://localhost:8080/student/add?name=Tony&age=18&sex=true&dept=大数据学院&address=xxxxx)）
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String dept = request.getParameter("dept");
        String address = request.getParameter("address");

        String sql = "insert into student (`name`,age,sex,dept,address)values(?,?,?,?,?)";
        DaoSupport dao = new DaoSupport();
        try {
            dao.update(sql,name, age, sex, dept, address);
            JsonUtil.writeJson(
                    R.success(200,"添加学生信息成功"),
                    response);
        }
        catch (Exception ex) {
            JsonUtil.writeJson(
                    R.failure(500,"添加学生信息失败"),
                    response);
        }
    }
}
