package com.rating.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entity.Rating;
import com.rating.ratingrepo.IRatingRepository;
import com.rating.service.IRatingService;

@Service("ratingservice")
public class RatingServiceImpl  implements IRatingService{

	@Autowired
	private IRatingRepository ratingrepo;
	
	@Override
	public String createrating(Rating rating) {
		
		String id = UUID.randomUUID().toString();
		
		rating.setRatingId(id);
		
		return "Rating are save with id"+ratingrepo.save(rating).getRatingId() ;
	}

	@Override
	public Iterable<Rating> findAllrating() {
		
		
		return  ratingrepo.findAll();
	}

	@Override
	public List<Rating> getAllhotelRatingbyId(String id) {
		
		List<Rating> hotelrating = ratingrepo.findByhotelId(id);
		
		return hotelrating;
	}

	@Override
	public List<Rating> getAlluserRatingbyId(String id) {
		
		List<Rating> userrating = ratingrepo.findByuserId(id);
		
		
		return userrating;
	}

}
