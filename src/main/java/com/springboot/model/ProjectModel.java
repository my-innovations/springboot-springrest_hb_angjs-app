package com.springboot.model;

public class ProjectModel {

	private String projectname;
	private String loc1;
	private String loc2;

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getLoc1() {
		return loc1;
	}

	public void setLoc1(String loc1) {
		this.loc1 = loc1;
	}

	public String getLoc2() {
		return loc2;
	}

	public void setLoc2(String loc2) {
		this.loc2 = loc2;
	}

	@Override
	public String toString() {
		return "ProjectModel [projectname=" + projectname + ", loc1=" + loc1 + ", loc2=" + loc2 + "]";
	}

}
