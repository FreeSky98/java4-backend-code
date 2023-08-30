package cn.ksb.minitxt.services;

import java.io.IOException;
import java.util.Scanner;
import cn.ksb.minitxt.client.Init;
import cn.ksb.minitxt.client.Service;
import cn.ksb.minitxt.client.ServiceFactory;
import cn.ksb.minitxt.clientutils.DefaultCommunicatorImpl;
import cn.ksb.minitxt.common.constants.Constants;
import cn.ksb.minitxt.common.constants.UserConstants;
import cn.ksb.minitxt.common.entity.Classification;
import cn.ksb.minitxt.common.entity.DataTransfer;
import cn.ksb.minitxt.common.entity.User;

public class LoginService implements Service<Object> {
	private String OUTPUT_TEXT_USERNAMEE = "�������¼����";
	private String OUTPUT_TEXT_PASSWORD = "���������룺";
	private String OUTPUT_TEXT_INVALIDINPUT = "���������Ч�����������룡";
	private String OUTPUT_TEXT_SUCCESS = "��¼�ɹ���";
	private String OUTPUT_TEXT_FAILED = "�û���������������������룡";
	private String OUTPUT_TEXT_SERVERERROR = "���������ϣ������ԣ�";
	private String OUTPUT_TEXT_ERROR = "ϵͳ���ڴ��󣬷�����ֹ��";

	@Override
	public Service<? extends Object> execute() {
		Scanner scanner = new Scanner(System.in, "GBK");
		Service<Object> next = null;
		while (true) {
			System.out.println(OUTPUT_TEXT_USERNAMEE);
			String username = scanner.next().trim();
			System.out.println(OUTPUT_TEXT_PASSWORD);
			String password = scanner.next().trim();
			if (username.length() == 0 || password.length() == 0) {
				System.out.println(OUTPUT_TEXT_INVALIDINPUT);
				continue;
			}
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			DataTransfer<User> dto = new DataTransfer<>();
			dto.setData(user);
			dto.setKey(Constants.COMMAND_LOGIN);
			DefaultCommunicatorImpl<Classification[]> comm = new DefaultCommunicatorImpl<>();
			DataTransfer<Classification[]> response = null;
			try {
				comm.init(Init.getProperty("socket.server.ip"), Integer
						.parseInt(Init.getProperty("socket.server.port")));
				response = comm.communicate(dto);
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println(OUTPUT_TEXT_SERVERERROR);
				next = ServiceFactory.getService(Constants.COMMAND_START);
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println(OUTPUT_TEXT_ERROR);
				System.exit(1);
			}
			try {
				comm.destroy();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (response.getResult() == UserConstants.SUCCESS) {
				System.out.println(OUTPUT_TEXT_SUCCESS);
				next = ServiceFactory.getService(Constants.COMMAND_GETCLASSES);
				next.setInputData(response.getData());
				break;
			} else if (response.getResult() == UserConstants.USERNAME_NOT_EXSITS
					|| response.getResult() == UserConstants.PASSWORD_INVALID) {
				System.out.println(OUTPUT_TEXT_FAILED);
				continue;
			} else {
				System.out.println(OUTPUT_TEXT_SERVERERROR);
				continue;
			}
		}
		// scanner.close(); // ��ر�System.in

		return next;
	}

	@Override
	public void setInputData(Object inputData) {
	}
}
