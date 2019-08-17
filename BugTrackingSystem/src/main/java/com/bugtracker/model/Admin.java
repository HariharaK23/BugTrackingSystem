package com.bugtracker.model;

public class Admin {
	private String adminEmail;
	private String adminPassword;
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "Admin [adminEmail=" + adminEmail + ", adminPassword=" + adminPassword + "]";
	}
	
	
}
