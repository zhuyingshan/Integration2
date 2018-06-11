package softwareClientPart.example;

import softwareClientPart.com.intergration.demo.SoftwarePortServiceLocator;
import softwareClientPart.com.intergration.demo.SoftwarePort_PortType;

public class SoftwareClient {
  public static void main(String[] argv) {
    try {
      SoftwarePortServiceLocator locator = new SoftwarePortServiceLocator();
      SoftwarePort_PortType service = locator.getSoftwarePort();
      String res = service.login("33哈哈哈", "嘿嘿");
      System.out.println(res);
      System.out.println(service.chooseCourse("22", "55"));
      System.out.println(service.findAllCourse("77"));
      System.out.println(service.findMyCourse("33"));
    } catch (javax.xml.rpc.ServiceException ex) {
      ex.printStackTrace();
    } catch (java.rmi.RemoteException ex) {
      ex.printStackTrace();
    }
  }
}
