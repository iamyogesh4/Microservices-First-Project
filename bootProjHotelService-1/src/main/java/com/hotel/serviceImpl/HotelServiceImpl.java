package com.hotel.serviceImpl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.exception.HotelNotFoundException;
import com.hotel.hotelrepo.IHotelRepository;
import com.hotel.service.IHotelService;

@Service("hotelserviceImpl")
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	private IHotelRepository hotelrepo;

	@Override
	public String createHotel(Hotel hotel) {
		
		String hotelId = UUID.randomUUID().toString();
		
		hotel.setId(hotelId);
		
		
		return "Hotel Register Succefully with Id"+hotelrepo.save(hotel).getId();
	}

	@Override
	public Iterable<Hotel> findAllHotel() {
		
		Iterable<Hotel> itr = hotelrepo.findAll();
		
		return itr ;
	}

	@Override
	public String deleteHotelById(String hotelId) {
		
		Optional<Hotel> opt = hotelrepo.findById(hotelId);
		
		if(opt.isPresent()) 
		{
			
			Hotel hotel1 = opt.get();
			
			hotelrepo.deleteById(hotelId);
			
			return "Hotel Id Found and deleted";
			
		}
		
		else {
		
		
		return "Sorrry we cant find any hotel for deletion with id"+hotelId ;
		
		}
	}

	@Override
	public Hotel gethotelById(String hotelId) {
		
		
		
		return hotelrepo.findById(hotelId).orElseThrow(()->new HotelNotFoundException("Hotel Not Found")) ;
	}

	@Override
	public String updateHotel(Hotel hotel) {
		
		Optional<Hotel> opt = hotelrepo.findById(hotel.getId());
		
		if(opt.isPresent()) 
		{
			
			Hotel hotel1 = opt.get();
			
			hotel1.setName(hotel.getName());
			
			hotel1.setLocation(hotel.getLocation());
			
			hotel1.setAbout(hotel.getAbout());
			
			hotelrepo.save(hotel1);
			
			return "Hotel Updated and Save";
		}
		
		else {
			
		return "No Hotel found for updation" ;
		
		
		}
	}
	
	
	
	

}
