package cn.ksb.minitxt.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import cn.ksb.minitxt.common.constants.NovelConstants;
import cn.ksb.minitxt.common.entity.DataTransfer;
import cn.ksb.minitxt.common.entity.Novel;
import cn.ksb.minitxt.server.BaseServiceImpl;
import cn.ksb.minitxt.utils.NovelUtils;

public class UploadService extends BaseServiceImpl<Novel> {

	@Override
	public void execute() throws IOException {
		DataTransfer<?> dto = new DataTransfer<>();
		int result = NovelUtils.saveNovel(getData());
		dto.setResult(result);
		getOut().writeObject(dto);
		if (result == NovelConstants.FILE_EXISTS) {
			super.destroy();
			return;
		}

		new Thread() {
			@Override
			public void run() {
				byte[] buffer = new byte[8192];
				int len = -1;
				OutputStream fos = null;
				File file = NovelUtils.makeNovelFile(getData());
				try {
					fos = new FileOutputStream(file);
					while ((len = getIn().read(buffer)) != -1) {
						fos.write(buffer, 0, len);
					}
					fos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (fos != null)
						try {
							fos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					try {
						getIn().close();
						getOut().close();
						getSocket().close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			};
		}.start();
	}

	@Override
	public void destroy() throws IOException {
		// ∑¿÷πJobExecutorπÿ±’¡¨Ω”
	}

}
