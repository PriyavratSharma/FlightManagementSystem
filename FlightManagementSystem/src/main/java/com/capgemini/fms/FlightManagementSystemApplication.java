package com.capgemini.fms;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.fms.dao.FlightDao;
import com.capgemini.fms.dao.UsersDao;
import com.capgemini.fms.entity.Flight;
import com.capgemini.fms.entity.Users;

@SpringBootApplication
public class FlightManagementSystemApplication  implements CommandLineRunner {
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private UsersDao userDao;
	public static void main(String[] args) {
		
		
		SpringApplication.run(FlightManagementSystemApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Users user1 =new Users(1,"user","Priyavrat","8954562648","priyavrat@gmail.com");
		Users user2 =new Users(2,"user","Sharma","8077872156","sharma@gmail.com");
		userDao.save(user1);
		userDao.save(user2);
		
		
		Flight flight1 =new Flight(123,"AARON AIRLINES",3,"Airbus 319");
		Flight flight2 =new Flight(234,"ACES",3,"Fleet Details");
		Flight flight3 =new Flight(500,"Gerald R.Ford(CVN-78)",200,"Airbus A321");
		Flight flight4 =new Flight(200,"Nimitz(CVN-68)",250,"A320-214 CEO");
		Flight flight5 =new Flight(111,"Nimitz(CVN-68)",200,"A320-251 NEO");
		Flight flight6 =new Flight(153,"ACES",200,"Boeing 747-400");
		Flight flight7 =new Flight(560,"AARON AIRLINES",250,"Boeing 777-200LR");
		flightDao.save(flight1);
		flightDao.save(flight2);
		flightDao.save(flight3);
		flightDao.save(flight4);
		flightDao.save(flight5);
		flightDao.save(flight6);
		flightDao.save(flight7);
	}

}
