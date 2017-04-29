package com.dronedb.tester;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.dronedb.persistence.ws.internal.DroneDbCrudSvcRemote;
import com.dronedb.persistence.ws.internal.QuerySvcRemote;
import com.dronedb.persistence.ws.internal.SessionsSvcRemote;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig
{

	public static ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	private static <T> T LoadServices(Class<T> clz) {
		try {
			System.err.println("Got " + clz.getSimpleName());
			URL url = new URL("http://localhost:9999/ws/" + clz.getSimpleName() + "?wsdl");
			QName qName = new QName("http://internal.ws.persistence.dronedb.com/", clz.getSimpleName() + "ImplService");
			Service service = Service.create(url, qName);
			return service.getPort(clz);
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Bean
	public DroneDbCrudSvcRemote droneDbCrudSvcRemote() {
		return LoadServices(DroneDbCrudSvcRemote.class);
	}
	
	@Bean
	public QuerySvcRemote querySvcRemote() {
		return LoadServices(QuerySvcRemote.class);
	}

	@Bean
	public SessionsSvcRemote sessionsSvcRemote() {
		return LoadServices(SessionsSvcRemote.class);
	}

}
