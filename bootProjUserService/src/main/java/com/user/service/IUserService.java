package com.user.service;

import java.util.Optional;

import com.user.entity.User;

public interface IUserService {
	
	//Create user
	
	public User saveUser(User user);
	
	//getAll user
	
	public Iterable<User> getAllUser();
	
	//get single user
	
	public User getUserById(String id);
	
	//delete user by id
	
	public String deleteUserById(String id);
	
	
	//update user
	


	String updateUser(String id,User user);
	
	
	
	
	
	

}
