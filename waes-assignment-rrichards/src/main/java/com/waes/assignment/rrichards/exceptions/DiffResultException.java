package com.waes.assignment.rrichards.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * @author Rafael Richards
 * Exception that can be throwed during the Diff differences validation
 */
@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
public class DiffResultException extends RuntimeException 
{
	private static final long serialVersionUID = 6431414894505848634L;

	
	public DiffResultException(String message) 
	{
		super(message);
	}

}
