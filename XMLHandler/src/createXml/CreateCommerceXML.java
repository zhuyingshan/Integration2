package createXml;

import org.dom4j.*;
import po.Course;
import po.Selection;
import po.Student;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import java.util.ArrayList;

public class CreateCommerceXML {
    public static void CoursesXML(ArrayList<Course> coursesList ){
        // 创建Document对象
        Document document = DocumentHelper.createDocument();
        // 创建根节点
        Element commerceCourses = document.addElement("CommerceCourses");
        for(Course course:coursesList){
            Element commerceCourse=commerceCourses.addElement("CommerceCourse");
            Element cno=commerceCourse.addElement("cno");
            cno.setText(course.courseId);
            Element cnm=commerceCourse.addElement("cnm");
            cnm.setText(course.courseName);
            Element teacher=commerceCourse.addElement("tec");
            teacher.setText(course.teacher);
            Element share=commerceCourse.addElement("share");
            share.setText(course.isShare+"");
        }
        System.out.print(document.asXML());
    }
    public static void SelectionXML(ArrayList<Selection> list){
        Document document=DocumentHelper.createDocument();
        Element commerceSelectionList=document.addElement("CommerceSelectionList");
        for (Selection selection :list) {
            Element commerceSelection=commerceSelectionList.addElement("CommerceSelection");
            Element cno=commerceSelection.addElement("cns");
            cno.setText(selection.courseId);
            Element cnm=commerceSelection.addElement("sno");
            cnm.setText(selection.studentId);
            Element grade=commerceSelection.addElement("grd");
            grade.setText(selection.grade+"");
        }
        System.out.print(document.asXML());
    }
    public static void StudentXML(ArrayList<Student> list){
        Document document=DocumentHelper.createDocument();
        Element commerceStudents=document.addElement("CommerceStudents");
        for (Student student :list) {
            Element commercestudent=commerceStudents.addElement("commercestudent");
            Element sno=commercestudent.addElement("sno");
            sno.setText(student.studentId);
            Element snm=commercestudent.addElement("snm");
            snm.setText(student.name);
            Element sde=commercestudent.addElement("sde");
            sde.setText(student.department);
        }
        System.out.print(document.asXML());

    }
}
