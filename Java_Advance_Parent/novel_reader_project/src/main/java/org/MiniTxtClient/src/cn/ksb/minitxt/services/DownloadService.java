package cn.ksb.minitxt.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

import cn.ksb.minitxt.client.Init;
import cn.ksb.minitxt.client.Service;
import cn.ksb.minitxt.client.ServiceFactory;
import cn.ksb.minitxt.clientutils.DefaultCommunicatorImpl;
import cn.ksb.minitxt.common.constants.Constants;
import cn.ksb.minitxt.common.constants.NovelConstants;
import cn.ksb.minitxt.common.entity.DataTransfer;
import cn.ksb.minitxt.common.entity.Novel;

public class DownloadService implements Service<Novel> {
	private Novel inputData;
	private String OUTPUT_TEXT_SERVERERROR = "���������ϣ������ԣ�";
	private String OUTPUT_TEXT_ERROR = "ϵͳ���ڴ��󣬷�����ֹ��";
	private String OUTPUT_SIGN_ASTERISK = "**********************************************\n";
	private String OUTPUT_TEXT_FILENOTFOUND = "�ļ�δ�ҵ��������ѱ�ɾ����";
	private String OUTPUT_TEXT_FILECANNOTREAD = "�ļ��޷���ȡ������ʧ�ܣ�";
	private String OUTPUT_TEXT_DOWNLOADSTART = "�ļ���ʼ���أ�";
	private String OUTPUT_TEXT_DOWNLOADFAIL = "�ļ�����ʧ�ܣ�";
	private String OUTPUT_TEXT_DOWNLOADSUCCESS = "�ļ����سɹ���\n���غ���ļ�·���ǣ�%1$s\n���غ���ļ����ǣ�%2$s";
	private String OUTPUT_TEXT_SELECTLIST = "���س������أ�";

	@Override
	public void setInputData(Novel inputData) {
		this.inputData = inputData;
	}

	@Override
	public Service<? extends Object> execute() {
		Service<Object> next = null;
		DataTransfer<Novel> dto = new DataTransfer<>();
		dto.setKey(Constants.COMMAND_DOWNLOAD);
		dto.setData(inputData);
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

		boolean tbc = true;
		System.out.println(OUTPUT_SIGN_ASTERISK);
		switch (response.getResult()) {
		case NovelConstants.FILE_CANNOT_READ:
			tbc = false;
			System.out.println(OUTPUT_TEXT_FILECANNOTREAD);
			break;
		case NovelConstants.FILE_NOT_FOUND:
			tbc = false;
			System.out.println(OUTPUT_TEXT_FILENOTFOUND);
			break;
		default:
			System.out.println(OUTPUT_TEXT_DOWNLOADSTART);
			break;
		}
		if (tbc) {
			new Thread() {
				@Override
				public void run() {
					String path = Init.getProperty("client.download.path");
					if (!path.endsWith(File.separator)) {
						path += File.separator;
					}
					String filename = inputData.getName() + ".txt";
					File file = new File(path + filename);
					byte[] buffer = new byte[8192];
					int len = -1;
					OutputStream fos = null;
					try {
						fos = new FileOutputStream(file);
						while ((len = comm.getIn().read(buffer)) != -1) {
							fos.write(buffer, 0, len);
						}
						fos.flush();
					} catch (IOException e) {
						file.delete();
						System.err.println(OUTPUT_SIGN_ASTERISK);
						System.err.println(OUTPUT_TEXT_DOWNLOADFAIL);
						System.err.println(OUTPUT_SIGN_ASTERISK);
						e.printStackTrace();
					} finally {
						if (fos != null)
							try {
								fos.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						try {
							comm.destroy();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					System.err.print(OUTPUT_SIGN_ASTERISK);
					System.err.println(String.format(
							OUTPUT_TEXT_DOWNLOADSUCCESS, path, filename));
					System.err.println(OUTPUT_SIGN_ASTERISK);
				}
			}.start();
		} else {
			try {
				comm.destroy();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(OUTPUT_SIGN_ASTERISK);
		System.out.println(OUTPUT_TEXT_SELECTLIST);
		Reader reader = new InputStreamReader(System.in);
		try {
			reader.read();
			// reader.close(); // ��ر�System.in
		} catch (IOException e) {
			e.printStackTrace();
		}
		next = ServiceFactory.getService(Constants.COMMAND_GETNOVELS);
		next.setInputData(inputData.getCls());
		return next;
	}

}
