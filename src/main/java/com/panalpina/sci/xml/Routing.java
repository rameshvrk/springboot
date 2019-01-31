package com.panalpina.sci.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(namespace = "com.panalpina.sci.xml.PullScpCompleteFileReturn")
public class Routing {


	private String routid;
	
	private String fileid;

	public Routing()
	{
		
	}

	public String getRoutid() {
		return routid;
	}

	@XmlElement()
	public void setRoutid(String routid) {
		this.routid = routid;
	}

	public String getFileid() {
		return fileid;
	}

	@XmlElement()
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	
}
