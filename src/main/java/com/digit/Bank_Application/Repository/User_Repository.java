package com.digit.Bank_Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digit.Bank_Application.Entity.Users;

public interface User_Repository extends JpaRepository<Users, Long>{

}
