package sax;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import po.Course;

/**
 * @author hongliang.dinghl
 *         Dom4j 生成XML文档与解析XML文档
 */
public class Dom4jDemo  {

    public void createXml(String fileName) {
        Document document = DocumentHelper.createDocument();
        Element employees = document.addElement("employees");
        Element employee = employees.addElement("employee");
        Element name = employee.addElement("name");
        name.setText("ddvip");
        Element sex = employee.addElement("sex");
        sex.setText("m");
        Element age = employee.addElement("age");
        age.setText("29");
        try {
            Writer fileWriter = new FileWriter(fileName);
            XMLWriter xmlWriter = new XMLWriter(fileWriter);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }


    }
    public void parserXml(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        ArrayList<Course> list= new ArrayList<>();
        try {
            Document document = saxReader.read(inputXml);
            Element Courses = document.getRootElement();
            for (Iterator i = Courses.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String  couseID=element.element("cno").getText();
                String courseName=element.elementText("cnm");
                String teacher=element.elementText("tec");
                String share=element.elementText("share");
                System.out.println(couseID+" "+courseName+" "+teacher+" "+share+" ");
                Course course=new Course(couseID,courseName,teacher,share.charAt(0));
                list.add(course);

            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list.size());
    }
}