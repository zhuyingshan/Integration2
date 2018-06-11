package port;

import blservice.BlService;
import blservice.BlServiceImp;


public class SoftwarePort {

  private BlService blService = new BlServiceImp();
//  public SoftwarePort() {
//
//  }

  public String login(String studentid, String studentname) {


    return blService.login(studentid.split(",")[0], studentid.split(",")[1]);
//    return "SUCCESS";
  }

  public String chooseCourse(String id, String courseid) {

    return blService.select(id, courseid);
//    return "false";
  }

  public String findAllCourse(String empty) {

//    return blService.getCourseList();
    return "55";
  }

  public String findMyCourse(String myid) {

    return blService.getHistorySel(myid);
//    return "66";
  }
}
