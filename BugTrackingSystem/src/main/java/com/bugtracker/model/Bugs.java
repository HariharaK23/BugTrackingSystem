package com.bugtracker.model;

public class Bugs {
	String bug_name;
	int bug_projectId;
	String bug_developerName;
	String bug_testerName;
	int bug_statusId;
	String solution;
	public String getBug_name() {
		return bug_name;
	}
	public void setBug_name(String bug_name) {
		this.bug_name = bug_name;
	}
	public int getBug_projectId() {
		return bug_projectId;
	}
	public String getBug_developerName() {
		return bug_developerName;
	}
	public void setBug_developerName(String bug_developerName) {
		this.bug_developerName = bug_developerName;
	}
	public String getBug_testerName() {
		return bug_testerName;
	}
	public void setBug_testerName(String bug_testerName) {
		this.bug_testerName = bug_testerName;
	}
	public int getBug_statusId() {
		return bug_statusId;
	}
	public void setBug_statusId(int bug_statusId) {
		this.bug_statusId = bug_statusId;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	@Override
	public String toString() {
		return "Bugs [bug_name=" + bug_name + ", bug_projectId=" + bug_projectId + ", bug_developerName="
				+ bug_developerName + ", bug_testerName=" + bug_testerName + ", bug_statusId=" + bug_statusId
				+ ", solution=" + solution + "]";
	}
	public void setBug_projectId(int bug_projectId2) {
		this.bug_projectId=bug_projectId2;
		
	}
	
	
	

}
