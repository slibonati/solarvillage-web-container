package com.solarvillage.permit.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Order implements Serializable {

	private static final long serialVersionUID = -3294337487195111795L;

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String projectDescription;

	private Permit electricalPermit;
	private Permit structuralPermit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Permit getElectricalPermit() {
		return electricalPermit;
	}

	public void setElectricalPermit(Permit electricalPermit) {
		this.electricalPermit = electricalPermit;
	}

	public Permit getStructuralPermit() {
		return structuralPermit;
	}

	public void setStructuralPermit(Permit structuralPermit) {
		this.structuralPermit = structuralPermit;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}