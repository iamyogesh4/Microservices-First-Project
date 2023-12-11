package com.user.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Hotel;
import com.user.entity.Rating;
import com.user.entity.User;
import com.user.exception.ResourceNotFoundExeption;
import com.user.service.IUserService;
import com.user.service.externalservices.HotelService;
import com.user.service.externalservices.RatingService;
import com.user.userrepo.IUserRepository;

@Service("userserviceimpl")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userrepo;
	
	@Autowired
	private HotelService hotelservice;
	
	@Autowired
	private RatingService ratingservice;
	
	@Autowired
	@LoadBalanced
	private RestTemplate template;
	
	@Override
	public User saveUser(User user) {
		
		String userId=UUID.randomUUID().toString();
		user.setUserId(userId);
		
		
		ratingservice.saveRating((Rating) user.getRating());
		
		
		
		
		return userrepo.save(user);
	}

	@Override
	public Iterable<User> getAllUser() {
		
		Iterable<User> itr = userrepo.findAll();
		
		Iterable<Rating> allrating = ratingservice.getAllRatingByUserId();
		
		
		itr.forEach(userid->
		{
			
			userid.setRating((List<Rating>) allrating);
		});
		
			
		return itr;
	}

	@Override
	public User getUserById(String id) {
		 
		
		 User user =userrepo.findById(id).orElseThrow(()->new ResourceNotFoundExeption("User not found"));
		 
			
			
			  //get rating by passing user id
		 Rating[] userratingbyId = template.getForObject("http://RATING-SERVICE/userrating/"+user.getUserId(), Rating[].class);
			  
			  List<Rating> ratings =Arrays.stream(userratingbyId).toList();
			  
			  
			  List<Rating> ratingList = ratings.stream().map(rating -> {
			  
			  
			  //API CALL TO get hotel service
			  
			  //http://localhost:3000/b98972aa-2526-405e-b82a-2bec30c5d64e
			  
			  
			  
			  ResponseEntity<Hotel> forentity =template.getForEntity("http://HOTEL-SERVICE/"+rating.getHotelId(),Hotel.class);
			  
			  //Hotel hotel = forentity.getBody();
			  
			  
			  
			  
			  //Using Feign Client
			  
			  
			  
			  
			  Hotel hotel = hotelservice.getHotelById(rating.getHotelId());
			  
			  
			  rating.setHotel(hotel);
			  
			  //return the rating
			  
			  return rating; 
			  
			  }).collect(Collectors.toList());
			 
			  
			  
			  user.setRating(ratingList);
			   
		 
		
	   return user;
			  
		
	}

	@Override
	public String deleteUserById(String id) {
		
	   User user1 = getUserById(id);
	   
	   
	   
	   userrepo.delete(user1);
	   
	   return "User is found and deleted with id"+user1.getUserId();
	   
		
	}

	@Override
	public String updateUser( String id ,User user) {
		
		Optional<User> opt = userrepo.findById(id);
		
		if(opt.isPresent()) 
		{
			
			User user1 = opt.get();
			
			user1.setUserName(user.getUserName());
			
			user1.setUserEmail(user.getUserEmail());
			
			userrepo.save(user1);
			
			return "User found And Updated";
			
			
		}
		
		else {
		
		return "User Not Found for Update";
		
		}
			
	}

	

}
