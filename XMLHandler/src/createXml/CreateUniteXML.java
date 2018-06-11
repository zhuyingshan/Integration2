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
public class CreateUniteXML {
    public static void CoursesXML(ArrayList<Course> coursesList ){
        // 创建Document对象
        Document document = DocumentHelper.createDocument();
        // 创建根节点
        Element uniteCourses = document.addElement("UniteCourses");
        for(Course course:coursesList){
            Element uniteCourse=uniteCourses.addElement("UniteCourse");
            Element cno=uniteCourse.addElement("课程编号");
            cno.setText(course.courseId);
            Element cnm=uniteCourse.addElement("课程名称");
            cnm.setText(course.courseName);
            Element teacher=uniteCourse.addElement("授课老师");
            teacher.setText(course.teacher);
            Element share=uniteCourse.addElement("共享");
            share.setText(course.isShare+"");
        }
        System.out.print(document.asXML());
    }
    public static void SelectionXML(ArrayList<Selection> list){
        Document document=DocumentHelper.createDocument();
        Element uniteSelectionList=document.addElement("UniteSelectionList");
        for (Selection selection :list) {
            Element uniteSelection=uniteSelectionList.addElement("UniteSelection");
            Element cno=uniteSelection.addElement("课程编号");
            cno.setText(selection.courseId);
            Element cnm=uniteSelection.addElement("学生编号");
            cnm.setText(selection.studentId);
            Element grade=uniteSelection.addElement("分数");
            grade.setText(selection.grade+"");
        }
        System.out.print(document.asXML());
    }
    public static void StudentXML(ArrayList<Student> list){
        Document document=DocumentHelper.createDocument();
        Element unitedStudents=document.addElement("UnitedStudents");
        for (Student student :list) {
            Element unitestudent=unitedStudents.addElement("student");
            Element sno=unitestudent.addElement("学号");
            sno.setText(student.studentId);
            Element snm=unitestudent.addElement("姓名");
            snm.setText(student.name);
            Element sde=unitestudent.addElement("院系");
            sde.setText(student.department);
        }
        System.out.print(document.asXML());

    }
}
