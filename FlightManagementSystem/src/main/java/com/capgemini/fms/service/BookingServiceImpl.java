package com.capgemini.fms.service;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.fms.dao.BookingDao;
import com.capgemini.fms.dao.FlightDao;
import com.capgemini.fms.dao.UsersDao;
import com.capgemini.fms.dto.BookingDto;
import com.capgemini.fms.entity.Booking;
import com.capgemini.fms.entity.Flight;
import com.capgemini.fms.entity.Users;
import com.capgemini.fms.exception.BookingException;
import java.util.List;
import java.util.Optional;
/************************************************************************************************************************
 * @author         Priyavrat Sharma
 * Description     It is a ServiceImpl that implements the methods of adding new bookings, delete bookings and updating bookings 
 *                 from Service Interface
 *                 
 *                   
 * Version         1.0
 * Created Date    21-September-2020                  
 ************************************************************************************************************************/
@Transactional
@Service
public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired 
	private FlightDao flightDao;
	
	@Autowired 
	private UsersDao usersDao;
	
	/************************************************************************************************************************
	 * Method        loginUser
	 * Description   To implement the method to login into the Application 
	 *                
	 *                 
	 *                   
	 * Created By    Priyavrat Sharma
	 * Created Date  21-September-2020                 
	 ************************************************************************************************************************/
	@Override
	public Users loginUser(Users user) throws BookingException {

		String tempEmailId = user.getEmailId();
		String tempPass = user.getUserPassword();
		Users userObj = null;
		if (tempEmailId != null && tempPass != null) {
			userObj = usersDao.findByEmailIdAndUserPassword(tempEmailId, tempPass);
		}
		if (userObj == null) {
			throw new BookingException("Invalid  EmailId and Password");
		}

		return userObj;
	}
	
	/************************************************************************************************************************
	 * Method        saveBooking
	 * Description   To implement the method to book the flight 
	 *                
	 *                 
	 *                   
	 * Created By    Priyavrat Sharma
	 * Created Date  21-September-2020                  
	 ************************************************************************************************************************/

	@Override
	public Booking saveBooking(BookingDto bookingDto) throws BookingException
	{	
			
		Optional<Flight> flight=flightDao.findById(bookingDto.getFlightNumber());
		if(flight==null)throw new  BookingException("flight does not exists.");
			
			
			Booking booking=new Booking( bookingDto.getBookingDate(),bookingDto.getTicketCost(),bookingDto.getNoOfPassengers(), flight.get());
			return bookingDao.save(booking);	 
	}
	
	/************************************************************************************************************************
	 * Method        showallBooking
	 * Description   To implement the method to show all the bookings 
	 *                
	 *                 
	 *                   
	 * Created By    Priyavrat Sharma
	 * Created Date  21-September-2020                  
	 ************************************************************************************************************************/
	@Override
	   public List<Booking> showallbooking()
		{
			// TODO Auto-generated method stub
			return this.bookingDao.findAll();
		}
	
	
	/************************************************************************************************************************
	 * Method        deletebooking
	 * Description   To implement the method to delete the booking 
	 *                
	 *                 
	 *                   
	 * Created By    Priyavrat Sharma
	 * Created Date  21-September-2020                  
	 ************************************************************************************************************************/
	@Override
	public void deletebooking(int bookingId) {
		bookingDao.deleteById(bookingId);
	}
	

	/************************************************************************************************************************
	 * Method        getAllFlights
	 * Description   To implement the method to show all the flights 
	 *                
	 *                 
	 *                   
	 * Created By    Priyavrat Sharma
	 * Created Date  21-September-2020                  
	 ************************************************************************************************************************/
	@Override
	public List<Flight> getAllFlights() {
		// TODO Auto-generated method stub
		return flightDao.findAll();
	}
	
	

}
