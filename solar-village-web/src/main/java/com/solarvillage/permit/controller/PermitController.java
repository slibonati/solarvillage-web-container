package com.solarvillage.permit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.solarvillage.permit.model.Permit;
import com.solarvillage.permit.service.PermitService;

@RestController
public class PermitController {

	@Autowired
	private PermitService permitService;

	@GetMapping("${context-path}/permits/{id}")
	public Permit get(@PathVariable Long id) {
		return permitService.get(id);
	}

	@PostMapping("${context-path}/permits")
	Permit newPermit(@RequestBody Permit permit) {
		return permitService.create(permit);

	}

	@DeleteMapping("${context-path}/permits/{id}")
	void deletePermit(@PathVariable Long id) {
		permitService.delete(id);
	}

}
