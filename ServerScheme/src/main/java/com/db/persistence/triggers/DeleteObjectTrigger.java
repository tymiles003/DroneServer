package com.db.persistence.triggers;

import org.springframework.context.ApplicationContext;

import com.db.persistence.scheme.BaseObject;

public interface DeleteObjectTrigger {
	
	public <T extends BaseObject> void handleDeleteObject(T object) throws Exception;
	
	public void setApplicationContext(ApplicationContext applicationContext);

}
