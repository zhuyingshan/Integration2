package mathClientPart.example;

import mathClientPart.demo.MathPortServiceLocator;
import mathClientPart.demo.MathPort_PortType;

public class MathClient {
  public static void main(String[] argv) {
    try {
      MathPortServiceLocator locator = new MathPortServiceLocator();

      MathPort_PortType service = locator.getMathPort();
      System.out.println(service.chooseCourse("44", "66"));
      System.out.println(service.findAllCourse("55"));
      System.out.println(service.findMyCourse("55"));
      System.out.println(service.login("44", "00"));
    } catch (javax.xml.rpc.ServiceException ex) {
      ex.printStackTrace();
    } catch (java.rmi.RemoteException ex) {
      ex.printStackTrace();
    }
  }
}
