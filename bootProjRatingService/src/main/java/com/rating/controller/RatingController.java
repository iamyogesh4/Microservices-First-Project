package com.rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entity.Rating;

import com.rating.serviceImpl.RatingServiceImpl;

@RestController("/rating")
public class RatingController {
	
	@Autowired
	private RatingServiceImpl ratingservice;
	
	
	@PostMapping("/saverating")
	public ResponseEntity<String> saveRating(@RequestBody Rating raing)
	{
		
		String result = ratingservice.createrating(raing);
		
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping("/allrating")
	public ResponseEntity<Iterable<Rating>> getAllRating()
	{
		
		
		Iterable<Rating> result = ratingservice.findAllrating();
		
		return ResponseEntity.ok(result);
		
		
	}
	

	@GetMapping("/userrating/{id}")
	public ResponseEntity<Iterable<Rating>> getUserRatingById(@PathVariable("id") String userId)
	{
		
		
		Iterable<Rating> result = ratingservice.getAlluserRatingbyId(userId);
		
		return ResponseEntity.ok(result);
		
		
	}
	
	
	@GetMapping("/hotelrating/{id}")
	public ResponseEntity<Iterable<Rating>> getHotelRatingById(@PathVariable("id") String hotelId)
	{
		
		
		Iterable<Rating> result = ratingservice.getAllhotelRatingbyId(hotelId);
		
		return ResponseEntity.ok(result);
		
		
	}
	
	
	
	
	

}
