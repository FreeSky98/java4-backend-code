package cn.ksb.minitxt.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import cn.ksb.minitxt.common.constants.NovelConstants;
import cn.ksb.minitxt.common.entity.DataTransfer;
import cn.ksb.minitxt.common.entity.Novel;
import cn.ksb.minitxt.server.BaseServiceImpl;
import cn.ksb.minitxt.utils.NovelUtils;

public class GetPreviewService extends BaseServiceImpl<Novel> {

	@Override
	public void execute() throws IOException {
		DataTransfer<String> dto = new DataTransfer<>();
		try {
			File file = NovelUtils.getNovelFile(getData());
			Reader reader = new FileReader(file);
			char[] content = new char[100];
			reader.read(content);
			dto.setData(new String(content));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			dto.setResult(NovelConstants.FILE_NOT_FOUND);
		} catch (IOException e) {
			e.printStackTrace();
			dto.setResult(NovelConstants.FILE_CANNOT_READ);
		}
		getOut().writeObject(dto);
	}

}
