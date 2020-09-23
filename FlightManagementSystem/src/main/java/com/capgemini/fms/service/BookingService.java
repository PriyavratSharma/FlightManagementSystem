package com.capgemini.fms.service;

import java.util.List;


import com.capgemini.fms.dto.BookingDto;
import com.capgemini.fms.entity.Booking;
import com.capgemini.fms.entity.Flight;
import com.capgemini.fms.entity.Users;
import com.capgemini.fms.exception.BookingException;

/************************************************************************************************************************
 * @author         Priyavrat Sharma

 * Description     It is a Service interface that provides the methods for view all bookings, adding new bookings, delete bookings and updating bookings 
 *                 and further implemented by service implementation.
 *                 
 *                   
 * Version         1.0
 * Created Date    21-September-2020                 
 ************************************************************************************************************************/

public interface BookingService {
	
	 List<Booking> showallbooking();
	 
	 Booking saveBooking(BookingDto booking)throws BookingException;
	 
	 List<Flight> getAllFlights();
	
	 void deletebooking(int id);
	
	
	 public Users loginUser(Users user) throws BookingException;
}
