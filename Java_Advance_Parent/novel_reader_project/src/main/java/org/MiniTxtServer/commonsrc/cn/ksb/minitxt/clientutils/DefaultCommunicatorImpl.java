package cn.ksb.minitxt.clientutils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import cn.ksb.minitxt.common.entity.DataTransfer;

public class DefaultCommunicatorImpl<T> implements Communicator<T> {
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	@Override
	public void init(String host, int port) throws UnknownHostException,
			IOException {
		socket = new Socket(host, port);
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());
	}

	@SuppressWarnings("unchecked")
	@Override
	public DataTransfer<T> communicate(DataTransfer<? extends Object> dto)
			throws IOException, ClassNotFoundException {
		out.writeObject(dto);
		return (DataTransfer<T>) in.readObject();
	}

	@Override
	public void destroy() throws IOException {
		in.close();
		out.close();
		socket.close();
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ObjectInputStream getIn() {
		return in;
	}

	public void setIn(ObjectInputStream in) {
		this.in = in;
	}

	public ObjectOutputStream getOut() {
		return out;
	}

	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}

}
