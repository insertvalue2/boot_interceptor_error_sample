package com.tencoding.interceptor.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tencoding.interceptor.exception.AuthException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AuthException.class)
	public ResponseEntity<?> authExcption() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
}
