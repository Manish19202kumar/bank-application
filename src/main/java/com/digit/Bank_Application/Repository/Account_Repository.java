package com.digit.Bank_Application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digit.Bank_Application.Entity.AccountDet;
import com.digit.Bank_Application.Entity.Debit_Card;

public interface Account_Repository extends JpaRepository<AccountDet, Long>{

//	List<AccountDet> findByAccno(long accno);
		
	AccountDet findByAccno(Long accno);
	
	List<AccountDet> findByHoldername(String name);

	AccountDet findByAccnoAndPin(Long accno,Integer pin);
	
	AccountDet findByAccid(Long accid);
	
	//CHECK BALACE USING DEBIT CARD
	AccountDet findByDcid(Debit_Card dcid);


}
