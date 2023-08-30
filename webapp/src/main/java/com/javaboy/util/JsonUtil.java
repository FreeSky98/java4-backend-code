package com.javaboy.util;

import com.alibaba.fastjson2.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonUtil {
    /**
     * 将json数据输出到客户端
     * @param obj 传入对象
     * @param response  响应数据
     */
    public static void writeJson(Object obj, HttpServletResponse response) {
        String json = JSON.toJSONString(obj);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(json);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                out.close();
            }
        }


    }
}
