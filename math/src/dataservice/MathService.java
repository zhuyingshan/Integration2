package dataservice;

import po.Course;
import po.LoginResult;
import po.Selection;

import java.util.ArrayList;

public interface MathService {

    public LoginResult login(String studentID, String studentName);

    public ArrayList<Course> getCourseList();

    public ArrayList<Selection> getHistorySel(String studentID);

    public boolean select(String courseID, String studentID);

    public boolean deleteCourse(String courseID, String studentID);
}