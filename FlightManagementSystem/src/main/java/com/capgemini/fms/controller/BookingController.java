package com.capgemini.fms.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.fms.dto.BookingDto;
import com.capgemini.fms.entity.Booking;
import com.capgemini.fms.entity.Flight;
import com.capgemini.fms.entity.Users;
import com.capgemini.fms.exception.BookingException;
import com.capgemini.fms.service.BookingService;
/************************************************************************************************************************
 * @author         Priyavrat Sharma
 * Description     It is a Booking Controller which implements getmapping, postmapping and deletemapping for retrieve, book, update or
 *                 delete fights from database
 *                 
 *                 
 * Version         1.0
 * Created Date    22-September-2020                  
 ************************************************************************************************************************/


@RestController
//@CrossOrigin(origins="http://localhost:4200") 
public class BookingController {
@Autowired
private BookingService bookingService;
/************************************************************************************************************************
 * Method        loginUser
 * Description   To login into the Application
 *                
 *                 
 *                   
 * Created By    Priyavrat Sharma
 * Created Date  22-September-2020                  
 ************************************************************************************************************************/
@PostMapping("/login")

public ResponseEntity<String> loginUser(@RequestBody Users user) throws BookingException {
	 bookingService.loginUser(user);
	return new ResponseEntity<String>("login successfully", HttpStatus.OK);

}

/************************************************************************************************************************
 * Method        getAllFlights
 * Description   To view all the flights inserted in the database
 *                
 *                 
 *                   
 * Created By    Priyavrat Sharma
 * Created Date  22-September-2020                  
 ************************************************************************************************************************/
@GetMapping("/flights")
public ResponseEntity<List<Flight>> getAllFlights()
{
	return new ResponseEntity<List<Flight>>(bookingService.getAllFlights(),HttpStatus.OK);
}

/************************************************************************************************************************
 * Method        getAllBooking
 * Description   To view all the bookings inserted in the database
 *                
 *                 
 *                   
 * Created By    Priyavrat Sharma
 * Created Date  22-September-2020                  
 ************************************************************************************************************************/
@CrossOrigin(origins="http://localhost:4200") 
@GetMapping("/viewBookings")
public ResponseEntity<List<Booking>> getAllBooking()
{
	return ResponseEntity.ok().body(bookingService.showallbooking());	
}


/************************************************************************************************************************
 * Method        saveBooking
 * Description   To add the booking in the database
 *                
 *                 
 *                   
 * Created By    Priyavrat Sharma
 * Created Date  22-September-2020                  
 ************************************************************************************************************************/
@PostMapping("/bookFlight")
public ResponseEntity<String> saveBooking(@RequestBody BookingDto bookingDto, BindingResult bindingResult)throws BookingException
{
	System.out.println("JSON data:"+bookingDto);
	
	String err = "";
	if (bindingResult.hasErrors()) 
	{
		List<FieldError> errors = bindingResult.getFieldErrors();
		for (FieldError error : errors)
			err += error.getDefaultMessage() + "<br/>";
		throw new BookingException(err);
	}
	try {
		bookingService.saveBooking(bookingDto);
		
		return new ResponseEntity<String>("Flight booked successfully!!", HttpStatus.OK);
		}
	catch (Exception ex)
	{
		throw new BookingException(ex.getMessage());
	}
}
/************************************************************************************************************************
 * Method        deletebooking
 * Description   To delete the booking from the database
 *                
 *                 
 *                   
 * Created By    Priyavrat Sharma
 * Created Date  22-September-2020                  
 ************************************************************************************************************************/
@DeleteMapping("/bookings/{bookingId}")
public ResponseEntity<String>deletebooking(@PathVariable int bookingId) throws BookingException{
	  try {
		  bookingService.deletebooking(bookingId);
		  return new ResponseEntity<String>("Booking Cancelled",HttpStatus.OK);
	  }
	  catch(Exception ex) {
		  throw new BookingException("Id does not exist");
	  }
}

}
