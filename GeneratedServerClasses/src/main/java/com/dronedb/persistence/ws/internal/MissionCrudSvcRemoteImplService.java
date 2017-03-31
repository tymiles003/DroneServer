
package com.dronedb.persistence.ws.internal;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MissionCrudSvcRemoteImplService", targetNamespace = "http://internal.ws.persistence.dronedb.com/", wsdlLocation = "http://localhost:9999/ws/MissionCrudSvcRemote?wsdl")
public class MissionCrudSvcRemoteImplService
    extends Service
{

    private final static URL MISSIONCRUDSVCREMOTEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException MISSIONCRUDSVCREMOTEIMPLSERVICE_EXCEPTION;
    private final static QName MISSIONCRUDSVCREMOTEIMPLSERVICE_QNAME = new QName("http://internal.ws.persistence.dronedb.com/", "MissionCrudSvcRemoteImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9999/ws/MissionCrudSvcRemote?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MISSIONCRUDSVCREMOTEIMPLSERVICE_WSDL_LOCATION = url;
        MISSIONCRUDSVCREMOTEIMPLSERVICE_EXCEPTION = e;
    }

    public MissionCrudSvcRemoteImplService() {
        super(__getWsdlLocation(), MISSIONCRUDSVCREMOTEIMPLSERVICE_QNAME);
    }

    public MissionCrudSvcRemoteImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MISSIONCRUDSVCREMOTEIMPLSERVICE_QNAME, features);
    }

    public MissionCrudSvcRemoteImplService(URL wsdlLocation) {
        super(wsdlLocation, MISSIONCRUDSVCREMOTEIMPLSERVICE_QNAME);
    }

    public MissionCrudSvcRemoteImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MISSIONCRUDSVCREMOTEIMPLSERVICE_QNAME, features);
    }

    public MissionCrudSvcRemoteImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MissionCrudSvcRemoteImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MissionCrudSvcRemote
     */
    @WebEndpoint(name = "MissionCrudSvcRemoteImplPort")
    public MissionCrudSvcRemote getMissionCrudSvcRemoteImplPort() {
        return super.getPort(new QName("http://internal.ws.persistence.dronedb.com/", "MissionCrudSvcRemoteImplPort"), MissionCrudSvcRemote.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MissionCrudSvcRemote
     */
    @WebEndpoint(name = "MissionCrudSvcRemoteImplPort")
    public MissionCrudSvcRemote getMissionCrudSvcRemoteImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://internal.ws.persistence.dronedb.com/", "MissionCrudSvcRemoteImplPort"), MissionCrudSvcRemote.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MISSIONCRUDSVCREMOTEIMPLSERVICE_EXCEPTION!= null) {
            throw MISSIONCRUDSVCREMOTEIMPLSERVICE_EXCEPTION;
        }
        return MISSIONCRUDSVCREMOTEIMPLSERVICE_WSDL_LOCATION;
    }

}