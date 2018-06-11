package commercialClientPart.example;

import commercialClientPart.demo.CommercialPortServiceLocator;
import commercialClientPart.demo.CommercialPort_PortType;

public class CommercialClient {
  public static void main(String[] argv) {
    try {
      CommercialPortServiceLocator locator = new CommercialPortServiceLocator();

      CommercialPort_PortType service = locator.getCommercialPort();

      System.out.println(service.login("44", "77"));
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
