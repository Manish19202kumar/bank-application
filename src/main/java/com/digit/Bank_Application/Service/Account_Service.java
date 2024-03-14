package com.digit.Bank_Application.Service;

import java.util.List;

import com.digit.Bank_Application.Entity.Transfer_Details;
import com.digit.Bank_Application.Payload.Login_Req;
import com.digit.Bank_Application.Payload.Transfer_Requset;

public interface Account_Service {

	String Addmoney(Long accid,Float balance,Integer pin);

	float findBalance(Long accno,Integer pin);
	
	float findBalanceBydebit(Long cardno,Integer pin);

	String withdraw(Long accid,Float balance,Integer pin);
	
	String changePin(Long cardno,Integer pin,Integer newpin);

	String deactivate(Long accno);


	String auth(Login_Req lr);
	
	
}
