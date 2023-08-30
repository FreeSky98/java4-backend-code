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
import cn.ksb.minitxt.common.entity.Novel;

public class GetNovelsByClassService implements Service<Classification> {
	private Classification inputData;
	private String OUTPUT_TEXT_SERVERERROR = "服务器故障，请重试！";
	private String OUTPUT_TEXT_ERROR = "系统存在错误，服务终止！";
	private String OUTPUT_TEXT_INVALIDINPUT = "你的输入有误，请重新输入！";
	private String OUTPUT_TEXT_READDOWN = "阅读和下载请选择文件序号，上传TXT请输入-1，返回请输入0：";
	private String OUTPUT_SIGN_BEGINLINE = "------------------%1$s列表结束------------------";
	private String OUTPUT_SIGN_HEAD = "序号\t\t名称\t\t作者\t\t简介";
	private String OUTPUT_SIGN_ENDLINE = "------------------小说列表结束------------------";
	private String OUTPUT_SIGN_LINE="-------------------------------------\n";
	private String STORY_TEXT_RETURN="0.返回上一级菜单\n";
	private String STORY_TEXT_READ="1.在线阅读\n";
	private String STORY_TEXT_DOWNLOAD="2.下载TXT\n";
	private String OUTPUT_SIGN_SELECT="请选择： ";
	private StringBuffer MENU_FUNCTION = new StringBuffer(OUTPUT_SIGN_LINE)
											.append(STORY_TEXT_RETURN)
											.append(STORY_TEXT_READ)
											.append(STORY_TEXT_DOWNLOAD)
											.append(OUTPUT_SIGN_LINE)
											.append(OUTPUT_SIGN_SELECT);

	@Override
	public void setInputData(Classification inputData) {
		this.inputData = inputData;
	}

	@Override
	public Service<? extends Object> execute() {
		Service<Object> next = null;
		DataTransfer<Classification> dto = new DataTransfer<>();
		dto.setKey(Constants.COMMAND_GETNOVELS);
		dto.setData(inputData);
		DefaultCommunicatorImpl<Novel[]> comm = new DefaultCommunicatorImpl<>();
		DataTransfer<Novel[]> response = null;
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
		System.out.println(String.format(OUTPUT_SIGN_BEGINLINE,
				inputData.getClassname()));
		System.out.println(OUTPUT_SIGN_HEAD);
		int i = 0;
		StringBuilder novelInfo = null;
		for (Novel nv : response.getData()) {
			novelInfo = new StringBuilder(++i + "").append("\t\t")
					.append(nv.getName()).append("\t\t").append(nv.getAuthor())
					.append("\t\t").append(nv.getDesc());
			System.out.println(novelInfo);
		}
		System.out.println(OUTPUT_SIGN_ENDLINE);
		System.out.println(OUTPUT_TEXT_READDOWN);
		Scanner scanner = new Scanner(System.in);
		int choice = -2;
		while (true) {
			try {
				choice = Integer.parseInt(scanner.next().trim());
			} catch (NumberFormatException e) {
				System.out.println(OUTPUT_TEXT_INVALIDINPUT);
				continue;
			}
			if (choice < -1 || choice > response.getData().length) {
				System.out.println(OUTPUT_TEXT_INVALIDINPUT);
				continue;
			}
			break;
		}
		if (choice == -1) {
			next = ServiceFactory.getService(Constants.COMMAND_UPLOAD);
			next.setInputData(inputData);
		} else if (choice == 0) {
			next = ServiceFactory.getService(Constants.COMMAND_GETCLASSES);
		} else {
			Novel novel = response.getData()[choice - 1];
			System.out.println(MENU_FUNCTION);
			while (true) {
				try {
					choice = Integer.parseInt(scanner.next().trim());
				} catch (NumberFormatException e) {
					System.out.println(OUTPUT_TEXT_INVALIDINPUT);
					continue;
				}
				if (choice < 0 || choice > 2) {
					System.out.println(OUTPUT_TEXT_INVALIDINPUT);
					continue;
				}
				break;
			}
			switch (choice) {
			case 0:
				next = ServiceFactory.getService(Constants.COMMAND_GETNOVELS);
				next.setInputData(inputData);
				break;
			case 1:
				next = ServiceFactory.getService(Constants.COMMAND_GETPREVIEW);
				next.setInputData(novel);
				break;
			case 2:
				next = ServiceFactory.getService(Constants.COMMAND_DOWNLOAD);
				next.setInputData(novel);
				break;
			}
		}
		return next;
	}

}
