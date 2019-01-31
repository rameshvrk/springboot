package com.panalpina.sci.xml;

import javax.xml.bind.annotation.XmlElement;

public class Filetxt {

	private String txtid;
	
	private String fileid;

	public Filetxt() {
		
	}

	public String getTxtid() {
		return txtid;
	}

	@XmlElement()
	public void setTxtid(String txtid) {
		this.txtid = txtid;
	}

	public String getFileid() {
		return fileid;
	}

	@XmlElement()
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

}
