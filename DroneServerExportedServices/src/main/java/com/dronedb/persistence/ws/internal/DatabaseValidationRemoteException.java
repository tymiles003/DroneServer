
package com.dronedb.persistence.ws.internal;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "DatabaseValidationRemoteException", targetNamespace = "http://scheme.persistence.dronedb.com/")
public class DatabaseValidationRemoteException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private com.dronedb.persistence.scheme.DatabaseValidationRemoteException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public DatabaseValidationRemoteException(String message, com.dronedb.persistence.scheme.DatabaseValidationRemoteException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public DatabaseValidationRemoteException(String message, com.dronedb.persistence.scheme.DatabaseValidationRemoteException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.dronedb.persistence.scheme.DatabaseValidationRemoteException
     */
    public com.dronedb.persistence.scheme.DatabaseValidationRemoteException getFaultInfo() {
        return faultInfo;
    }

}