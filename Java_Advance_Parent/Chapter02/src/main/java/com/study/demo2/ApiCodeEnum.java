package com.study.demo2;

import java.util.Scanner;

/**
 * 使用枚举保存系统业务状态码和业务提示信息
 */
public enum ApiCodeEnum {
    SUCCESS(0,"请求成功"),
    FAILURE(1,"请求失败"),
    PWD_ERROR(233,"请求失败"),
    INVALID_ACCOUNT(301,"请求失败"),
    ACCOUNT_LOCKED(305,"请求失败");
    private int code;//状态码
    private String message;//业务提示信息

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ApiCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public static ApiCodeEnum getApiCode(int code) {
        ApiCodeEnum[] values = ApiCodeEnum.values();
        for (ApiCodeEnum value : values) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "业务状态码:" + this.code+",业务响应信息:"+ this.message;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入业务状态码：");
        int code = input.nextInt();
        System.out.println(getApiCode(code));
    }
}

