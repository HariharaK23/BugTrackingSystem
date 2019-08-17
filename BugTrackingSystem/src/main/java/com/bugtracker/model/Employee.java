package com.bugtracker.model;

public class Employee {
	private String employeeEmail;
	private String employeePassword;
	private String employeeName;
	private String employeeDesignation;
	private long employeePhone;
	private int employeeProjectId;
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public long getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(long employeePhone) {
		this.employeePhone = employeePhone;
	}
	public int getEmployeeProjectId() {
		return employeeProjectId;
	}
	public void setEmployeeProjectId(int employeeProjectId) {
		this.employeeProjectId = employeeProjectId;
	}
	@Override
	public String toString() {
		return "Employee [employeeEmail=" + employeeEmail + ", employeePassword=" + employeePassword + ", employeeName="
				+ employeeName + ", employeeDesignation=" + employeeDesignation + ", employeePhone=" + employeePhone
				+ ", employeeProjectId=" + employeeProjectId + "]";
	}
	
	

}
