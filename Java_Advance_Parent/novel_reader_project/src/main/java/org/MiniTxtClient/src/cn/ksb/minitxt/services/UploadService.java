package cn.ksb.minitxt.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import cn.ksb.minitxt.client.Init;
import cn.ksb.minitxt.client.Service;
import cn.ksb.minitxt.client.ServiceFactory;
import cn.ksb.minitxt.clientutils.DefaultCommunicatorImpl;
import cn.ksb.minitxt.common.constants.Constants;
import cn.ksb.minitxt.common.constants.NovelConstants;
import cn.ksb.minitxt.common.entity.Classification;
import cn.ksb.minitxt.common.entity.DataTransfer;
import cn.ksb.minitxt.common.entity.Novel;

public class UploadService implements Service<Classification> {
	private Classification inputData;
	private String OUTPUT_INPUT_NAME = "请输入小说名：";
	private String OUTPUT_INPUT_AUTHOR = "请输入作者：";
	private String OUTPUT_INPUT_DESC = "请输入简介：";
	private String OUTPUT_INPUT_PATH = "请输入上传的txt(请注意路径用/或者\\\\)：";
	private String OUTPUT_TEXT_REUPLOAD = "继续上传请输入1，返回请输入0：";
	private String OUTPUT_TEXT_SERVERERROR = "服务器故障，请重试！ ";
	private String OUTPUT_TEXT_ERROR = "系统存在错误，服务终止！ ";
	private String OUTPUT_TEXT_FILEEXSITS = "文件已存在，上传终止！ ";
	private String OUTPUT_SIGN_ASTERISK = "**********************************************";
	private String OUTPUT_TEXT_FILENOTFOUND = "文件未找到，请确认后重试！";
	private String OUTPUT_TEXT_UPLOADFAIL = "文件上传失败！";

	@Override
	public void setInputData(Classification inputData) {
		this.inputData = inputData;
	}

	@Override
	public Service<? extends Object> execute() {
		Service<Object> next = null;
		DataTransfer<Novel> dto = new DataTransfer<>();
		dto.setKey(Constants.COMMAND_UPLOAD);
		Novel novel = new Novel();
		novel.setCls(inputData);
		dto.setData(novel);
		Scanner scanner = new Scanner(System.in);
		System.out.println(OUTPUT_INPUT_NAME);
		novel.setName(scanner.next().trim()); // 可以加验证
		System.out.println(OUTPUT_INPUT_AUTHOR);
		novel.setAuthor(scanner.next().trim()); // 可以加验证
		System.out.println(OUTPUT_INPUT_DESC);
		novel.setDesc(scanner.next().trim()); // 可以加验证
		System.out.println(OUTPUT_INPUT_PATH);
		final String path = scanner.next().trim(); // 可以加验证
		final DefaultCommunicatorImpl<?> comm = new DefaultCommunicatorImpl<>();
		DataTransfer<?> response = null;
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

		if (response.getResult() == NovelConstants.FILE_EXISTS) {
			System.out.println(OUTPUT_SIGN_ASTERISK);
			System.out.println(OUTPUT_TEXT_FILEEXSITS);
			try {
				comm.destroy();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			new Thread() {
				@Override
				public void run() {
					File file = new File(path);
					byte[] buffer = new byte[8192];
					int len = -1;
					InputStream fis = null;
					try {
						fis = new FileInputStream(file);
						while ((len = fis.read(buffer)) != -1) {
							comm.getOut().write(buffer, 0, len);
						}
						comm.getOut().flush();
						comm.getSocket().shutdownOutput();
					} catch (FileNotFoundException e) {
						System.err.println(OUTPUT_SIGN_ASTERISK);
						System.err.println(OUTPUT_TEXT_FILENOTFOUND);
						System.err.println(OUTPUT_SIGN_ASTERISK);
					} catch (IOException e) {
						System.err.println(OUTPUT_SIGN_ASTERISK);
						System.err.println(OUTPUT_TEXT_UPLOADFAIL);
						System.err.println(OUTPUT_SIGN_ASTERISK);
						e.printStackTrace();
					} finally {
						if (fis != null)
							try {
								fis.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						try {
							comm.destroy();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				};
			}.start();
		}
		System.out.println(OUTPUT_SIGN_ASTERISK);
		System.out.println(OUTPUT_TEXT_REUPLOAD);
		boolean tbc = true;
		while (tbc) {
			String choice = scanner.next().trim();
			switch (choice) {
			case "0":
				tbc = false;
				next = ServiceFactory.getService(Constants.COMMAND_GETNOVELS);
				next.setInputData(inputData);
				break;
			case "1":
				tbc = false;
				next = ServiceFactory.getService(Constants.COMMAND_UPLOAD);
				next.setInputData(inputData);
				break;
			default:
				break;
			}
		}

		return next;
	}

}
