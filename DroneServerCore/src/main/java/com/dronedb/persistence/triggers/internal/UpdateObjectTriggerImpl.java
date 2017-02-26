package com.dronedb.persistence.triggers.internal;

import org.springframework.context.ApplicationContext;

import com.dronedb.persistence.triggers.UpdateObjectTrigger;
import com.dronedb.persistence.triggers.UpdateTrigger;
import com.dronedb.persistence.triggers.UpdateTrigger.PHASE;
import com.dronedb.persistence.scheme.BaseObject;

public class UpdateObjectTriggerImpl implements UpdateObjectTrigger {

	@Override
	public <T extends BaseObject> void handleUpdateObject(T object, PHASE phase) {
		System.out.println("Int test " + object.toString());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		// TODO Auto-generated method stub
		
	}
}
