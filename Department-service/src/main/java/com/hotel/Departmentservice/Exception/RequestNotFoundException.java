package com.hotel.Departmentservice.Exception;

public class RequestNotFoundException extends RuntimeException{

	public RequestNotFoundException(String message)
	{
		super(message);
	}
}
