package day37.XML.demo1;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class demo1 {
    public static void main(String[] args) throws DocumentException {

        ArrayList<Student> list = new ArrayList<>();

        // 1.新建解析器对象
        SAXReader saxReader = new SAXReader();
        // 2.利用解析器去读取xml文件，并返回文档对象
        Document document = saxReader.read(new File("src/day37/XML/demo1/student.xml"));
        // 拿到了document表示我已经拿到了xml文件的整体
        // 3.解析
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());
        // 4.获取根标签的子标签
        List<Element> elements = rootElement.elements("student");
        for (Element element : elements) {
            // 5.继续获取里面的内容

            // 属性ID
            Attribute id = element.attribute("id");
            String idvalue = id.getText();

            // 标签name
            Element name = element.element("name");
            String namevalue = name.getText();

            // 标签age
            Element age = element.element("age");
            String agevalue = age.getText();
            System.out.println(idvalue+" "+namevalue+" "+agevalue);

            // 把Student对象添加到集合当中
            Student s = new Student(idvalue,namevalue,Integer.parseInt(agevalue));
            list.add(s);
        }

        // 使用Stream流的方式进行打印
        list.stream().forEach(s-> System.out.println(s));
    }
}
