package com.javaboy.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {
    private Integer code;

    private String msg;

    private T data;

    public R() {

    }

    public R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private R(ResponseStatusEnum resultStatus, T data) {
        this.code = resultStatus.getCode();
        this.msg = resultStatus.getMsg();
        this.data = data;
    }

    /**
     * 业务成功返回业务代码和描述信息
     */
    public static R<Void> success() {
        return new R<Void>(ResponseStatusEnum.SUCCESS, null);
    }

    public static R<Void> success(Integer code,String msg) {
        return new R<Void>(code,msg);
    }

    /**
     * 业务成功返回业务代码,描述和返回的参数
     */
    public static <T> R<T> success(T data) {
        return new R<T>(ResponseStatusEnum.SUCCESS, data);
    }

    /**
     * 业务成功返回业务代码,描述和返回的参数
     */
    public static <T> R<T> success(ResponseStatusEnum resultStatus, T data) {
        if (resultStatus == null) {
            return success(data);
        }
        return new R<T>(resultStatus, data);
    }

    /**
     * 业务异常返回业务代码和描述信息
     */
    public static <T> R<T> failure() {
        return new R<T>(ResponseStatusEnum.SYSTEM_ERROR, null);
    }

    /**
     * 业务异常返回业务代码,描述和返回的参数
     */
    public static <T> R<T> failure(ResponseStatusEnum resultStatus) {
        return failure(resultStatus, null);
    }

    /**
     * 业务异常返回业务代码,描述和返回的参数
     */
    public static <T> R<T> failure(ResponseStatusEnum resultStatus, T data) {
        if (resultStatus == null) {
            return new R<T>(ResponseStatusEnum.SYSTEM_ERROR, null);
        }
        return new R<T>(resultStatus, data);
    }

    public static <T> R<T> failure(Integer code, String msg) {
        return new R<T>(code, msg);
    }
}
