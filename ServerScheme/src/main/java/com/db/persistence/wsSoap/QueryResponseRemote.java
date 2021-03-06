package com.db.persistence.wsSoap;

import com.db.persistence.scheme.BaseObject;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class QueryResponseRemote implements Serializable {

	private List<BaseObject> resultList;
	
	public QueryResponseRemote() {
		resultList = new ArrayList<BaseObject>();
	}

	@Setter
	public void setResultList(List<? extends BaseObject> lst) {
		resultList.addAll(lst);
	}

	@Getter
//	@XmlElement(required = true)
	public List<BaseObject> getResultList() {
		return resultList;
	}
}
