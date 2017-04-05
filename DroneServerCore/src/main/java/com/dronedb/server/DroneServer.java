package com.dronedb.server;

import javax.xml.ws.Endpoint;

import com.dronedb.persistence.scheme.MissionCrudSvcRemote;
import com.dronedb.persistence.scheme.PerimeterCrudSvcRemote;
import org.springframework.stereotype.Component;

import com.dronedb.persistence.scheme.DroneDbCrudSvcRemote;
import com.dronedb.persistence.scheme.QuerySvcRemote;

@Component
public class DroneServer {
	

	public static void main(String[] args) {
		System.setProperty("javax.xml.bind.JAXBContext", "com.sun.xml.internal.bind.v2.ContextFactory"); 
		
		DroneDbCrudSvcRemote droneDbCrudSvcRemote 		= DroneDBServerAppConfig.context.getBean(DroneDbCrudSvcRemote.class);
		QuerySvcRemote querySvcRemote 					= DroneDBServerAppConfig.context.getBean(QuerySvcRemote.class);
		MissionCrudSvcRemote missionCrudSvcRemote 		= DroneDBServerAppConfig.context.getBean(MissionCrudSvcRemote.class);
		PerimeterCrudSvcRemote perimeterCrudSvcRemote 	= DroneDBServerAppConfig.context.getBean(PerimeterCrudSvcRemote.class);
		
		System.err.println("Sign " + DroneDbCrudSvcRemote.class.getSimpleName());
		Endpoint.publish("http://localhost:9999/ws/" + DroneDbCrudSvcRemote.class.getSimpleName(), droneDbCrudSvcRemote);
		
		System.err.println("Sign " + QuerySvcRemote.class.getSimpleName());
		Endpoint.publish("http://localhost:9999/ws/" + QuerySvcRemote.class.getSimpleName(), querySvcRemote);

		System.err.println("Sign " + MissionCrudSvcRemote.class.getSimpleName());
		Endpoint.publish("http://localhost:9999/ws/" + MissionCrudSvcRemote.class.getSimpleName(), missionCrudSvcRemote);

		System.err.println("Sign " + PerimeterCrudSvcRemote.class.getSimpleName());
		Endpoint.publish("http://localhost:9999/ws/" + PerimeterCrudSvcRemote.class.getSimpleName(), perimeterCrudSvcRemote);

	}

}
