package com.digit.Bank_Application.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.Bank_Application.Entity.AccountDet;
import com.digit.Bank_Application.Entity.Debit_Card;
import com.digit.Bank_Application.Entity.Statement;
import com.digit.Bank_Application.Entity.Transfer_Details;
import com.digit.Bank_Application.Payload.Transfer_Requset;
import com.digit.Bank_Application.Repository.Account_Repository;
import com.digit.Bank_Application.Repository.Debit_Repository;
import com.digit.Bank_Application.Repository.Ministatement_Repository;
import com.digit.Bank_Application.Repository.Transfer_Repository;
import com.digit.Bank_Application.Service.Transfer_Service;

@Service
public class Transfer_ServiceImpl implements Transfer_Service {

	@Autowired
	private Transfer_Repository trepo;

	@Autowired
	private Account_Repository arepo;

	@Autowired
	private Debit_Repository drepo;

	@Autowired
	private Ministatement_Repository mrepo;

	@Override
	public String transferAmount(Long cardno, Integer pin, Long racc, Float amount) {

		Debit_Card dc = drepo.findByCardno(cardno);

		// SENDER
		AccountDet acdet = arepo.findByDcid(dc);

		// RECIEVER
		AccountDet raccdet = arepo.findByAccno(racc);

		Transfer_Details td = new Transfer_Details();
		Statement senderdet = new Statement();
		Statement recieverdet = new Statement();
		Transfer_Requset tr = new Transfer_Requset();
		System.out.println(acdet.getPin());
		System.out.println(pin);
		if (acdet.getStatus().equalsIgnoreCase("active")) {
			if (acdet.getPin() == pin) {

				float balance = acdet.getBalance();
				if (balance >= amount) {
					acdet.setBalance(acdet.getBalance() - amount);
					raccdet.setBalance(raccdet.getBalance() + amount);
					arepo.save(acdet);
					arepo.save(raccdet);
					Random random = new Random();

					long transactionnumber = (long) (random.nextDouble() * 9000000000L) + 1000000000L;
					td.setTrano(transactionnumber);
					td.setSacc(acdet.getAccno());
					td.setSifsc(acdet.getIfsccode());
					td.setRacc(raccdet.getAccno());
					td.setRname(raccdet.getHoldername());
					td.setRbankname(raccdet.getBankname());
					td.setRifsc(raccdet.getIfsccode());
					td.setAmount(amount);
					td.setRtype("CREDITED");
					td.setStype("DEBITED");
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					Date date = new Date();
					td.setTrntime(date);
					trepo.save(td);

					// Sender
					senderdet.setAcc(acdet.getAccno());
					senderdet.setAmount(amount);
					senderdet.setTrano(transactionnumber);
					senderdet.setType("DEBITED");
					senderdet.setTrntime(date);
					senderdet.setDesc("BANK TRANFER");
					mrepo.save(senderdet);
					// Reciever
					recieverdet.setAcc(raccdet.getAccno());
					recieverdet.setAmount(amount);
					recieverdet.setTrano(transactionnumber);
					recieverdet.setType("CREDITED");
					recieverdet.setTrntime(date);
					recieverdet.setDesc("BANK TRANFER");
					mrepo.save(recieverdet);

					return "DONE";

				} else {
					return "insuficient Balance";
				}

			} else {
				return "Pin WORNG";
			}
		}else {
			return "ACCOUNT IS NOT ACTIVE";
		}
	}

	@Override
	public List<Statement> getStatement(Long acc) {
		List<Statement> findByAcc = mrepo.findByAcc(acc);
		return findByAcc;
	}

}
