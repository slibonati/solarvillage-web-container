package com.solarvillage.permit.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.solarvillage.permit.exception.PermitNotFoundException;
import com.solarvillage.permit.model.Permit;
import com.solarvillage.permit.model.Status;
import com.solarvillage.permit.service.PermitService;

@Service
public class PermitServiceImpl implements PermitService {

	private static Long id = 1L;

	private Map<Long, Permit> repo = new HashMap<Long, Permit>();

	@Override
	public Permit get(Long id) throws PermitNotFoundException {
		
		Permit permit = repo.get(id);
		
		if (permit == null) {
			throw new PermitNotFoundException(id);
		}
		
		if (permit.getStatus().equals(Status.IN_PROGRESS)) {
			// TODO implement
		}		
		
		return permit;

	}

	@Override
	public Permit create(Permit permit) {
		permit.setId(id++);
		permit.setStatus(Status.getRandomStatus());
		repo.put(permit.getId(), permit);
		return permit;
	}
/*
	@Override
	public Permit update(Permit permit) {
		
		try {
			get(permit.getId())
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Permit updated = new Permit();
		updated.setFirstName(firstName);
		updated.setLastName(lastName);
		updated.setEmail(email);
		updated.setProjectDescription(projectDescription);
		
		updated.setId(id);
		updated.setStatus(status);
		
		
		repo.put(permit.getId(), permit);
		return permit;
	}
*/
	@Override
	public void delete(Long id) {
		repo.remove(id);

	}

}
