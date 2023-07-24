package com.homework0724;

public enum HW02Enum {
    U1,U2,U3;

    public void study(HW02Enum U) {
        switch (U) {
            case U1 -> System.out.println("第一单元打基础");
            case U2 -> System.out.println("第二单元可以胜任Java程序开发");
            case U3 -> System.out.println("第三单元可以胜任企业级Java开发");
            default -> System.out.println("输入错误！");
        }
    }

    public static class HW02Test {
        public static void main(String[] args) {
            U1.study(U1);
            U2.study(U2);
            U3.study(U3);
        }
    }
}
