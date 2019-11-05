package com.example.rest;

/**
 * @author Mohd Danish
 *
 */
@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

	/**
	 * This will Handle the exception
	 * @param exception
	 */
	public UserNotFoundException(String exception) {
		super(exception);
	}

}
