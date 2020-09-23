package com.capgemini.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.fms.entity.Users;
/*****************************************************************************************************
 * @author        Priyavrat Sharma
 * Description    It is a UsersDao interface typically which extends the JpaRepository 
 *                which implements the method. 
 *                
 * Version        1.0
 * Created Date   20-September-2020 
 *
 ****************************************************************************************************/
public interface UsersDao extends JpaRepository<Users,Integer> {
	public Users findByEmailId(String emailId);
	public Users findByEmailIdAndUserPassword(String emailId, String userPassword); 
}
