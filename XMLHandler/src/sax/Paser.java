package sax;

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

public class Paser {
    public ArrayList<Student> paserUnitedStudent(String fileName) {
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

                System.out.println(studentID + " " + Name + " " + major + " ");
                Student student = new Student(studentID, Name, major);
                list.add(student);

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

    public ArrayList<Student> paserCommerceStudent(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        ArrayList<Student> list = new ArrayList<>();
        try {
            Document document = saxReader.read(inputXml);
            Element Students = document.getRootElement();
            for (Iterator i = Students.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String studentID = element.elementText("sno");
                String Name = element.elementText("snm");
                String major = element.elementText("sde");
                Student student = new Student(studentID, Name, major);
                list.add(student);

            }

        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

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

    public ArrayList<Course> paserUniteCourse(String fileName) {
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
                //System.out.println(couseID+" "+courseName+" "+teacher+" "+share+" ");
                Course course = new Course(courseID, courseName, teacher, share.charAt(0));
                list.add(course);

            }

        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

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

        public ArrayList<Course> paserCommerceCourse(String fileName) {
            File inputXml = new File(fileName);
            SAXReader saxReader = new SAXReader();
            ArrayList<Course> list = new ArrayList<>();
            try {
                Document document = saxReader.read(inputXml);
                Element Courses = document.getRootElement();
                for (Iterator i = Courses.elementIterator(); i.hasNext(); ) {
                    Element element = (Element) i.next();
                    String courseID = element.elementText("cno");
                    String courseName = element.elementText("cnm");
                    String teacher = element.elementText("tec");
                    String share = element.elementText("share");
                    Course course = new Course(courseID, courseName, teacher, share.charAt(0));
                    list.add(course);

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

    public ArrayList<Selection> paserUniteSelection(String fileName) {
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
                String grade = element.elementText("分数");

                Selection selection = new Selection(studentId, courseID, Double.parseDouble(grade));
                list.add(selection);
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

    public ArrayList<Selection> paserCommerceSelection(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        ArrayList<Selection> list = new ArrayList<>();
        try {
            Document document = saxReader.read(inputXml);
            Element Selections = document.getRootElement();
            for (Iterator i = Selections.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String studentId = element.elementText("cns");
                String courseID = element.elementText("sno");
                String grade = element.elementText("grd");

                Selection selection = new Selection(studentId, courseID, Double.parseDouble(grade));
                list.add(selection);
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
