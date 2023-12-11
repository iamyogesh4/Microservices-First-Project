package com.hotel.exception;

public class HotelNotFoundException extends RuntimeException {
	
	public HotelNotFoundException() 
	{
		
	}
	
	public HotelNotFoundException(String msg) 
	{
		super(msg);
	}

}
