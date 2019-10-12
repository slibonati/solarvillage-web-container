package com.solarvillage.permit.model;

public enum Type {

	ELECTRICAL("electrical"), STRUCTURAL("structural");

	private String string;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	private Type(String string) {
		this.string = string;
	}

}
