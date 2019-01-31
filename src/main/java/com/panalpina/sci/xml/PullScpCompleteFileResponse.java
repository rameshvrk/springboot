package com.panalpina.sci.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "pullscpcompletefileResponse")
@XmlType(propOrder = { "pullScpCompleteFileReturn"})
public class PullScpCompleteFileResponse {

	//@XmlElement(name = "pullscpcompletefileReturn")
	private PullScpCompleteFileReturn pullScpCompleteFileReturn;

	public PullScpCompleteFileResponse() {
		
	}

	public PullScpCompleteFileResponse(PullScpCompleteFileReturn pullScpCompleteFileReturn) {
		this.pullScpCompleteFileReturn = pullScpCompleteFileReturn;
	}

	public PullScpCompleteFileReturn getPullScpCompleteFileReturn() {
		return pullScpCompleteFileReturn;
	}

	@XmlElement(name = "pullscpcompletefileReturn")
	public void setPullScpCompleteFileReturn(PullScpCompleteFileReturn pullScpCompleteFileReturn) {
		this.pullScpCompleteFileReturn = pullScpCompleteFileReturn;
	}

}
