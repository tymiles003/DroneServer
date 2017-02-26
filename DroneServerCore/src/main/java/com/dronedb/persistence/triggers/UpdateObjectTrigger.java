package com.dronedb.persistence.triggers;

import org.springframework.context.ApplicationContext;

import com.dronedb.persistence.triggers.UpdateTrigger.PHASE;
import com.dronedb.persistence.scheme.BaseObject;

public interface UpdateObjectTrigger {
	
	public <T extends BaseObject> void handleUpdateObject(T object, PHASE phase);
	
	public void setApplicationContext(ApplicationContext applicationContext);

}
