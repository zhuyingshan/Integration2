package format;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import po.Course;
import po.Selection;
import po.Student;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 朱应山 on 2018/6/11.
 */
public class UniteParseXML {


    public static ArrayList<Course> paserUniteCourse(String xmlStr) {
        ArrayList<Course> list = new ArrayList<>();
        try {
            Document document = DocumentHelper.parseText(xmlStr);
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


    public static ArrayList<Student> paserUniteStudent(String xmlStr) {
        ArrayList<Student> list = new ArrayList<>();
        try {
            Document document = DocumentHelper.parseText(xmlStr);
            Element Students = document.getRootElement();
            for (Iterator i = Students.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String studentID = element.elementText("学号");
                String Name = element.elementText("姓名");
                String major = element.elementText("院系");
                Student student = new Student(studentID, Name, major);
                list.add(student);
            }

        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


    public static ArrayList<Selection> paserUniteSelection(String xmlStr) {

        System.out.println("/////////////////"+xmlStr);

        ArrayList<Selection> list = new ArrayList<>();
        try {
            Document document = DocumentHelper.parseText(xmlStr);
            Element Selections = document.getRootElement();
            for (Iterator i = Selections.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String courseID = element.elementText("课程编号");
                String studentId = element.elementText("学生编号");
                String grade = element.elementText("分数");

                Selection selection = new Selection(courseID, studentId, Double.parseDouble(grade));
                list.add(selection);
            }

        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


}
