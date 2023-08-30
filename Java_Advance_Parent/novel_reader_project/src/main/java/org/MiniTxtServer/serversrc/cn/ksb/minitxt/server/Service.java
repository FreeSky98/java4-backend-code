package cn.ksb.minitxt.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public interface Service<T> {
	void init(Socket socket, ObjectInputStream in, ObjectOutputStream out, T data);

	void destroy() throws IOException;

	void execute() throws IOException;
}
