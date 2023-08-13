package org.net3;


import java.io.Serial;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 响应类 (服务器对客户端响应数据)
 * @author lds
 */
public class Response implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private boolean success = false; // 操作成功 true  操作失败 false
    private Map<String,Object> data; // 响应数据
    private String message; //响应信息

    public Response() {
        this.data = new ConcurrentHashMap<>(); //线程安全容器类
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
