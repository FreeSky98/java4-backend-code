package org.net4;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

public class JsonParser {
    public static void main(String[] args) {
        String student = """
            {"realName": "亚当",
            "nickName": "当当",
            "age": 18,
            "sex":true,
            "spouse":null,
            "height":1.78,
            "hobbies":["a","s","d","f","g"],
            "address": {
                     "province":"安徽省",
                     "city":"合肥市",
                     "district":"包河区",
                     "street":"包公街道"
                 }
            }
            """;
        //1.将Json字符串转换成对象
        JSONObject map = JSON.parseObject(student);
        String realName = map.getString("realName");
        String nickName = map.getString("nickName");
        Integer age = map.getInteger("age");
        Boolean sex = map.getBoolean("sex");
        Object spouse = map.get("spouse");
        Double height = map.getDouble("height");
        JSONArray hobbies = map.getJSONArray("hobbies");
        JSONObject address = map.getJSONObject("address");
        String province = address.getString("province");


        System.out.println(realName);
        System.out.println(nickName);
        System.out.println(age);
        System.out.println(sex);
        System.out.println(spouse);
        System.out.println(height);
        System.out.println(hobbies);
        System.out.println(province);
    }
    //        /*
    //        一、JSON语法：
    //          是JavaScript对象表示语法的子集，它是一种轻量级的文本数据交换格式。
    //
    //        二、JSON 语法规则：
    //            1、数据在名称/值对中，值（value）可以是双引号括起来的字符串（string）、数值（整数或浮点数）(number)、布尔值(true、false)、 null、对象（object）或者数组（array），它们是可以无限嵌套（限制5级内，深不了解析）。
    //            2、数据之间由逗号 , 分隔
    //            3、使用斜杆 \ 来转义字符
    //            4、大括号 {} 保存对象
    //            5、中括号 [] 保存数组，数组可以包含多个对象（对象数组）
    //        三、JSON 的两种结构
    //           1、对象：大括号 {} 保存的对象是一个无序的名称/值对集合。一个对象以左括号 { 开始， 右括号 } 结束。每个"键"后跟一个冒号 :，名称/值对使用逗号 , 分隔。
    //           2、数组：中括号 [] 保存的数组是值（value）的有序集合。一个数组以左中括号 [ 开始， 右中括号 ] 结束，值之间使用逗号 , 分隔。
    //        四、JSON 名称/值对（Map：一个键映射一个值）
    //
    //         */


}
