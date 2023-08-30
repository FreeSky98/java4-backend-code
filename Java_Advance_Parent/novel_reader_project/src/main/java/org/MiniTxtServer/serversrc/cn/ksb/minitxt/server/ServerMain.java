package cn.ksb.minitxt.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

import cn.ksb.minitxt.common.entity.DataTransfer;

public class ServerMain {

	public static void main(String[] args) {
		new ServerMain().startServer();
	}

	public void startServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(Init
					.getProperty("socket.server.port")));
			System.out.println("�����������ɹ���");
			while (true) {
				Socket socket = null;
				socket = serverSocket.accept();
				System.out.println("�ͻ��ˣ�" + socket.getInetAddress() + "��ȡ�����ӣ�");
				ObjectInputStream in = new ObjectInputStream(
						socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(
						socket.getOutputStream());
				DataTransfer<?> dataTransfer = (DataTransfer<?>) in
						.readObject();
				System.out.println("����" + dataTransfer.getKey());
				Service<Object> service = ServiceFactory
						.getService(dataTransfer.getKey());
				JobExecutor jobExecutor = new JobExecutor();
				jobExecutor.init(service, socket, in, out,
						dataTransfer.getData());
				jobExecutor.start();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
