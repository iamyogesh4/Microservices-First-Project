package com.rating.service;

import java.util.List;

import com.rating.entity.Rating;

public interface IRatingService {
	
	
	//create rating
		public String createrating(Rating rating);
		
		//findAll rating
		public Iterable<Rating> findAllrating();
		
		
		
		//get all hotel rating by hotelId
		
		public List<Rating>  getAllhotelRatingbyId(String id);
		
		//get all rating by userId
		
		public List<Rating> getAlluserRatingbyId(String id);
		
		

}
