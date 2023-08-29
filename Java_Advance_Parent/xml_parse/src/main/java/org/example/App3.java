package org.example;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class App3 {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(new File("doc/douban.xml"));
            function(doc);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void function(Document doc) {
        Element root = doc.getRootElement();
        String rootName = root.getName();
        System.out.println(rootName);
        List<Element> list = root.elements("channel");
        for (Element element : list) {
            List<Element> list1 = element.elements("item");
            list1.forEach(i -> {
                String title = i.elementTextTrim("title");
                String link = i.elementTextTrim("link");
                String description = i.elementTextTrim("description");
                System.out.println("标题："+title);
                System.out.println("链接："+link);
                System.out.println("描述："+description);
            });
        }
    }
}
