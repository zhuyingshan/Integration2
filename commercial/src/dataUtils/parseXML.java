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

    public ArrayList<Course> paserSoftwareCourse(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        ArrayList<Course> list = new ArrayList<>();
        try {
            Document document = saxReader.read(inputXml);
            Element Courses = document.getRootElement();
            for (Iterator i = Courses.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String courseID = element.elementText("课程编号");
                String courseName = element.elementText("课程名称");
                String teacher = element.elementText("授课老师");
                String share = element.elementText("共享");
                System.out.print(courseName);
                Course course = new Course(courseID, courseName, teacher, share.charAt(0));
                list.add(course);
            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


    public ArrayList<Student> paserSoftwareStudent(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        ArrayList<Student> list = new ArrayList<>();
        try {
            Document document = saxReader.read(inputXml);
            Element Students = document.getRootElement();
            for (Iterator i = Students.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String studentID = element.elementText("学号");
                String Name = element.elementText("姓名");
                String major = element.elementText("院系");
                String sex = element.elementText("性别");
                Student student = new Student(studentID, Name, major,sex);
                list.add(student);
            }

        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


    public ArrayList<Selection> paserSoftwareSelection(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        ArrayList<Selection> list = new ArrayList<>();
        try {
            Document document = saxReader.read(inputXml);
            Element Selections = document.getRootElement();
            for (Iterator i = Selections.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String studentId = element.elementText("课程编号");
                String courseID = element.elementText("学生编号");
                String grade = element.elementText("成绩");

                Selection selection = new Selection(studentId, courseID, Double.parseDouble(grade));
                list.add(selection);
            }

        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }



}
