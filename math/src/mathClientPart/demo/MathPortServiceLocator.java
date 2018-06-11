/**
 * MathPortServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mathClientPart.demo;

import java.net.URL;
import java.rmi.Remote;

public class MathPortServiceLocator extends org.apache.axis.client.Service implements MathPortService {

    public MathPortServiceLocator() {
    }


    public MathPortServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MathPortServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MathPort
    private String MathPort_address = "http://localhost:8081//services/port/MathPort";

    public String getMathPortAddress() {
        return MathPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String MathPortWSDDServiceName = "MathPort";

    public String getMathPortWSDDServiceName() {
        return MathPortWSDDServiceName;
    }

    public void setMathPortWSDDServiceName(String name) {
        MathPortWSDDServiceName = name;
    }

    public MathPort_PortType getMathPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MathPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMathPort(endpoint);
    }

    public MathPort_PortType getMathPort(URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            MathPortSoapBindingStub _stub = new MathPortSoapBindingStub(portAddress, this);
            _stub.setPortName(getMathPortWSDDServiceName());
            return (MathPort_PortType) _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMathPortEndpointAddress(String address) {
        MathPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (MathPort_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                MathPortSoapBindingStub _stub = new MathPortSoapBindingStub(new java.net.URL(MathPort_address), this);
                _stub.setPortName(getMathPortWSDDServiceName());
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
        if ("MathPort".equals(inputPortName)) {
            return getMathPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://port", "MathPortService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://port", "MathPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("MathPort".equals(portName)) {
            setMathPortEndpointAddress(address);
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
