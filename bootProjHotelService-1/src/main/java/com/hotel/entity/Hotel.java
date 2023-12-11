package com.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Hotel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

	
	@Id
	@Column(name="Hotel-ID")
	private String id;
	
	@Column(name="Hotel-NAME")
	private String name;
	
	@Column(name="Hotel-Location")
	private String location ;
	
	@Column(name="About-Hotel")
	private String about;
	
	
}
