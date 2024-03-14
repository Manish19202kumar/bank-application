package com.digit.Bank_Application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digit.Bank_Application.Entity.Statement;

public interface Ministatement_Repository extends JpaRepository<Statement, Long>{

	
	List<Statement> findByAcc(long accno);

}
