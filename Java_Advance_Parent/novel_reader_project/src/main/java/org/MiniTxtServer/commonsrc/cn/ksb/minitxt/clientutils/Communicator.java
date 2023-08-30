package cn.ksb.minitxt.clientutils;

import java.io.IOException;
import java.net.UnknownHostException;

import cn.ksb.minitxt.common.entity.DataTransfer;

public interface Communicator<T> {
	public void init(String host, int port) throws UnknownHostException, IOException;

	public DataTransfer<T> communicate(DataTransfer<? extends Object> dto) throws IOException, ClassNotFoundException;

	public void destroy() throws IOException;
}
