package com.springboot.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "JoinTableProjectEntity")
@Table(name = "Project", uniqueConstraints = { @UniqueConstraint(columnNames = "PID"),
		@UniqueConstraint(columnNames = "PNAME") })
public class Project {

	private Long projectID;
	private String projectName;
	private Set<OfficeLocation> offices;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PID", unique = true, nullable = false)
	public Long getProjectID() {
		return projectID;
	}

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	@Column(name = "PNAME", unique = false, nullable = false)
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PROJECT_OFFICE", joinColumns = {
			@JoinColumn(name = "PROJECT_ID", referencedColumnName = "PID") }, inverseJoinColumns = {
					@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OID") })
	public Set<OfficeLocation> getOffices() {
		return offices;
	}

	public void setOffices(Set<OfficeLocation> offices) {
		this.offices = offices;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectID + ", projectName=" + projectName + ", offices=" + offices + "]";
	}

}
