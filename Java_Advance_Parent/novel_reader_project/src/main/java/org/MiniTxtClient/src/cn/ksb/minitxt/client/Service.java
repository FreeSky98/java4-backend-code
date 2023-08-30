package cn.ksb.minitxt.client;

public interface Service<T> {
	public void setInputData(T inputData);
	public Service<? extends Object> execute();
}
