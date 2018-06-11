/**
 * CommercialPortServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package commercialClientPart.demo;

import java.net.URL;
import java.rmi.Remote;

public class CommercialPortServiceLocator extends org.apache.axis.client.Service implements CommercialPortService {

    public CommercialPortServiceLocator() {
    }


    public CommercialPortServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CommercialPortServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CommercialPort
    private String CommercialPort_address = "http://localhost:8082//services/port/CommercialPort";

    public String getCommercialPortAddress() {
        return CommercialPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String CommercialPortWSDDServiceName = "CommercialPort";

    public String getCommercialPortWSDDServiceName() {
        return CommercialPortWSDDServiceName;
    }

    public void setCommercialPortWSDDServiceName(String name) {
        CommercialPortWSDDServiceName = name;
    }

    public CommercialPort_PortType getCommercialPort() throws javax.xml.rpc.ServiceException {
       URL endpoint;
        try {
            endpoint = new URL(CommercialPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCommercialPort(endpoint);
    }

    public CommercialPort_PortType getCommercialPort(URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            CommercialPortSoapBindingStub _stub = new CommercialPortSoapBindingStub(portAddress, this);
            _stub.setPortName(getCommercialPortWSDDServiceName());
            return (CommercialPort_PortType) _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCommercialPortEndpointAddress(String address) {
        CommercialPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (CommercialPort_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                CommercialPortSoapBindingStub _stub = new CommercialPortSoapBindingStub(new URL(CommercialPort_address), this);
                _stub.setPortName(getCommercialPortWSDDServiceName());
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
    public Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("CommercialPort".equals(inputPortName)) {
            return getCommercialPort();
        }
        else  {
            Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://port", "CommercialPortService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://port", "CommercialPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("CommercialPort".equals(portName)) {
            setCommercialPortEndpointAddress(address);
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
