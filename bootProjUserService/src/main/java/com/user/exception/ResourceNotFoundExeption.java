package com.user.exception;

public class ResourceNotFoundExeption extends RuntimeException {
	
	
	public ResourceNotFoundExeption() 
	{
		
	}
	
	public ResourceNotFoundExeption(String msg) 
	{
		super(msg);
	}

}
