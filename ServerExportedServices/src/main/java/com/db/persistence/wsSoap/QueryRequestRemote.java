package com.db.persistence.wsSoap;

import com.db.persistence.PluginManifest;
import com.db.persistence.scheme.BaseObject;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@PluginManifest.WSImporter
@XmlRootElement
public class QueryRequestRemote {
	
	protected String query;
	
	private String clz;
		
	private Map<String, String> params;

	public QueryRequestRemote() {
		params = new HashMap();
	}
	
	@Setter
	public void setClz(String clz) {
		this.clz = clz;
	}
	
	@Getter
	@XmlElement(required = true)	
	public String getClz() {
		return clz;
	}
	
	@Setter
	public void setQuery(String query) {
		this.query = query;
	}
	
	@Getter
	@XmlElement(required = true)
	public String getQuery() {
		return this.query;
	}
	
	public void addParameter(String param) {
		params.put(params.size() + "",param);
	}
	
	public void addParameter(String paramName, String param) {
		params.put(paramName, param);
	}
	
	@Getter
	@XmlElement
	public Map<String, String> getParameters() {
		return params;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [ Query=" + query + ", Clz=" + clz + ", Parameters=" + params.toString() + " ]";
	}
}
