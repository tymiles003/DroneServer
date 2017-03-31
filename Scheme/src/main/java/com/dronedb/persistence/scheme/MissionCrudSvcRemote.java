package com.dronedb.persistence.scheme.apis;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by oem on 3/24/17.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface MissionCrudSvcRemote {

    @WebMethod
    Mission cloneMission(@WebParam Mission mission);

}