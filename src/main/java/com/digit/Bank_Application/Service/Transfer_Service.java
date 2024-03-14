package com.digit.Bank_Application.Service;

import java.util.List;

import com.digit.Bank_Application.Entity.Statement;
import com.digit.Bank_Application.Payload.Transfer_Requset;

public interface Transfer_Service {

	String transferAmount(Long cardno, Integer pin, Long racc, Float amount);
	
	List<Statement> getStatement(Long accno);
}
