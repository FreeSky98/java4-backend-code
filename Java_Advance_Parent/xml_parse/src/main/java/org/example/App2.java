package org.example;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App2 {
    public static void main(String[] args) {
        /*
        <movie id="1475137">
            <name>长安三万里</name>
            <type>历史,动画</type>
            <period>168</period>
            <price>7.5</price>
            <releaseDate>2023-07-08</releaseDate>
            <director>谢君伟,邹靖</director>
        </movie>
*/
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(new File("doc/movies.xml"));
            saveToXml(doc);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void saveToXml(Document doc) {
        //1.内存中构建一个新的节点对象
        Element movieEle = doc.getRootElement().addElement("movie");
        movieEle.addAttribute("id","1475137");
        movieEle.addElement("name").setText("长安三万里");
        movieEle.addElement("type").setText("历史,动画");
        movieEle.addElement("period").setText("168");
        movieEle.addElement("price").setText("7.5");
        movieEle.addElement("releaseDate").setText("2023-07-08");
        movieEle.addElement("director").setText("谢君伟,邹靖");
        //2.在内存中构建好的dom树通过 流对象 写到movie.xml文件中去
        XMLWriter out = null;
        try {
            OutputFormat format = OutputFormat.createPrettyPrint();
            out = new XMLWriter(new FileWriter("doc/movies.xml"),format);
            out.write(doc);
            System.out.println("成功写入!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
