package createXml;

import po.Course;
import po.Selection;
import po.Student;
import sax.Dom4jDemo;
import sax.Paser;

import java.util.ArrayList;

/**
 * Created by 朱应山 on 2018/6/10.
 */
public class Test {
    public static  void main(String args[]){
        Dom4jDemo dom4jDemo=new Dom4jDemo();
        Paser paser=new Paser();/*
        ArrayList<Student> list= paser.paserUnitedStudent("source/xml/UnitedStudent1.xml");
        CreateUniteXML.StudentXML(list);*//*
        ArrayList<Course> list= paser.paserMathCourse("source/xml/MathCourses.xml");
        CreateMathXML.CoursesXML(list);*/
        ArrayList<Selection> list= paser.paserUniteSelection("source/xml/UniteSelectionExam.xml");
        CreateUniteXML.SelectionXML(list);
    }
}
