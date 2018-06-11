package dataservice;

import po.Course;
import po.LoginResult;
import po.Selection;

import java.util.ArrayList;

public interface SoftwareService {

    public LoginResult login(String studentID, String studentName);

    public ArrayList<Course> getCourseList();

    public ArrayList<Selection> getHistorySel(String studentID);

    public boolean select(String courseID, String studentID);

    boolean deleteCourse(String courseID, String studentID);
}
