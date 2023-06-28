package lesson06.demo;

// 自定义业务异常类
public class BizException extends Exception {
    private int errCode;
    private String errMsg;

    public BizException(String errMsg) {
        super(errMsg);
    }

    public BizException(int errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
    }
    public BizException(Throwable cause, int errCode, String errMsg) {
        super(errMsg,cause);
        this.errCode = errCode;
    }
}
