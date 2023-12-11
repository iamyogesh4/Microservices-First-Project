package com.hotel.service;

import com.hotel.entity.Hotel;

public interface IHotelService {
	
	
	//create hotel
	public String createHotel(Hotel hotel);
	
	//findAll Hotel
	public Iterable<Hotel> findAllHotel();
	
	//delete hotel 
	
	public String deleteHotelById(String hotelId);
	
	//gethotel by id
	
	public Hotel gethotelById(String hotelId);
	
	//update hotel
	
	public String updateHotel(Hotel hotel);
	
	
	
	
	

}
