package createXml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import po.Course;
import po.Selection;
import po.Student;

import java.util.ArrayList;

/**
 * Created by 朱应山 on 2018/6/10.
 */
public class CreateSoftwareXML {

    public static void CoursesXML(ArrayList<Course> coursesList ){
        // 创建Document对象
        Document document = DocumentHelper.createDocument();
        // 创建根节点
        Element softwareCourses = document.addElement("SoftwareCourses");
        for(Course course:coursesList){
            Element softwareCourse=softwareCourses.addElement("SoftwareCourse");
            Element cno=softwareCourse.addElement("课程编号");
            cno.setText(course.courseId);
            Element cnm=softwareCourse.addElement("课程名称");
            cnm.setText(course.courseName);
            Element teacher=softwareCourse.addElement("授课老师");
            teacher.setText(course.teacher);
            Element share=softwareCourse.addElement("共享");
            share.setText(course.isShare+"");
        }
        System.out.print(document.asXML());
    }
    public static void SelectionXML(ArrayList<Selection> list){
        Document document=DocumentHelper.createDocument();
        Element softwareSelectionList=document.addElement("SoftwareSelectionList");
        for (Selection selection :list) {
            Element softwareSelection=softwareSelectionList.addElement("SoftwareSelection");
            Element cno=softwareSelection.addElement("课程编号");
            cno.setText(selection.courseId);
            Element cnm=softwareSelection.addElement("学生编号");
            cnm.setText(selection.studentId);
            Element grade=softwareSelection.addElement("成绩");
            grade.setText(selection.grade+"");
        }
        System.out.print(document.asXML());
    }
    public static void StudentXML(ArrayList<Student> list){
        Document document=DocumentHelper.createDocument();
        Element softwareStudents=document.addElement("SoftwareStudents");
        for (Student student :list) {
            Element softwarestudent=softwareStudents.addElement("softwarestudent");
            Element sno=softwarestudent.addElement("学号");
            sno.setText(student.studentId);
            Element snm=softwarestudent.addElement("姓名");
            snm.setText(student.name);
            Element dec=softwarestudent.addElement("院系");
            dec.setText(student.department);
            Element sex=softwarestudent.addElement("性别");
            sex.setText(student.sex);
        }
        System.out.print(document.asXML());

    }

}
