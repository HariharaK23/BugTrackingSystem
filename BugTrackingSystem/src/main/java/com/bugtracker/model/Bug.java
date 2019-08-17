package com.bugtracker.model;

public class Bug {
	private String bugName;
	private String bugCoder;
	private String bugTester;
	private String bugProject;
	private String bugStatus ;
	private String bugSolution ;
	public String getBugName() {
		return bugName;
	}
	public void setBugName(String bugName) {
		this.bugName = bugName;
	}
	public String getBugCoder() {
		return bugCoder;
	}
	public void setBugCoder(String bugCoder) {
		this.bugCoder = bugCoder;
	}
	public String getBugTester() {
		return bugTester;
	}
	public void setBugTester(String bugTester) {
		this.bugTester = bugTester;
	}
	public String getBugProject() {
		return bugProject;
	}
	public void setBugProject(String bugProject) {
		this.bugProject = bugProject;
	}
	public String getBugStatus() {
		return bugStatus;
	}
	public void setBugStatus(String bugStatus) {
		this.bugStatus = bugStatus;
	}
	public String getBugSolution() {
		return bugSolution;
	}
	public void setBugSolution(String bugSolution) {
		this.bugSolution = bugSolution;
	}
	@Override
	public String toString() {
		return "Bug [bugName=" + bugName + ", bugCoder=" + bugCoder + ", bugTester=" + bugTester + ", bugProject="
				+ bugProject + ", bugStatus=" + bugStatus + ", bugSolution=" + bugSolution + "]";
	}
	
	

}
