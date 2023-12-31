package cn.ksb.minitxt.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import cn.ksb.minitxt.common.constants.NovelConstants;
import cn.ksb.minitxt.common.entity.Classification;
import cn.ksb.minitxt.common.entity.Novel;
import cn.ksb.minitxt.server.Init;

public class NovelUtils {
	private static final String path = Init.getProperty("server.config.class");
	private static Map<String, Classification> classes = new HashMap<>();
	private static Map<String, Map<String, Novel>> novels = new HashMap<>();
	private static Document doc;
	static {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(new FileInputStream(path));
			NodeList classnames = doc.getElementsByTagName("classname");
			NodeList catalogs = doc.getElementsByTagName("catalog");
			NodeList configs = doc.getElementsByTagName("config");
			for (int i = 0; i < classnames.getLength(); i++) {
				Classification cls = new Classification();
				cls.setClassname(classnames.item(i).getFirstChild()
						.getNodeValue().trim());
				cls.setCatalog(catalogs.item(i).getFirstChild().getNodeValue()
						.trim());
				cls.setConfig(configs.item(i).getFirstChild().getNodeValue()
						.trim());
				classes.put(cls.getClassname(), cls);
			}

			for (Classification cls : classes.values()) {
				doc = db.parse(new FileInputStream(cls.getConfig()));
				NodeList names = doc.getElementsByTagName("name");
				NodeList authors = doc.getElementsByTagName("author");
				NodeList descriptions = doc.getElementsByTagName("description");
				NodeList filenames = doc.getElementsByTagName("filename");
				Map<String, Novel> nls = new HashMap<>();
				Novel novel = null;
				for (int i = 0; i < names.getLength(); i++) {
					novel = new Novel();
					novel.setName(names.item(i).getFirstChild().getNodeValue()
							.trim());
					novel.setAuthor(authors.item(i).getFirstChild()
							.getNodeValue().trim());
					novel.setDesc(descriptions.item(i).getFirstChild()
							.getNodeValue().trim());
					novel.setFilename(filenames.item(i).getFirstChild()
							.getNodeValue().trim());
					novel.setCls(cls);
					nls.put(novel.getName(), novel);
				}
				novels.put(cls.getClassname(), nls);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Classification[] getClasses() {
		return classes.values().toArray(new Classification[0]);
	}

	public static Novel[] getNovels(Classification cls) {
		return novels.get(cls.getClassname()).values().toArray(new Novel[0]);
	}

	public static File getNovelFile(Novel novel) {
		String path = classes.get(novel.getCls().getClassname()).getCatalog();
		if (!path.endsWith(File.separator)) {
			path += File.separator;
		}
		String filename = novels.get(novel.getCls().getClassname())
				.get(novel.getName()).getFilename();
		return new File(path + filename);
	}

	public static File makeNovelFile(Novel novel) {
		String path = classes.get(novel.getCls().getClassname()).getCatalog();
		if (!path.endsWith(File.separator)) {
			path += File.separator;
		}
		String filename = novel.getName() + ".txt";
		return new File(path + filename);
	}

	protected static boolean exists(Novel novel) {
		return novels.get(novel.getCls().getClassname()).containsKey(
				novel.getName());
	}

	public static synchronized int saveNovel(Novel novel) {
		if (exists(novel))
			return NovelConstants.FILE_EXISTS;
		novel.setFilename(novel.getName() + ".txt");
		File configFile = new File(classes.get(novel.getCls().getClassname())
				.getConfig());
		File modelFile = new File(Init.getProperty("server.novel.model"));
		BufferedReader reader = null;
		StringBuilder builder = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(modelFile));
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line).append("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		String newNovel = String.format(builder.toString(), novel.getName(),
				novel.getAuthor(), novel.getDesc(), novel.getFilename());
		builder.delete(0, builder.length());
		try {
			reader = new BufferedReader(new FileReader(configFile));
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line).append("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		int index = builder.lastIndexOf("</");
		if (index > -1) {
			String content = new StringBuilder(builder.substring(0, index))
					.append(newNovel).append(builder.substring(index))
					.toString();
			FileWriter writer = null;
			try {
				writer = new FileWriter(configFile);
				writer.write(content);
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (writer != null)
					try {
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		novels.get(novel.getCls().getClassname()).put(novel.getName(), novel);
		return NovelConstants.SAVE_SUCCESS;
	}
}