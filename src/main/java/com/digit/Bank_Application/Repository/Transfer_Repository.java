package com.digit.Bank_Application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digit.Bank_Application.Entity.Transfer_Details;

public interface Transfer_Repository extends JpaRepository<Transfer_Details, Long>{

	List<Transfer_Details> findBySacc(long sacc);

}
