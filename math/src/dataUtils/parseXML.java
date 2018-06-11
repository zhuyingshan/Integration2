package dataUtils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import po.Course;
import po.Selection;
import po.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 朱应山 on 2018/6/10.
 */
public class parseXML {

    public ArrayList<Student> paserMathStudent(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        ArrayList<Student> list = new ArrayList<>();
        try {
            Document document = saxReader.read(inputXml);
            Element Students = document.getRootElement();
            for (Iterator i = Students.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String studentID = element.elementText("学生编号");
                String Name = element.elementText("姓名");
                String major = element.elementText("专业");
                Student student = new Student(studentID, Name, major);
                list.add(student);
            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<Course> paserMathCourse(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        ArrayList<Course> list = new ArrayList<>();
        try {
            Document document = saxReader.read(inputXml);
            Element Courses = document.getRootElement();
            for (Iterator i = Courses.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String courseID = element.elementText("编号");
                String courseName = element.elementText("名称");
                String teacher = element.elementText("老师");
                String share = element.elementText("共享");
                Course course = new Course(courseID, courseName, teacher, share.charAt(0));
                list.add(course);
            }

        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<Selection> paserMathSelection(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        ArrayList<Selection> list = new ArrayList<>();
        try {
            Document document = saxReader.read(inputXml);
            Element Selections = document.getRootElement();
            for (Iterator i = Selections.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String studentId = element.elementText("课程编号");
                String courseID = element.elementText("学号");
                String grade = element.elementText("分数");

                Selection selection = new Selection(studentId, courseID, Double.parseDouble(grade));
                list.add(selection);
            }

        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
