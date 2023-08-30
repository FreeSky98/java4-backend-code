package cn.ksb.minitxt.client;

import cn.ksb.minitxt.common.constants.Constants;

public class ClientMain {
	private Service<? extends Object> service = ServiceFactory
			.getService(Constants.COMMAND_START);

	public static void main(String[] args) {
		new ClientMain().startClient();
	}

	public void startClient() {
		while (true) {
			if (service == null) {
				System.out.println("finish");
				break;
			}
			service = service.execute();
		}
	}
}
