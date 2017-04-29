
package com.dronedb.persistence.ws.internal;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import com.dronedb.persistence.scheme.BaseObject;
import com.dronedb.persistence.scheme.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DroneDbCrudSvcRemote", targetNamespace = "http://scheme.persistence.dronedb.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DroneDbCrudSvcRemote {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "CheckConnection")
    @WebResult(partName = "return")
    @Action(input = "http://scheme.persistence.dronedb.com/DroneDbCrudSvcRemote/CheckConnectionRequest", output = "http://scheme.persistence.dronedb.com/DroneDbCrudSvcRemote/CheckConnectionResponse")
    public String checkConnection();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.dronedb.persistence.scheme.BaseObject
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://scheme.persistence.dronedb.com/DroneDbCrudSvcRemote/readByClassRequest", output = "http://scheme.persistence.dronedb.com/DroneDbCrudSvcRemote/readByClassResponse")
    public BaseObject readByClass(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.dronedb.persistence.scheme.BaseObject
     * @throws DatabaseRemoteValidationException
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://scheme.persistence.dronedb.com/DroneDbCrudSvcRemote/updateRequest", output = "http://scheme.persistence.dronedb.com/DroneDbCrudSvcRemote/updateResponse", fault = {
        @FaultAction(className = DatabaseRemoteValidationException.class, value = "http://scheme.persistence.dronedb.com/DroneDbCrudSvcRemote/update/Fault/DatabaseRemoteValidationException")
    })
    public BaseObject update(
        @WebParam(name = "arg0", partName = "arg0")
        BaseObject arg0)
        throws DatabaseRemoteValidationException
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns com.dronedb.persistence.scheme.BaseObject
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://scheme.persistence.dronedb.com/DroneDbCrudSvcRemote/readRequest", output = "http://scheme.persistence.dronedb.com/DroneDbCrudSvcRemote/readResponse")
    public BaseObject read(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://scheme.persistence.dronedb.com/DroneDbCrudSvcRemote/deleteRequest", output = "http://scheme.persistence.dronedb.com/DroneDbCrudSvcRemote/deleteResponse")
    public void delete(
        @WebParam(name = "arg0", partName = "arg0")
        BaseObject arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.dronedb.persistence.scheme.BaseObject
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://scheme.persistence.dronedb.com/DroneDbCrudSvcRemote/createRequest", output = "http://scheme.persistence.dronedb.com/DroneDbCrudSvcRemote/createResponse")
    public BaseObject create(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}
