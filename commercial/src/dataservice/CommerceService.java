package dataservice;

import po.Course;
import po.LoginResult;
import po.Selection;

import java.util.ArrayList;

/**
 * Created by 朱应山 on 2018/6/9.
 */
public interface CommerceService {
    /**
     *  简单的登录，验证结果
     * @param studentID 学生ID
     * @param studentName 学生姓名
     * @return 登录结果，包括三种
     */
    public LoginResult login(String studentID, String studentName);

    /**
     *获得院系所有课程
     * @return 院系所有的课程
     */
    public ArrayList<Course> getCourseList();

    /**
     * 获得学生在本院的所有选课记录
     * @param studentID
     * @return
     */
    public ArrayList<Selection> getHistorySel(String studentID);

    /**
     *  选课操作，在选课列表中新增项目，分数初始值为0
     * @param studentID
     * @param coureseID
     * @return
     */
    public boolean select(String studentID, String coureseID);

    /**
     * 删除课程
     * @param courseID
     * @param studentID
     * @return
     */
    public boolean deleteCourse(String courseID, String studentID);
}
