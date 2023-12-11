package com.user.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="MicroService_User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@Column(name="User_Id")
	private String userId;
	
	@Column(name="User_Name",length = 20)
	private String userName;
	
	@Column(name="User_Email")
	private String userEmail;

	//In User database data jpa will not create table for only for communication and get user ratings from
	 // rating service that purpose we take has a property of Rating and use @Transient
	
	@Transient
	List<Rating> rating = new ArrayList<>();
}
