package com.accenture.projeto.exceptions;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value= {ExcecaoTransferencia.class})
	public ResponseEntity handleAnyException(Exception e){
		System.out.println("Conta 2 não existe");
		return null;
	}
	
}
