package com.digit.Bank_Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digit.Bank_Application.Entity.Loan_Type;

public interface LoanType_Repository extends JpaRepository<Loan_Type, Long>{

	Loan_Type findByLid(Long lid);
	Loan_Type findByLoanname(String loanname);
	
}
