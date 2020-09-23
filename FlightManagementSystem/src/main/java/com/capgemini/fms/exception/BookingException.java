package com.capgemini.fms.exception;
/*****************************************************************************************************
 * @author        Priyavrat Sharma
 * Description    It is a BookingException which handles the exception 
 *                which occurs in booking in the database. 
 *               
 *                
 * Version        1.0
 * Created Date   26-JULY-2020 
 *
 ****************************************************************************************************/
public class BookingException extends Exception {
	private static final long serialVersionUID = 1L;
	/************************************************************************************************************************
	 * Method        BookingException
	 * Description   It is the custom exception which displays the particular message
	 *                 
	 *                 
	 *                   
	 * Created By     Priyavrat Sharma
	 * Created Date   26-JULY-2020                  
	 ************************************************************************************************************************/
	public BookingException(String message) {
		super(message);
	}

}
