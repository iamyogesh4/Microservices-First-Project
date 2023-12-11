package com.rating.ratingrepo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.entity.Rating;

public interface IRatingRepository  extends JpaRepository<Rating, String>{
	
	public List<Rating> findByuserId(String id);
	
	public List<Rating> findByhotelId(String id);
	

}
