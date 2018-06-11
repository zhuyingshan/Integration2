/**
 * MathPort_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mathClientPart.demo;

public interface MathPort_PortType extends java.rmi.Remote {
    public String findAllCourse(String empty) throws java.rmi.RemoteException;
    public String login(String studentid, String name) throws java.rmi.RemoteException;
    public String chooseCourse(String id, String courseid) throws java.rmi.RemoteException;
    public String findMyCourse(String myid) throws java.rmi.RemoteException;
}
