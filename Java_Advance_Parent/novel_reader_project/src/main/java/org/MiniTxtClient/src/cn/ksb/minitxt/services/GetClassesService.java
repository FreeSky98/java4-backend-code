package cn.ksb.minitxt.services;

import java.io.IOException;
import java.util.Scanner;

import cn.ksb.minitxt.client.Init;
import cn.ksb.minitxt.client.Service;
import cn.ksb.minitxt.client.ServiceFactory;
import cn.ksb.minitxt.clientutils.DefaultCommunicatorImpl;
import cn.ksb.minitxt.common.constants.Constants;
import cn.ksb.minitxt.common.entity.Classification;
import cn.ksb.minitxt.common.entity.DataTransfer;

public class GetClassesService implements Service<Classification[]> {
	private Classification[] inputData;
	private String OUTPUT_TEXT_SERVERERROR = "服务器故障，请重试！";
	private String OUTPUT_TEXT_ERROR = "系统存在错误，服务终止！";
	private String OUTPUT_TEXT_INVALIDINPUT = "你的输入有误，请重新输入！";
	private String OUTPUT_SIGN_LINE = "-------------------------------------\n";
	private String OUTPUT_SIGN_SELECT = "请选择：";
	private String OUTPUT_TEXT_RETURN = "0.退出登录";
	private StringBuilder MENU_TEXT_SORT_BEGIN = new StringBuilder(OUTPUT_SIGN_LINE)
										.append(OUTPUT_TEXT_RETURN);
	private StringBuilder MENU_TEXT_SORT_END = new StringBuilder(OUTPUT_SIGN_LINE)
										.append(OUTPUT_SIGN_SELECT);

	@Override
	public void setInputData(Classification[] inputData) {
		this.inputData = inputData;
	}

	@Override
	public Service<Object> execute() {
		Service<Object> next = null;
		if (inputData == null) {
			DataTransfer<?> dto = new DataTransfer<>();
			dto.setKey(Constants.COMMAND_GETCLASSES);
			DefaultCommunicatorImpl<Classification[]> comm = new DefaultCommunicatorImpl<>();
			DataTransfer<Classification[]> response = null;
			try {
				comm.init(Init.getProperty("socket.server.ip"), Integer
						.parseInt(Init.getProperty("socket.server.port")));
				response = comm.communicate(dto);
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println(OUTPUT_TEXT_SERVERERROR);
				// next = ServiceFactory.getService(Constants.COMMAND_START);
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
			inputData = response.getData();
		}
		System.out.println(MENU_TEXT_SORT_BEGIN);
		int i = 0;
		for (Classification cls : inputData) {
			System.out.println((++i) + "." + cls.getClassname());
		}
		System.out.println(MENU_TEXT_SORT_END);
		Scanner scanner = new Scanner(System.in);
		int choice = -1;
		while (true) {
			try {
				choice = Integer.parseInt(scanner.next().trim());
			} catch (NumberFormatException e) {
				System.out.println(OUTPUT_TEXT_INVALIDINPUT);
				continue;
			}
			if (choice < 0 || choice > inputData.length) {
				System.out.println(OUTPUT_TEXT_INVALIDINPUT);
				continue;
			}
			break;
		}
		if (choice == 0) {
			next = ServiceFactory.getService(Constants.COMMAND_START);
		} else {
			next = ServiceFactory.getService(Constants.COMMAND_GETNOVELS);
			next.setInputData(inputData[choice - 1]);
		}
		return next;
	}
}
