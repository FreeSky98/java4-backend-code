package com.study.demo2;

/**
 * 给前端封装统一响应数据结构(例如：json数据格式)
 * 泛型类
 */
public class ApiResult<T> {  // T类型化参数（泛型）
    // 响应状态码
    private int code;
    // 响应消息描述
    private String msg; //message=msg   password=pwd
    // 响应数据
    private T data;

    //带参构造方法
    public ApiResult(ApiCodeEnum codeEnum,T data) {
        // 枚举名.getXxx()方法，获取响应状态码
        this.setCode(codeEnum.getCode());
        this.setMsg(codeEnum.getMessage());
        this.setData(data);
    }

    public ApiResult(ApiCodeEnum codeEnum) {
        // 枚举名.getXxx()方法，获取响应状态码
        this.setCode(codeEnum.getCode());
        this.setMsg(codeEnum.getMessage());
    }
    public ApiResult(int code,String msg) {
        this.setCode(code);
        this.setMsg(msg);
    }
    //泛型的静态方法
    public static <T> ApiResult success(T data) {
        // 创建一个枚举实例
        ApiCodeEnum codeEnum = ApiCodeEnum.SUCCESS;
        ApiResult ar = new ApiResult(codeEnum,data);
        return ar;
    }

    //泛型的静态方法
    public static <T> ApiResult fail(ApiCodeEnum code) {
        // 创建一个枚举实例
        ApiCodeEnum codeEnum = ApiCodeEnum.FAILURE;
        ApiResult ar = new ApiResult(codeEnum);
        return ar;
    }

    //getter和setter方法

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

