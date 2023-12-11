
  package com.user.service.externalservices;
  
  import org.springframework.cloud.openfeign.FeignClient;
import
  org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.entity.Rating; 
 
  
 
  
  @FeignClient(name="RATING-SERVICE") 
  public interface RatingService {
  
  @GetMapping("/allrating") 
  public Iterable<Rating> getAllRatingByUserId();
  
  @PostMapping("/saverating")
  public String saveRating(Rating rating);
  
  
  
  }
 