/**
 * MathPortService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mathClientPart.demo;

import java.net.URL;

public interface MathPortService extends javax.xml.rpc.Service {
    public String getMathPortAddress();

    public MathPort_PortType getMathPort() throws javax.xml.rpc.ServiceException;

    public MathPort_PortType getMathPort(URL portAddress) throws javax.xml.rpc.ServiceException;
}
