package cn.ksb.minitxt.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class BaseServiceImpl<T> implements Service<T> {

	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private T data;

	@Override
	public void init(Socket socket, ObjectInputStream in, ObjectOutputStream out, T data) {
		this.socket = socket;
		this.in = in;
		this.out = out;
		this.setData(data);
	}

	@Override
	public void destroy() throws IOException {
		in.close();
		out.close();
		socket.close();
	}

	abstract public void execute() throws IOException;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ObjectOutputStream getOut() {
		return out;
	}

	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}

	public ObjectInputStream getIn() {
		return in;
	}

	public void setIn(ObjectInputStream in) {
		this.in = in;
	}

}
