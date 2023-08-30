package cn.ksb.minitxt.common.entity;

public class DataTransfer<T> implements java.io.Serializable {
	private static final long serialVersionUID = 3957869568509213387L;
	private String key;
	private T data;
	private int result;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
