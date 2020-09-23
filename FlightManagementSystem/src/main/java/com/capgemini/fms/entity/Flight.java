package com.capgemini.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*****************************************************************************************************
 * @author        Priyavrat Sharma
 * Description    It is a Flight Entity class that 
 *                specifies that the class  is mapped to a database
 *                table with suitable columns.
 * Version        1.0
 * Created Date   20-September-2020
 *
 ****************************************************************************************************/
@Entity
@Table(name = "Flight_table")
public class Flight {
	@Id
	@Column(name = "flightNumber")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightNumber;
	
	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	@Column(name = "carrierName")
	private String carrierName;
	
	@Column(name="seatCapacity")
	private int seatCapacity;
	
	@Column(name="flightModel")
	private String flightModel;
	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Flight(int flightNumber, String carrierName,int seatCapacity, String flightModel) {
		super();
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
		this.flightModel = flightModel;
		
	}

	@Override
	public String toString() {
		return "Flights [flightNumber=" + flightNumber + ", carrierName=" + carrierName + ", seatCapacity="+seatCapacity+", flightModel="+flightModel+"]";
	}
}
