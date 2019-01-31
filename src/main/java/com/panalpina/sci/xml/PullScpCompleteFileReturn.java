package com.panalpina.sci.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "com.panalpina.sci.xml.PullScpCompleteFileResponse")
@XmlType(propOrder = { "filetxts","routings"})
public class PullScpCompleteFileReturn {

	private List<Routing> routings;
	
	private List<Filetxt> filetxts;

	public PullScpCompleteFileReturn() {
		
	}

	public List<Routing> getRoutings() {
		return routings;
	}

	@XmlElementWrapper(name = "routing")
	@XmlElement(name = "Routing")
	public void setRoutings(List<Routing> routings) {
		this.routings = routings;
	}

	public List<Filetxt> getFiletxts() {
		return filetxts;
	}

	@XmlElementWrapper(name = "filetxt")
	@XmlElement(name = "Filetxt")
	public void setFiletxts(List<Filetxt> filetxts) {
		this.filetxts = filetxts;
	}

}
