package port;

import blservice.BlService;
import blservice.BlServiceImp;
import po.Course;
import po.Grade;
import po.LoginResult;

import java.util.ArrayList;
import java.util.List;

public class MathPort {

  private BlService blService;

  public MathPort() {
    blService = new BlServiceImp();
  }

  public String login(String studentid, String name) {

    return blService.login(studentid, name);
  }

  public String chooseCourse(String id, String courseid) {

    return blService.select(id, courseid);
  }

  public String findAllCourse(String empty) {

    return blService.getCourseList();
  }

  public String findMyCourse(String myid) {

    return blService.getHistorySel(myid);
  }
}
