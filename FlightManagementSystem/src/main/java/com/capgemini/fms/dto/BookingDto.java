package com.capgemini.fms.dto;


import java.util.Date;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingDto {
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date bookingDate;	
	private Integer ticketCost;
	private Integer noOfPassengers;
	private Integer flightNumber;
	
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Integer getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(Integer ticketCost) {
		this.ticketCost = ticketCost;
	}
	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public Integer getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}
	
		
	
	public BookingDto(Date bookingDate, Integer ticketCost, Integer noOfPassengers, Integer flightNumber) {
		super();
		
		this.bookingDate = bookingDate;
		this.ticketCost = ticketCost;
		this.noOfPassengers = noOfPassengers;
		this.flightNumber = flightNumber;
		
	}
	@Override
	public String toString() {
		return "BookingDto bookingDate=" + bookingDate + ", ticketCost=" + ticketCost + ", noOfPassengers=" + noOfPassengers
				+ ", flightNumber=" + flightNumber +  "]";
	}
	public BookingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
}
