/**
 * SoftwarePortService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package softwareClientPart.com.intergration.demo;

import java.net.URL;

public interface SoftwarePortService extends javax.xml.rpc.Service {
    public String getSoftwarePortAddress();

    public SoftwarePort_PortType getSoftwarePort() throws javax.xml.rpc.ServiceException;

    public SoftwarePort_PortType getSoftwarePort(URL portAddress) throws javax.xml.rpc.ServiceException;
}
