package com.digit.Bank_Application.Service;

import com.digit.Bank_Application.Payload.Loan_Reqest;
import com.digit.Bank_Application.Payload.PayAmount_Req;

public interface Loan_Service {

	String takeLoan(Loan_Reqest lr,Long accno);
	
	String payLoan(PayAmount_Req pr,Long accno);
}
