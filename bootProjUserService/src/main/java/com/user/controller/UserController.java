package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.serviceImpl.UserServiceImpl;

@RestController("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userservice;
	
	
	@PostMapping("/saveuser")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		
		User user1 = userservice.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getSingleUser(@PathVariable String id)
	{
		
		User user = userservice.getUserById(id);
		
		return ResponseEntity.ok(user);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUser()
	{
		
		List<User> allUsers= (List<User>) userservice.getAllUser();
		
		return ResponseEntity.ok(allUsers);
	}
	
	
	@PutMapping("{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable String id,@RequestBody User user) {
    

        

       String result= userservice.updateUser(id, user);

        return ResponseEntity.ok(result);
    }
	
	
	 @DeleteMapping("{id}")
	 public ResponseEntity<String> deleteTodo(@PathVariable String id)
	 {
	       String result= userservice.deleteUserById(id);
	        return ResponseEntity.ok(result);
	    }
	
	
	
	
	
	
	
}
