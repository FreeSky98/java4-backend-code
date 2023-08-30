package cn.ksb.minitxt.services;

import java.io.IOException;

import cn.ksb.minitxt.common.entity.Classification;
import cn.ksb.minitxt.common.entity.DataTransfer;
import cn.ksb.minitxt.server.BaseServiceImpl;
import cn.ksb.minitxt.utils.NovelUtils;

public class GetClassesService extends BaseServiceImpl<Object> {

	@Override
	public void execute() throws IOException {
		DataTransfer<Classification[]> dto = new DataTransfer<>();
		dto.setData(NovelUtils.getClasses());
		getOut().writeObject(dto);
	}

}
