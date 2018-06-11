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
public class CreateMathXML {
    public static void CoursesXML(ArrayList<Course> coursesList ){
        // 创建Document对象
        Document document = DocumentHelper.createDocument();
        // 创建根节点
        Element mathCourses = document.addElement("MathCourses");
        for(Course course:coursesList){
            Element mathCourse=mathCourses.addElement("MathCourse");
            Element id=mathCourse.addElement("编号");
            id.setText(course.courseId);
            Element cnm=mathCourse.addElement("名称");
            cnm.setText(course.courseName);
            Element teacher=mathCourse.addElement("老师");
            teacher.setText(course.teacher);
            Element share=mathCourse.addElement("共享");
            share.setText(course.isShare+"");
        }
        System.out.print(document.asXML());
    }
    public static void SelectionXML(ArrayList<Selection> list){
        Document document=DocumentHelper.createDocument();
        Element mathSelectionList=document.addElement("MathSelectionList");
        for (Selection selection :list) {
            Element mathSelection=mathSelectionList.addElement("MathSelection");
            Element cno=mathSelection.addElement("课程编号");
            cno.setText(selection.courseId);
            Element cnm=mathSelection.addElement("学号");
            cnm.setText(selection.studentId);
            Element grade=mathSelection.addElement("分数");
            grade.setText(selection.grade+"");
        }
        System.out.print(document.asXML());
    }
    public static void StudentXML(ArrayList<Student> list){
        Document document=DocumentHelper.createDocument();
        Element mathStudents=document.addElement("MathStudents");
        for (Student student :list) {
            Element mathStudent=mathStudents.addElement("mathstudent");
            Element sno=mathStudent.addElement("学生编号");
            sno.setText(student.studentId);
            Element snm=mathStudent.addElement("姓名");
            snm.setText(student.name);
            Element dec=mathStudent.addElement("专业");
            dec.setText(student.department);
        }
        System.out.print(document.asXML());

    }
}
