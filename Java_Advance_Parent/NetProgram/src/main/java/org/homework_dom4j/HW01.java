package org.homework_dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class HW01 {
    //2.使用DOM4J解析第1题作业中编写的XML文档，输出所有学员信息，并进行以下操作：
    // 删除id为1的学生成绩信息，修改id为2的成绩为60，添加一个学生的成绩信息（id为5）。
    public static void main(String[] args) {
        File file = new File("D:\\java_projects\\Java_Advance_Parent\\NetProgram\\xml_data\\scores.xml");
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(file);//把xml加载到内存，并返回Document接口引用
            Element rootElement = doc.getRootElement();
            System.out.println(rootElement.getName());

            Iterator<Element> it = rootElement.elementIterator();
            while (it.hasNext()) {
                Element next = it.next();
                String id = next.attribute("id").getValue();
                String name = next.elementTextTrim("name");
                String course = next.elementTextTrim("course");
                String score = next.elementTextTrim("score");
                System.out.println("学生id:" + id + ";姓名:" + name + ";课程:" + course + ";成绩:" + score);

                if (id.equals("1")) {
                    rootElement.remove(next);
                }

                // 修改id为2的成绩为60
                if (id.equals("2")) {
                    Element scoreElement = next.element("score");
                    if (scoreElement != null) {
                        scoreElement.setText("60");
                    }
                }
            }

            // 添加一个学生的成绩信息（id为5）
            Element newElement = rootElement.addElement("scores");
            newElement.addElement("id").setText("5");
            newElement.addElement("name").setText("学生5");
            newElement.addElement("course").setText("科目5");
            newElement.addElement("score").setText("90");

            //保存xml
            OutputFormat format = OutputFormat.createPrettyPrint();
            try {
                XMLWriter writer = new XMLWriter(new FileWriter("NetProgram\\src\\main\\java\\org\\homework_dom4j\\newScores.xml"),format);
                writer.write(doc);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
