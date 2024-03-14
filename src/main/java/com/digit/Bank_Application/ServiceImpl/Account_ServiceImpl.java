package com.digit.Bank_Application.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.Bank_Application.Entity.AccountDet;
import com.digit.Bank_Application.Entity.Debit_Card;
import com.digit.Bank_Application.Entity.Transfer_Details;
import com.digit.Bank_Application.Exception.ResourceNotFoundException;
import com.digit.Bank_Application.Payload.Login_Req;
import com.digit.Bank_Application.Payload.Transfer_Requset;
import com.digit.Bank_Application.Repository.Account_Repository;
import com.digit.Bank_Application.Repository.Debit_Repository;
import com.digit.Bank_Application.Repository.Transfer_Repository;
import com.digit.Bank_Application.Service.Account_Service;

@Service
public class Account_ServiceImpl implements Account_Service {

	@Autowired
	private Account_Repository arepo;

	@Autowired
	private Debit_Repository drepo;

	// CHECK BALACE BY ACCOUNT NUMBER
	@Override
	public float findBalance(Long accno, Integer pin) {
		AccountDet acd = arepo.findByAccno(accno);

		if (pin == acd.getPin()) {
			if (acd.getStatus().equalsIgnoreCase("active")) {

				return acd.getBalance();
			} else {
				return -1;
			}
		}
		return -1;
	}

	// CHECK BALACE BY CARD NUMBER
	@Override
	public float findBalanceBydebit(Long cardno, Integer pin) {
		Debit_Card dc = drepo.findByCardno(cardno);
		long cid = dc.getCid();

		AccountDet acdet = arepo.findByDcid(dc);
		if (acdet.getPin() == pin) {

			float balance = acdet.getBalance();

			return balance;
		} else {
			return -1;
		}
	}

	// ADDMONEY/DEPOSITE TO SELF ACCOUNT
	@Override
	public String Addmoney(Long accid, Float balance, Integer pin) {
		AccountDet accd = arepo.findByAccno(accid);
		if (accd.getPin() == pin) {
			if (accd.getStatus().equalsIgnoreCase("active")) {

				accd.setBalance(accd.getBalance() + balance);
				arepo.save(accd);
				return "AMOUNT ADDED";
			} else {
				return "Account is Inactive";
			}
		} else {
			return "WRONG CREDENTIAL";

		}

	}

	// WITHDRAW AMOUNT
	@Override
	public String withdraw(Long accid, Float balance, Integer pin) {
		AccountDet accd = arepo.findByAccno(accid);
		if (accd.getPin() == pin) {
			if (accd.getStatus().equalsIgnoreCase("active")) {

				accd.setBalance(accd.getBalance() - balance);
				arepo.save(accd);
				return "AMOUNT DEBITED";
			} else {
				return "ACCOUNT IS INACTIVE";
			}
		} else {
			return "WRONG CREDENTIAL";

		}
	}

	// CHANGEPIN

	@Override
	public String changePin(Long cardno, Integer pin, Integer newpin) {
		try {
			Debit_Card dc = drepo.findByCardno(cardno);
			AccountDet acdet = arepo.findByDcid(dc);
			if (acdet.getPin() == pin) {

				if (acdet.getStatus().equalsIgnoreCase("active")) {
					acdet.setPin(newpin);
					arepo.save(acdet);
					return "PIN CHANGED";
				} else {
					return "Account is Inactive";
				}
			} else {
				return "WRONG CREDENTIAL";

			}
		} catch (Exception e) {
			return "Enter Correct Details";
		}

	}

	// DEACTIVATION
	@Override
	public String deactivate(Long accno) {
		AccountDet acd = arepo.findByAccno(accno);
		if (acd.getStatus().equalsIgnoreCase("active")) {
			acd.setStatus("Not Active");
			arepo.save(acd);
			return "ACCOUNT IS DEACTIVATE";
		} else {

			return "ACCOUNT ALREADY IS DEACTIVATE";
		}
	}

	@Override
	public String auth(Login_Req lr) {
		lr.getAccno();
		AccountDet acd = arepo.findByAccnoAndPin(lr.getAccno(), lr.getPin());
		if (acd != null) {
			return "Successful";
		} else {
			return "Invalid Credential";
		}
	}
}
