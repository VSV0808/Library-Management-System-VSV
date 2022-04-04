package com.vsv.libManagSys.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LibAdmins {
	
	@Id
	private int adminId;
	private String adminName;
	
	
	
	
	
	public int getAdminId() {
		return adminId;
	}



	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}



	public String getAdminName() {
		return adminName;
	}



	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}



	public LibAdmins(int adminId, String adminName) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
	}
	
	



	public LibAdmins() {
		super();
	}



	@Override
	public String toString() {
		return "LibAdmins [adminId=" + adminId + ", adminName=" + adminName + "]";
	}
	
	

}
