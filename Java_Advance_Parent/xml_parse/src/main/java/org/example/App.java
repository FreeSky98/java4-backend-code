package org.example;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        String userHome = System.getProperty("user.home");
        String osName = System.getProperty("os.name");
        String fileSeparator = System.getProperty("file.separator");
        String userDir = System.getProperty("user.dir");

        System.out.println("操作系统的名称：" + osName);
        System.out.println("用户的主目录：" + userHome);
        System.out.println("文件目录分隔符的符号：" + fileSeparator);
        System.out.println("用户的当前工作目录：" + userDir);

        //创建文件对象，并关联doc/movies.xml文件
        String filmPath = userDir + File.separator+ "doc"+ File.separator + "movies.xml";
        File filmFile = new File(filmPath);
        //创建一个xml读取器对象
        SAXReader reader = new SAXReader();
        try {
            //将xml加载到内存中，并返回文档对象（Document接口引用在内存中表示整个xml文件）
            Document doc = reader.read(filmFile);
            //获取xml的根节点对象
            Element root = doc.getRootElement();
            //获得xml根节点对象名称
            String rootName = root.getName();
            System.out.println(rootName);
            //获取xml根节点下的元素集合
            List<Element> movieList = root.elements("movie");
            movieList.forEach(m -> {
                //Attribute表示某元素的单个属性节点对象
                String id = m.attributeValue("id");

                //根据子节点名称获取
                String name = m.elementTextTrim("name");
                String type = m.elementTextTrim("type");
                String period = m.elementTextTrim("period");
                String price = m.elementTextTrim("price");
                String releaseDate = m.elementTextTrim("releaseDate");
                String director = m.elementTextTrim("director");

                System.out.println("电影编号:" + id);
                System.out.println("电影名称:" + name);
                System.out.println("电影类型:" + type);
                System.out.println("电影片长:" + period + "(分钟)");
                System.out.println("电影售价:" + price + "(元)");
                System.out.println("放映时间:" + releaseDate);
                System.out.println("导演:" + director);
                System.out.println("---------------------华丽分割线---------------------------");
            });
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
