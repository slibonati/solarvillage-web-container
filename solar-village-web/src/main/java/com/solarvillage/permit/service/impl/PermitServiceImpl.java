package com.solarvillage.permit.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.solarvillage.permit.exception.PermitNotFoundException;
import com.solarvillage.permit.model.Permit;
import com.solarvillage.permit.model.Status;
import com.solarvillage.permit.model.Type;
import com.solarvillage.permit.service.PermitService;

@Service
public class PermitServiceImpl implements PermitService {

	private static Long id = 1L;

	private static Logger logger = LoggerFactory.getLogger(PermitServiceImpl.class);

	private Map<Long, Permit> repo = new HashMap<Long, Permit>();
	private Map<Long, Integer> getCount = new HashMap<Long, Integer>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.solarvillage.permit.service.PermitService#get(java.lang.Long)
	 */
	@Override
	public Permit get(Long id) throws PermitNotFoundException {

		Permit permit = repo.get(id);

		if (permit == null) {
			throw new PermitNotFoundException(id);
		}

		Integer count = getCount.get(id);

		logger.info("GET request for " + permit + " count " + count);

		if (count.intValue() == 0) { // mock statuses first time only
			mock(permit);
		}

		/*
		 * flipping status from in progress to approved if more than 1 get requests,
		 * simulates looping in process
		 */
		if (count > 1 && (permit.getStatus() == Status.IN_PROGRESS)) {
			permit.setStatus(Status.APPROVED);
		}

		getCount.put(id, ++count); // increment get counter

		return permit;

	}

	@Override
	public Permit create(Permit permit) {

		permit.setId(id);
		repo.put(permit.getId(), permit);

		getCount.put(id, 0); // initialize counter

		id++;
		return permit;
	}

	@Override
	public void delete(Long id) {
		repo.remove(id);
	}

	/**
	 * setting up some mock data to test process outcomes
	 * 
	 * @param permit
	 */
	public void mock(Permit permit) {

		permit.setStatus(Status.getRandomStatus());

		if (permit.getFirstName().equals("Freddy") && permit.getLastName().equals("Kreuger")) {
			if (permit.getType().equals(Type.ELECTRICAL)) {
				permit.setStatus(Status.DENIED);
			} else if (permit.getType().equals(Type.STRUCTURAL)) {
				permit.setStatus(Status.APPROVED);
			}
		}

		if (permit.getFirstName().equals("Hannibal") && permit.getLastName().equals("Lecter")) {
			if (permit.getType().equals(Type.ELECTRICAL)) {
				permit.setStatus(Status.APPROVED);
			} else if (permit.getType().equals(Type.STRUCTURAL)) {
				permit.setStatus(Status.DENIED);
			}
		}

		if (permit.getFirstName().equals("Michael") && permit.getLastName().equals("Meyers")) {
			permit.setStatus(Status.IN_PROGRESS);
		}

		if (permit.getFirstName().equals("Jason") && permit.getLastName().equals("Voorhees")) {
			permit.setStatus(Status.APPROVED);
		}
	}
}