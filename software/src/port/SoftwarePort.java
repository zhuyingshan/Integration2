package port;

import dataservice.SoftwareService;
import dataservice.SoftwareServiceImp;
import po.Course;
import po.Grade;
import po.LoginResult;

import java.util.ArrayList;
import java.util.List;

public class SoftwarePort {

  private SoftwareService softwareService;
  public SoftwarePort() {
    softwareService = new SoftwareServiceImp();
  }

  public String login(String studentid, String name) {
//    softwareService.login(studentid, name);
    return String.valueOf(LoginResult.SUCCESS);
  }

  public String chooseCourse(String id, String courseid) {
//    softwareService.select(id, courseid);
    return String.valueOf(LoginResult.NOTEXIST);
  }

  public String findAllCourse(String empty) {
//    softwareService.getCourseList();

    List<Course> list = new ArrayList<>();
    Course course = new Course();
    course.setCourseId("111");
    course.setCourseName("测试");
    course.setIsShare('f');
    course.setTeacher("嘿嘿");
    list.add(course);

    return "all";
  }

  public String findMyCourse(String myid) {
//    softwareService.getHistorySel(myid);
    List<Grade> list = new ArrayList<>();

    Grade grade = new Grade();
    grade.setCourseId("111");
    grade.setStudentId("444");
    grade.setGrade(66);

    list.add(grade);

    return "my";
  }
}
