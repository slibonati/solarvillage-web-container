package com.solarvillage.permit.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Permit implements Serializable {

	private static final long serialVersionUID = -2069803395277247026L;
	
	private Long id;
	private Type type;
	private String firstName;
	private String lastName;
	private String email;
	private String projectDescription;

	private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
