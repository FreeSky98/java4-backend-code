package cn.ksb.minitxt.services;

import java.io.IOException;
import java.util.Scanner;

import cn.ksb.minitxt.client.Init;
import cn.ksb.minitxt.client.Service;
import cn.ksb.minitxt.client.ServiceFactory;
import cn.ksb.minitxt.clientutils.DefaultCommunicatorImpl;
import cn.ksb.minitxt.common.constants.Constants;
import cn.ksb.minitxt.common.constants.NovelConstants;
import cn.ksb.minitxt.common.entity.DataTransfer;
import cn.ksb.minitxt.common.entity.Novel;

public class GetPreviewService implements Service<Novel> {
	private Novel inputData;
	private String OUTPUT_TEXT_SERVERERROR = "���������ϣ������ԣ�";
	private String OUTPUT_TEXT_ERROR = "ϵͳ���ڴ��󣬷�����ֹ��";
	private String OUTPUT_TEXT_INVALIDINPUT = "��������������������룡";
	private String OUTPUT_SIGN_ASTERISK = "**********************************************\n";
	private String OUTPUT_SIGN_BEGINLINE = "��ǰ�Ķ�����%1$s��";
	private String OUTPUT_SIGN_ENDLINE = "\n......��ʡ�����������غ��Ķ�\n";
	private String OUTPUT_TEXT_SELECTLIST = "������ʾ�б�������1������TXT������2��";
	private String OUTPUT_TEXT_FILENOTFOUND = "�ļ�δ�ҵ��������ѱ�ɾ����";
	private String OUTPUT_TEXT_FILECANNOTREAD = "�ļ���ȡ����Ԥ��ʧ�ܣ�";
	private StringBuilder MENU_TEXT_SORT_BEGIN = new StringBuilder(
			OUTPUT_SIGN_ASTERISK).append(OUTPUT_SIGN_BEGINLINE);
	private StringBuilder MENU_TEXT_SORT_END = new StringBuilder(
			OUTPUT_SIGN_ENDLINE).append(OUTPUT_SIGN_ASTERISK).append(
			OUTPUT_TEXT_SELECTLIST);

	@Override
	public void setInputData(Novel inputData) {
		this.inputData = inputData;
	}

	@Override
	public Service<? extends Object> execute() {
		Service<Object> next = null;
		DataTransfer<Novel> dto = new DataTransfer<>();
		dto.setKey(Constants.COMMAND_GETPREVIEW);
		dto.setData(inputData);
		DefaultCommunicatorImpl<String> comm = new DefaultCommunicatorImpl<>();
		DataTransfer<String> response = null;
		try {
			comm.init(Init.getProperty("socket.server.ip"),
					Integer.parseInt(Init.getProperty("socket.server.port")));
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
		if (response.getData() == null) {
			System.out.print(OUTPUT_SIGN_ASTERISK);
			switch (response.getResult()) {
			case NovelConstants.FILE_CANNOT_READ:
				System.out.println(OUTPUT_TEXT_FILECANNOTREAD);
				break;
			case NovelConstants.FILE_NOT_FOUND:
				System.out.println(OUTPUT_TEXT_FILENOTFOUND);
				break;
			}
			System.out.print(OUTPUT_SIGN_ASTERISK);
			System.out.println(OUTPUT_TEXT_SELECTLIST);
		} else {
			System.out.println(String.format(MENU_TEXT_SORT_BEGIN.toString(),
					inputData.getName()));
			System.out.println(response.getData());
			System.out.println(MENU_TEXT_SORT_END);
		}
		Scanner scanner = new Scanner(System.in);
		boolean tbc = true;
		while (tbc) {
			String choice = scanner.next().trim();
			switch (choice) {
			case "1":
				tbc = false;
				next = ServiceFactory.getService(Constants.COMMAND_GETNOVELS);
				next.setInputData(inputData.getCls());
				break;
			case "2":
				tbc = false;
				next = ServiceFactory.getService(Constants.COMMAND_DOWNLOAD);
				next.setInputData(inputData);
				break;
			default:
				System.out.println(OUTPUT_TEXT_INVALIDINPUT);
				break;
			}
		}
		return next;
	}

}
