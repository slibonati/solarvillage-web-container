package com.solarvillage.permit.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.solarvillage.permit.exception.PermitNotFoundException;
import com.solarvillage.permit.model.PermitNotFoundResponse;

@ControllerAdvice
class PermitNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(PermitNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	PermitNotFoundResponse permitNotFoundHandler(PermitNotFoundException ex) {
		return new PermitNotFoundResponse(new Date(), ex.getMessage());
	}
}
