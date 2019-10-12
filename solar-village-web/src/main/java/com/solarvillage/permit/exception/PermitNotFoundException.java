package com.solarvillage.permit.exception;

public class PermitNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7713635133438299714L;

	public PermitNotFoundException(Long id) {
		super("permit " + id + " not found");
	}
}