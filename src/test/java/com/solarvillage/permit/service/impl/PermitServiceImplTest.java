package com.solarvillage.permit.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.solarvillage.permit.model.Permit;
import com.solarvillage.permit.model.Status;
import com.solarvillage.permit.service.PermitService;

class PermitServiceImplTest {

	private PermitService permitService = new PermitServiceImpl();

	@Test
	void testGet() {
		
		Permit permit = new Permit();
		permit.setFirstName("Michael");
		permit.setLastName("Meyers");
		
		
		Permit result = permitService.create(permit);
		
		assertNotNull(permitService.get(result.getId()));
		assertEquals(permit.getFirstName(), result.getFirstName());
		assertEquals(permit.getLastName(), result.getLastName());
		
		permitService.delete(result.getId());
	}
	
	
	@Test
	void testFlippingInProgressToApproved() {
		
		Permit permit = new Permit();
		permit.setFirstName("Michael");
		permit.setLastName("Meyers");
		
		
		Permit result = permitService.create(permit);
		assertNotNull(result);
		result = permitService.get(result.getId()); //first 
		assertNotNull(result);
		assertEquals(permit.getFirstName(), result.getFirstName());
		assertEquals(permit.getLastName(), result.getLastName());
		
		assertEquals(result.getStatus(), Status.IN_PROGRESS);
		
		result = permitService.get(result.getId()); //second
		
		assertNotNull(result);
		assertEquals(result.getStatus(), Status.IN_PROGRESS);
		
		result = permitService.get(result.getId()); //third
		
		assertNotNull(result);
		assertEquals(result.getStatus(), Status.APPROVED);
		
		permitService.delete(result.getId());
	}

}
