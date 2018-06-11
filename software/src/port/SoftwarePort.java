package port;

import blservice.BlService;
import blservice.BlServiceImp;


public class SoftwarePort {

  private BlService blService;
  public SoftwarePort() {
    blService = new BlServiceImp();
  }

  public String login(String studentid, String name) {

    return blService.login(studentid, name);
//    return "SUCCESS";
  }

  public String chooseCourse(String id, String courseid) {

    return blService.select(id, courseid);
//    return "false";
  }

  public String findAllCourse(String empty) {

    return blService.getCourseList();
//    return "55";
  }

  public String findMyCourse(String myid) {

    return blService.getHistorySel(myid);
//    return "66";
  }
}
