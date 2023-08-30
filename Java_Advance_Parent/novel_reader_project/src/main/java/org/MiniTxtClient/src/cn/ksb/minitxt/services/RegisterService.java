package cn.ksb.minitxt.services;

import java.io.IOException;
import java.util.Scanner;
import cn.ksb.minitxt.client.Init;
import cn.ksb.minitxt.client.Service;
import cn.ksb.minitxt.client.ServiceFactory;
import cn.ksb.minitxt.clientutils.DefaultCommunicatorImpl;
import cn.ksb.minitxt.common.constants.Constants;
import cn.ksb.minitxt.common.constants.UserConstants;
import cn.ksb.minitxt.common.entity.DataTransfer;
import cn.ksb.minitxt.common.entity.User;

public class RegisterService implements Service<Object> {
	private String OUTPUT_TEXT_USERNAME = "�������¼��:";
	private String OUTPUT_TEXT_PASSWORD = "����������:";
	private String OUTPUT_TEXT_INVALIDINPUT = "���������Ч�����������룡";
	private String OUTPUT_TEXT_SERVERERROR = "���������ϣ������ԣ�";
	private String OUTPUT_TEXT_ERROR = "ϵͳ���ڴ��󣬷�����ֹ��";
	private String OUTPUT_TEXT_PASSWORD2 = "���ٴ���������:";
	private String OUTPUT_TEXT_USEREXIST = "�û����Ѵ��ڣ�������ע�ᣡ";
	private String OUTPUT_TEXT_PASSWORDNOTEQUAL = "�������벻һ����";
	private String OUTPUT_USER_SAVESUCESS = "�û�ע��ɹ������¼��";
	private String OUTPUT_USER_SAVEFAIL = "�û�ע��ʧ�ܣ�������ע�ᣡ";

	@Override
	public Service<? extends Object> execute() {
		Scanner scanner = new Scanner(System.in);
		Service<Object> next = null;
		while (true) {
			System.out.println(OUTPUT_TEXT_USERNAME);
			String username = scanner.next().trim();
			System.out.println(OUTPUT_TEXT_PASSWORD);
			String password = scanner.next().trim();
			System.out.println(OUTPUT_TEXT_PASSWORD2);
			String repwd = scanner.next().trim();
			if (username.length() == 0 || password.length() == 0) {
				System.out.println(OUTPUT_TEXT_INVALIDINPUT);
				continue;
			}
			if (!password.equals(repwd)) {
				System.out.println(OUTPUT_TEXT_PASSWORDNOTEQUAL);
				continue;
			}
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			DataTransfer<User> dto = new DataTransfer<>();
			dto.setData(user);
			dto.setKey(Constants.COMMAND_REGISTER);
			DefaultCommunicatorImpl<?> comm = new DefaultCommunicatorImpl<>();
			DataTransfer<?> response = null;
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
				System.out.println(OUTPUT_USER_SAVESUCESS);
				next = ServiceFactory.getService(Constants.COMMAND_LOGIN);
				break;
			} else if (response.getResult() == UserConstants.USERNAME_EXSITS) {
				System.out.println(OUTPUT_TEXT_USEREXIST);
				continue;
			} else {
				System.out.println(OUTPUT_USER_SAVEFAIL);
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
