/**
 * CommercialPortService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package commercialClientPart.demo;

import java.net.URL;

public interface CommercialPortService extends javax.xml.rpc.Service {
    public String getCommercialPortAddress();

    public CommercialPort_PortType getCommercialPort() throws javax.xml.rpc.ServiceException;

    public CommercialPort_PortType getCommercialPort(URL portAddress) throws javax.xml.rpc.ServiceException;
}
