package dataservice;

import dataUtils.MathJDBCHelper;
import po.Course;
import po.LoginResult;
import po.Selection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MathServiceImp implements MathService {
    MathJDBCHelper mathJdbcHelper =new MathJDBCHelper();

    @Override
    public LoginResult login(String studentID, String studentName) {
        try {
            String queryString="select 姓名 from student where 学生编号 = "+ studentID;
            System.out.println(queryString);
            mathJdbcHelper.run(queryString);
            ResultSet set= mathJdbcHelper.pst.executeQuery();
            while(set.next()){
                String p=set.getString(1);
                if (p.equals(studentName)) {
                    return LoginResult.SUCCESS;
                }else{
                    return LoginResult.ERROR;
                }
            }
            return LoginResult.NOTEXIST;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("发生错误");
        return LoginResult.ERROR;
    }

    @Override
    public ArrayList<Course> getCourseList() {
        ArrayList<Course> list = new ArrayList<>();
        try {
            String queryString = "select * from course";
            System.out.println(queryString);
            mathJdbcHelper.run(queryString);
            ResultSet set = mathJdbcHelper.pst.executeQuery();
            while (set.next()) {
                String courseID = set.getString(1);
                String courseName = set.getString(2);
                String teacher = set.getString(3);
                char isShare = set.getString(4).charAt(0);
                Course course = new Course(courseID, courseName, teacher, isShare);
                list.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Selection> getHistorySel(String studentID) {
        ArrayList<Selection> list = new ArrayList<>();
        try {
            String queryString = "select * from selection where 学号 = " + studentID;
            mathJdbcHelper.run(queryString);
            ResultSet set = mathJdbcHelper.pst.executeQuery();
            while (set.next()) {
                String cno = set.getString(1);
                String sno = set.getString(2);
                double grade = set.getDouble(3);
                Selection selection = new Selection(cno, sno, grade);
                list.add(selection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean select(String courseID, String studentID) {
        try {
            Selection selection = new Selection(courseID, studentID);
            String addString = " insert into selection values (" + selection.courseId
                    + "," + selection.studentId + "," + selection.grade + ")";
            mathJdbcHelper.run(addString);
            int result=mathJdbcHelper.pst.executeUpdate();
            if(result!=0){
                return  true;
            }else{
                return  false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCourse(String courseID, String studentID){
        try {
            Selection selection = new Selection(courseID, studentID);
            String addString = "delete from selection where 课程编号 = " + selection.courseId + " and 学号 = " + selection.studentId;
            mathJdbcHelper.run(addString);
            int result=mathJdbcHelper.pst.executeUpdate();
            if(result!=0){
                return  true;
            }else{
                return  false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}