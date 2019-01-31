package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_Role database table.
 * 
 */
@Entity
@Table(name="t_Role")
@NamedQuery(name="Role.findAll", query="SELECT t FROM Role t")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="Role_ID", unique=true, nullable=false)
	private int roleID;
	
	@Column(name="Description", length=50)
	private String description;

	@Column(name="Role_Name", length=20)
	private String roleName;
	
	public Role() {
	}
	
	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}