package com.solarvillage.permit.service;

import com.solarvillage.permit.model.Permit;

public interface PermitService {

	public Permit get(Long id);

	public Permit create(Permit permit);

	// public Permit update(Permit permit);

	public void delete(Long id);
}
