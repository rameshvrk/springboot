package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_Language database table.
 * 
 */
@Entity
@Table(name="t_Language")
@NamedQuery(name="Language.findAll", query="SELECT t FROM Language t")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Language_ID", unique=true, nullable=false)
	private int languageID;

	@Column(name="Description", length=50)
	private String description;

	@Column(name="Language_Code", nullable=false, length=10)
	private String languageCode;

	@Column(name="Locale", nullable=false, length=20)
	private String locale;

	public Language() {
	}


	public int getLanguageID() {
		return languageID;
	}

	public void setLanguageID(int languageID) {
		this.languageID = languageID;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}