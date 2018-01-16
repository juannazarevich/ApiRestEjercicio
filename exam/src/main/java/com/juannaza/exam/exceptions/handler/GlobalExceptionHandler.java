package com.juannaza.exam.exceptions.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.juannaza.exam.exceptions.CommunicationException;
import com.juannaza.exam.exceptions.ResourceNotFoundException;
import com.juannaza.exam.exceptions.model.ErrorInfo;

@RestControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(CommunicationException.class)
	public @ResponseBody ErrorInfo handlerCommunicationException(HttpServletRequest req, CommunicationException ex) {
		LOGGER.error(ex.getMessage(), ex);
		return new ErrorInfo("500", ex.getMessage());
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public @ResponseBody ErrorInfo handlerResourceNotFoundException(ResourceNotFoundException ex) {
		LOGGER.error(ex.getMessage(), ex);
		return new ErrorInfo(String.valueOf(HttpStatus.NOT_FOUND.value()), ex.getMessage());
	}
}
