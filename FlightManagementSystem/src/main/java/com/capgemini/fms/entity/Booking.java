package com.capgemini.fms.entity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/*****************************************************************************************************
 * @author        Priyavrat Sharma
 * Description    It is a Booking Entity class that 
 *                specifies that the class  is mapped to a database
 *                table with suitable columns.
 * Version        1.0
 * Created Date   20-September-2020 
 *
 ****************************************************************************************************/
@Entity
@Table(name = "Booking_Details")
public class Booking {
	@Id
	@Column(name = "bookingId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	
	@Column(name = "Booking_Date")
	@Temporal(TemporalType.DATE)
	private Date bookingDate;
	
	@Column(name="ticket_cost")
	private int ticketCost;
	
	@Column(name="noofpassengers")
	private int noOfPassengers;
	
	
	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(int ticketCost) {
		this.ticketCost = ticketCost;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE}, optional = false)
	@JoinColumn(name = "flightNumber", nullable = false)
	private Flight flight;
	
	

	public Booking(Date bookingDate,int ticketCost,int noOfPassengers,Flight flight) {
		super();
		
		this.bookingDate = bookingDate;
		this.ticketCost = ticketCost;
		this.noOfPassengers = noOfPassengers;
		this.flight=flight;
		
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", ticketCost=" + ticketCost + ", noOfPassengers=" +noOfPassengers + ", flight=" + flight + ""
				+ "]";
	}

}
