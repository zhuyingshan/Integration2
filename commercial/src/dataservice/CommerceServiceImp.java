package dataservice;

import dataUtils.JDBCHelper;
import po.Course;
import po.LoginResult;
import po.Selection;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by 朱应山 on 2018/6/9.
 */
public class CommerceServiceImp implements CommerceService {
    JDBCHelper jdbcHelper = new JDBCHelper();

    /**
     * 简单的登录，验证结果
     *
     * @param studentID   学生ID
     * @param studentName 学生姓名
     * @return 登录结果，包括三种
     */
    @Override
    public LoginResult login(String studentID, String studentName) {
        try {
            String queryString = "select snm from student where sno =\"" + studentID + "\";";
            System.out.println(queryString);
            jdbcHelper.run(queryString);
            ResultSet set = jdbcHelper.pst.executeQuery();
            while (set.next()) {
                String p = set.getString(1);
                if (p.equals(studentName)) {
                    return LoginResult.SUCCESS;
                } else {
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

    /**
     * 获得院系所有课程
     *
     * @return 院系所有的课程
     */
    @Override
    public ArrayList<Course> getCourseList() {
        ArrayList<Course> list = new ArrayList<>();
        try {
            String queryString = "select * from course;";
            System.out.println(queryString);
            jdbcHelper.run(queryString);
            ResultSet set = jdbcHelper.pst.executeQuery();
            while (set.next()) {
                String courseID = set.getString(1);
                String courseName = set.getString(2);
                String teacher = set.getString(3);
                char share = set.getString(4).charAt(0);
                Course course = new Course(courseID, courseName, teacher, share);
                list.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获得学生在本院的所有选课记录
     *
     * @param studentID
     * @return
     */
    @Override
    public ArrayList<Selection> getHistorySel(String studentID) {
        ArrayList<Selection> list = new ArrayList<>();
        try {
            String queryString = "select *from selection where sno=\"" + studentID + "\";";

            System.out.println("query:"+queryString);
            jdbcHelper.run(queryString);
            ResultSet set = jdbcHelper.pst.executeQuery();
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

    /**
     * 选课操作，在选课列表中新增项目，分数初始值为0
     *
     * @param studentID
     * @param coureseID
     * @return
     */
    @Override
    public boolean select(String studentID, String coureseID) {
        try {
            Selection selection = new Selection(coureseID, studentID);
            String addString = " insert into selection values(\"" + selection.courseId
                    + "\",\"" + selection.studentId + "\",\"" + selection.grade + "\");";
            System.out.println(addString+"*****");
            jdbcHelper.run(addString);
            int result=jdbcHelper.pst.executeUpdate();
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

    /**
     * 删除课程
     *
     * @param courseID
     * @param studentID
     * @return
     */
    @Override
    public boolean deleteCourse(String courseID, String studentID) {
        try {
            Selection selection = new Selection(courseID, studentID);
            String addString = "delete from selection where cno = " + selection.courseId + " and sno = " + selection.studentId;
            jdbcHelper.run(addString);
            int result=jdbcHelper.pst.executeUpdate();
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