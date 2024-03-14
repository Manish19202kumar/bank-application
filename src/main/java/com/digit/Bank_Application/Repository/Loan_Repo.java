package com.digit.Bank_Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digit.Bank_Application.Entity.Loan;

public interface Loan_Repo extends JpaRepository<Loan, Long>{
	Loan findByAccno(Long accno);
	
	Loan findByAccnoAndLoantype(Long accno,String loantype);
}
