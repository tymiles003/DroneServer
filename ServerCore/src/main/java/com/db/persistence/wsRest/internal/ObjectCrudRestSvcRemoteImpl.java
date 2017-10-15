package com.db.persistence.wsRest.internal;

import com.db.persistence.exception.DatabaseValidationException;
import com.db.persistence.exception.ObjectInstanceException;
import com.db.persistence.remote_exception.DatabaseValidationRemoteException;
import com.db.persistence.remote_exception.ObjectInstanceRemoteException;
import com.db.persistence.remote_exception.ObjectNotFoundRemoteException;
import com.db.persistence.scheme.BaseObject;
import com.db.persistence.scheme.DummyBaseObject;
import com.db.persistence.services.ObjectCrudSvc;
import com.db.persistence.wsRest.ObjectCrudRestSvcRemote;
import javassist.tools.rmi.ObjectNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.UUID;

@RestController
public class ObjectCrudRestSvcRemoteImpl implements ObjectCrudRestSvcRemote
{
	final static Logger logger = Logger.getLogger(ObjectCrudRestSvcRemoteImpl.class);

	@Autowired
	private ObjectCrudSvc objectCrudSvc;
	
	@PostConstruct
	public void init() {
		Assert.notNull(objectCrudSvc,"Failed to initiate 'objectCrudSvc'");
		logger.debug("Remote Service is up !" + this.getClass().getSimpleName());
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@ResponseBody
	public <T extends BaseObject> ResponseEntity<T> create(@RequestParam String clz)  throws ObjectInstanceRemoteException {
		logger.debug("Crud REMOTE CREATE called '" + clz + "'");
		try {
			T t = (T) objectCrudSvc.create(clz).copy();
			logger.debug("TALMA Crud REMOTE CREATE called " + t);
			return new ResponseEntity<T>(t, HttpStatus.OK);
		}
		catch (ObjectInstanceException e) {
			logger.error("Failed to create object", e);
			throw new ObjectInstanceRemoteException("Failed to create object");
		}
	}

	@Override
	@RequestMapping(value = "/update", method = RequestMethod.POST
					,consumes={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public <T extends BaseObject> ResponseEntity<T> update(@RequestBody T object) throws DatabaseValidationRemoteException, ObjectInstanceRemoteException{

		logger.debug("Crud REMOTE UPDATE called, type: " + object.getClass().getCanonicalName() + ", object: " + object);
		try {
			T obj = objectCrudSvc.update(object);
			return new ResponseEntity<T>((T) obj.copy(), HttpStatus.OK);
		}
		catch (DatabaseValidationException e) {
			logger.error("Failed to update object, reason: ", e);
			throw new DatabaseValidationRemoteException("Failed to update object, " + e.getMessage());
		}
		catch (ObjectInstanceException e) {
			logger.error("Failed to create object, reason: ", e);
			throw new ObjectInstanceRemoteException("Failed to create object, " + e.getMessage());
		}
	}

	@Override
	@RequestMapping(value = "/updateArray", method = RequestMethod.POST)
	@ResponseBody
	public <T extends BaseObject> void updateArray(@RequestBody T[] objects) throws DatabaseValidationRemoteException, ObjectInstanceRemoteException {
		try {
			objectCrudSvc.updateArray(objects);
		}
		catch (DatabaseValidationException e) {
			logger.error("Failed to update object", e);
			throw new DatabaseValidationRemoteException("Failed to update object, " + e.getMessage());
		}
		catch (ObjectInstanceException e) {
			logger.error("Failed to update object", e);
			throw new ObjectInstanceRemoteException("Failed to update object, " + e.getMessage());
		}
	}

	@Override
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public <T extends BaseObject> ResponseEntity delete(@RequestBody T object) throws ObjectInstanceRemoteException, DatabaseValidationRemoteException, ObjectNotFoundRemoteException {
		try {
			T obj = objectCrudSvc.delete(object);
			return new ResponseEntity(obj.copy(), HttpStatus.OK);
		}
		catch (DatabaseValidationException e) {
			logger.error("Failed to delete object", e);
			throw new DatabaseValidationRemoteException("Failed to delete object, " + e.getMessage());
		}
		catch (ObjectInstanceException e) {
			logger.error("Failed to delete object", e);
			throw new ObjectInstanceRemoteException("Failed to delete object, " + e.getMessage());
		}
		catch (ObjectNotFoundException e) {
			logger.error("Failed to delete object", e);
			throw new ObjectNotFoundRemoteException("Failed to delete object, " + e.getMessage());
		}
	}

	@Override
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@ResponseBody
	public <T extends BaseObject> ResponseEntity<T> read(@RequestParam UUID objId) throws ObjectNotFoundRemoteException {
		try {
			logger.debug("Crud REMOTE READ called " + objId);
			BaseObject object = objectCrudSvc.read(objId);
			if (object == null) {
				logger.error("Failed to find object '" + objId + "'");
				throw new ObjectNotFoundRemoteException("Failed to find object '" + objId + "'");
			}
			return new ResponseEntity<T>((T) object.copy(), HttpStatus.OK);
		}
		catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundRemoteException(e.getMessage());
		}
	}

	@Override
	@RequestMapping(value = "/readByClass", method = RequestMethod.GET)
	@ResponseBody
	public <T extends BaseObject> ResponseEntity<T> readByClass(@RequestParam UUID objId, @RequestParam String clz) throws ObjectNotFoundRemoteException {

		try {
			logger.debug("Crud REMOTE READ called '" + objId + "', class '" + clz + "'");
			T object = objectCrudSvc.readByClass(objId, (Class<T>) Class.forName(clz));

			if (object == null) {
				logger.error("Failed to find object '" + objId + "'");
				throw new ObjectNotFoundRemoteException("Failed to find object '" + objId + "'");
			}
			return new ResponseEntity<T>((T) object.copy(), HttpStatus.OK);
		}
		catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundRemoteException(e.getMessage());
		}
		catch (ClassNotFoundException e) {
			throw new ObjectNotFoundRemoteException("Failed to find class type '" + clz + "', " + e.getMessage());
		}
	}
}