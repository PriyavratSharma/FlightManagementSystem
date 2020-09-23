package com.capgemini.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.fms.entity.Booking;
/*****************************************************************************************************
 * @author        Priyavrat Sharma
 * Description    It is a BookingDao interface typically which extends the JpaRepository 
 *                which implements the method. 
 *                
 * Version        1.0
 * Created Date   20-September-2020 
 *
 ****************************************************************************************************/
public interface BookingDao extends JpaRepository<Booking,Integer> {
	List<Booking> findAll();
}
