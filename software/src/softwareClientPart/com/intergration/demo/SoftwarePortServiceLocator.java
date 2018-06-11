/**
 * SoftwarePortServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package softwareClientPart.com.intergration.demo;

import java.net.URL;
import java.rmi.Remote;

public class SoftwarePortServiceLocator extends org.apache.axis.client.Service implements SoftwarePortService {

    public SoftwarePortServiceLocator() {
    }


    public SoftwarePortServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SoftwarePortServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SoftwarePort
    private String SoftwarePort_address = "http://localhost:8080//services/port/SoftwarePort";

    public String getSoftwarePortAddress() {
        return SoftwarePort_address;
    }

    // The WSDD service name defaults to the port name.
    private String SoftwarePortWSDDServiceName = "SoftwarePort";

    public String getSoftwarePortWSDDServiceName() {
        return SoftwarePortWSDDServiceName;
    }

    public void setSoftwarePortWSDDServiceName(String name) {
        SoftwarePortWSDDServiceName = name;
    }

    public SoftwarePort_PortType getSoftwarePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SoftwarePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSoftwarePort(endpoint);
    }

    public SoftwarePort_PortType getSoftwarePort(URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            SoftwarePortSoapBindingStub _stub = new SoftwarePortSoapBindingStub(portAddress, this);
            _stub.setPortName(getSoftwarePortWSDDServiceName());
            return (SoftwarePort_PortType) _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSoftwarePortEndpointAddress(String address) {
        SoftwarePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (SoftwarePort_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                SoftwarePortSoapBindingStub _stub = new SoftwarePortSoapBindingStub(new java.net.URL(SoftwarePort_address), this);
                _stub.setPortName(getSoftwarePortWSDDServiceName());
                return (Remote) _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("SoftwarePort".equals(inputPortName)) {
            return getSoftwarePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://port", "SoftwarePortService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://port", "SoftwarePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("SoftwarePort".equals(portName)) {
            setSoftwarePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
