package com.bugtracker.model;


public class Employee {
	 String EmployeeEmail;
	 String EmployeePassword;
	 String EmployeeName;
	 String EmployeeDesignation;
	 int EmployeeProjectId;
	 Long EmployeePhone;
	
	public String getEmployeeEmail() {
		return EmployeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		EmployeeEmail = employeeEmail;
	}
	public String getEmployeePassword() {
		return EmployeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		EmployeePassword = employeePassword;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getEmployeeDesignation() {
		return EmployeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		EmployeeDesignation = employeeDesignation;
	}
	public int getEmployeeProjectId() {
		return EmployeeProjectId;
	}
	public void setEmployeeProjectId(int employeeProjectId) {
		EmployeeProjectId = employeeProjectId;
	}
	public Long getEmployeePhone() {
		return EmployeePhone;
	}
	public void setEmployeePhone(Long employeePhone) {
		EmployeePhone = employeePhone;
	}
	@Override
	public String toString() {
		return "Employee [EmployeeEmail=" + EmployeeEmail + ", EmployeePassword=" + EmployeePassword + ", EmployeeName="
				+ EmployeeName + ", EmployeeDesignation=" + EmployeeDesignation + ", EmployeeProjectId="
				+ EmployeeProjectId + ", EmployeePhone=" + EmployeePhone + "]";
	}
	
	
	
	
	
}