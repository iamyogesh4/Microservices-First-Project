package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Hotel;
import com.hotel.serviceImpl.HotelServiceImpl;

@RestController("/hotel")
public class HotelController {
	
	
	@Autowired
	private HotelServiceImpl hotelserviceImpl;
	
	@PostMapping("/savehotel")
	public ResponseEntity<String> createHotel(@RequestBody Hotel hotel)
	{
		
		String result = hotelserviceImpl.createHotel(hotel);
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result); 
		
		
	}
	
	
	@GetMapping("/allhotel")
	public ResponseEntity<List<Hotel>> getAllHotel()
	{
		
		List<Hotel> allhotel = (List<Hotel>) hotelserviceImpl.findAllHotel();
		
		return ResponseEntity.ok(allhotel);
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getById(@PathVariable String id)
	{
		
		Hotel hotel = hotelserviceImpl.gethotelById(id);
		
		return ResponseEntity.ok(hotel);
		
	}
	
	
	@PutMapping("/updatehotel")
	public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel)
	{
		
		String hotel1 = hotelserviceImpl.updateHotel(hotel);
		
		return ResponseEntity.ok(hotel1);
		
		
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteHotelById( @PathVariable String id)
	{
		
		String result = hotelserviceImpl.deleteHotelById(id);
		
		return ResponseEntity.ok(result);
	}
	
	
	
	
	

}
