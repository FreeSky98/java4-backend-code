package com.study.demo4;

import java.util.Arrays;
import java.util.List;

public class StringSplit {
    public static void main(String[] args) {
        String idsStr = "1000,1001,1002,1003,1004,1005";

        // 1.split(String regex)拆分字符串，返回字符串数组
        String[] userIds = idsStr.split(",");
        for (String userId : userIds) {
            System.out.print(userId + "\t");
        }

        //2.Arrays.asList(String ... a) 将字符串数组转换为List<String>
        List<String> userIdList = Arrays.asList(userIds);
        System.out.println(userIdList);

        //3.toArray() 将List<String>转换为Object[]
        System.out.println(Arrays.toString(userIdList.toArray()));
    }
}
