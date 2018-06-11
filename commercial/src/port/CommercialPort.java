package port;

import blservice.BlService;
import blservice.BlServiceImp;

public class CommercialPort {

  private BlService blService;

  public CommercialPort() {
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
