package com.hotel.hotelrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entity.Hotel;

public interface IHotelRepository extends JpaRepository<Hotel, String> {

}
