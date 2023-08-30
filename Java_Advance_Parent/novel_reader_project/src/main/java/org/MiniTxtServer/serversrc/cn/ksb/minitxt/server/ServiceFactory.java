package cn.ksb.minitxt.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ServiceFactory {
	private static final String path = Init
			.getProperty("server.config.service");
	private static Map<String, String> services = new HashMap<>();

	static {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document doc = null;
		try {
			db = dbf.newDocumentBuilder();
			doc = db.parse(new FileInputStream(path));
			NodeList serviceNodes = doc.getElementsByTagName("service");
			int i = 0;
			while (i < serviceNodes.getLength()) {
				Node node = serviceNodes.item(i);
				services.put(node.getAttributes().getNamedItem("key")
						.getNodeValue().trim(), node.getFirstChild()
						.getNodeValue().trim());
				i++;
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static Service<Object> getService(String key) {
		String className = services.get(key);
		if (className == null)
			throw new RuntimeException("无效的功能键");
		try {
			return (Service<Object>) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
