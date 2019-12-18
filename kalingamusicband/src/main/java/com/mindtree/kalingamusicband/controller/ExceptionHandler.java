package com.mindtree.kalingamusicband.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.kalingamusicband.Response.ExceptionDto;
import com.mindtree.kalingamusicband.exception.ApplicationException;
import com.mindtree.kalingamusicband.exception.ServiceException;

@RestControllerAdvice(assignableTypes = SongController.class)
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ExceptionDto> applicationExceptionHandler(Exception e, Throwable cause) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto(e.getMessage()));
	}
}