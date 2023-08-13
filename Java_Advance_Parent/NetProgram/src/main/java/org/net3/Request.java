package org.net3;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 请求类(用途：封装客户端发送给服务器的数据)
 * @author lds
 */
public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Map<String,Object> data;
    private String action; //表示操作行为（比如：用户登录-login、忘记密码-forgot、用户注册-registry  查询-find等等）
    public Request(){
        //准备好实例化Map集合，在外部程序直接使用Map装载数据
        this.data = new ConcurrentHashMap<>(); // 线程安全的容器
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
