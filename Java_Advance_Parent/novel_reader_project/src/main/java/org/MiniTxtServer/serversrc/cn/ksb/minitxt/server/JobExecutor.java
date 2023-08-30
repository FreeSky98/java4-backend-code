package cn.ksb.minitxt.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class JobExecutor extends Thread {

	private Service<Object> job;

	public void init(Service<Object> job) {
		this.job = job;
	}

	public void init(Service<Object> job, Socket socket, ObjectInputStream in,
			ObjectOutputStream out, Object data) {
		job.init(socket, in, out, data);
		this.job = job;
	}

	@Override
	public void run() {
		// execute
		try {
			job.execute();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// destroy
			try {
				job.destroy();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
