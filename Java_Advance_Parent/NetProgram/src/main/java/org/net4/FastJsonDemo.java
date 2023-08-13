package org.net4;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.List;

public class FastJsonDemo {
    public static void main(String[] args) {
        String json = """
     {
     "success": true,
     "code": 200,
  "msg": "请求处理成功",
  "data": [
      {
      "id": 1028,
      "name": "黄赵",
      "birthday": "1999-09-18",
      "gender": false,
      "score": 98.5,
      "classRoom": {
           "id": 10,
     "name": "Java84"
      }
   },
   {
      "id": 1029,
      "name": "郭文雅",
      "birthday": "2000-03-12",
      "gender": true,
      "score": 88.6,
      "classRoom": {
           "id": 20,
     "name": "Java85"
      }
   }
  ]
  }
 """;
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        List<Student> students = jsonArray.toList(Student.class);
        students.forEach(System.out::println);
    }










    //task:
    // 1、使用fastjson解析库，将以上的json数据解析出来
    // 2、要求使用对象存储学生信息，多个学生对象使用集合

}
