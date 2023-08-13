package org.homework_dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

public class XmlReader {
    public static void main(String[] args) throws Exception {
        String workDir = System.getProperty("user.dir");
        File file = new File(workDir,"\\NetProgram\\xml_data\\books.xml");
//        System.out.println(file.exists());
        SAXReader reader = new SAXReader();
        Document doc = reader.read(file);//把xml加载到内存，并返回Document接口引用

        Element rootElement = doc.getRootElement();
        System.out.println(rootElement.getName());
        Iterator<Element> it = rootElement.elementIterator("book");
        while (it.hasNext()) {
            Element book = it.next();
            String id = book.attribute("id").getValue();
            String title = book.elementTextTrim("title");
            String author = book.elementTextTrim("author");
            String price = book.elementTextTrim("price");
            System.out.println("id:" + id + ";书名:" + title + ";作者:" + author + ";价格:" + price);
        }
    }
}
