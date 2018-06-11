package port;

import po.Course;
import po.Grade;
import po.LoginResult;

import java.util.ArrayList;
import java.util.List;

public class MathPort {

  public String login(String studentid, String name) {
    return String.valueOf(LoginResult.SUCCESS);
  }

  public String chooseCourse(String id, String courseid) {
    return String.valueOf(LoginResult.NOTEXIST);
  }

  public String findAllCourse(String empty) {

    List<Course> list = new ArrayList<>();
    Course course = new Course();
    course.setCourseId("111");
    course.setCourseName("测试");
    course.setIsShare('f');
    course.setTeacher("嘿嘿");
    list.add(course);

    return "33";
  }

  public String findMyCourse(String myid) {
    List<Grade> list = new ArrayList<>();

    Grade grade = new Grade();
    grade.setCourseId("111");
    grade.setStudentId("444");
    grade.setGrade(66);

    list.add(grade);

    return "00";
  }
}
