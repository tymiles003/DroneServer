
package com.dronedb.persistence.ws.internal;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "DatabaseRemoteValidationException", targetNamespace = "http://scheme.persistence.dronedb.com/")
public class DatabaseRemoteValidationException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private com.dronedb.persistence.scheme.DatabaseRemoteValidationException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public DatabaseRemoteValidationException(String message, com.dronedb.persistence.scheme.DatabaseRemoteValidationException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public DatabaseRemoteValidationException(String message, com.dronedb.persistence.scheme.DatabaseRemoteValidationException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.dronedb.persistence.scheme.DatabaseRemoteValidationException
     */
    public com.dronedb.persistence.scheme.DatabaseRemoteValidationException getFaultInfo() {
        return faultInfo;
    }

}
