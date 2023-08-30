package cn.ksb.minitxt.services;

import java.io.IOException;

import cn.ksb.minitxt.common.constants.UserConstants;
import cn.ksb.minitxt.common.entity.Classification;
import cn.ksb.minitxt.common.entity.DataTransfer;
import cn.ksb.minitxt.common.entity.User;
import cn.ksb.minitxt.server.BaseServiceImpl;
import cn.ksb.minitxt.utils.NovelUtils;
import cn.ksb.minitxt.utils.UserUtils;

public class LoginService extends BaseServiceImpl<User> {

	@Override
	public void execute() throws IOException {
		int result = UserUtils.doLogin(getData());
		DataTransfer<Classification[]> dto = new DataTransfer<>();
		dto.setResult(result);
		if (result == UserConstants.SUCCESS) {
			dto.setData(NovelUtils.getClasses());
		}
		getOut().writeObject(dto);
	}

}
