package com.user.entity;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    @Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class Rating {
		
		
		private String ratingId;
		
		private String userId;
		
		private String hotelId;
		
		private int rating;
		
		private String feedback;
		
		//this property for get hotel ratings by hotel Id
		private Hotel hotel;

	}


