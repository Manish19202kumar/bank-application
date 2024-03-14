package com.digit.Bank_Application.Controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digit.Bank_Application.Entity.AccountDet;
import com.digit.Bank_Application.Entity.Debit_Card;
import com.digit.Bank_Application.Payload.Account_Req;
import com.digit.Bank_Application.Payload.Login_Req;
import com.digit.Bank_Application.Repository.Account_Repository;
import com.digit.Bank_Application.Repository.Debit_Repository;
import com.digit.Bank_Application.Repository.User_Repository;
import com.digit.Bank_Application.Service.Account_Service;

@RestController
@RequestMapping("/bank/acc")
public class Account_Controller {

	@Autowired
	private Account_Repository arepo;

	@Autowired
	private Debit_Repository drepo;

	@Autowired
	private Account_Service accser;

	@Autowired
	private User_Repository urepo;

	@GetMapping("/login")
	public String login(@RequestBody Login_Req lr) {
		return	accser.auth(lr);
				}

	// CREATE ACCOUNT
	@PostMapping
	public ResponseEntity<String> createAccount(@RequestBody Account_Req areq) {

		Random random = new Random();

		long accountnumer = (long) (random.nextDouble() * 9000000000L) + 1000000000L;
		long debitcardno = (long) (random.nextDouble() * 900000L) + 100000L;
		int cvvno = random.nextInt(999 - 100 + 1) + 100;
		Debit_Card dcard = new Debit_Card(areq);
		dcard.setCardno(debitcardno);
		dcard.setCvv(cvvno);

		dcard = drepo.save(dcard);
		AccountDet acc = new AccountDet();

		
		acc.setAccno(accountnumer);
		acc.setBalance(0);
		acc.setBankname(areq.getBankname());
		acc.setHoldername(areq.getHoldername());
		acc.setEmail(areq.getEmail());
		acc.setIfsccode(areq.getIfsccode());
		acc.setPin(areq.getPin());
		acc.setPhone(areq.getPhone());
		acc.setDcid(dcard);
		acc.setStatus("active");
		
		
		acc = arepo.save(acc);
		return new ResponseEntity<String>("Created Successfully", HttpStatus.CREATED);

	}

	// GETDETAILSBYNAME
	@GetMapping("/name/{name}")
	public ResponseEntity<List<AccountDet>> getDetailsByHoldername(@PathVariable String name) {
		return new ResponseEntity<List<AccountDet>>(arepo.findByHoldername(name), HttpStatus.OK);
	}

	// GETDETAILSBYACCOUNT
	@GetMapping("/{accno}")
	public ResponseEntity<AccountDet> getAlldet(@PathVariable long accno) {
		return new ResponseEntity<AccountDet>(arepo.findByAccno(accno), HttpStatus.OK);
	}

	// DEPOSITE MONEY
	@PutMapping("/depo/{accno}/{pin}/{amount}")
	public String UpdateMoney(@PathVariable Long accno, @PathVariable Float amount, @PathVariable Integer pin) {
		return accser.Addmoney(accno, amount, pin);
	}

	// WITHDRAW MONEY
	@PutMapping("/withdraw/{accno}/{pin}/{amount}")
	public String withdraw(@PathVariable Long accno, @PathVariable Float amount, @PathVariable Integer pin) {
		accser.withdraw(accno, amount, pin);
		return "Withdraw Successful";
	}

	@PutMapping("/deactivate/{accno}")
	public String deactivate(@PathVariable Long accno) {
		accser.deactivate(accno);
		return "Deactivate Successful";
	}

	
	// CHECKBALANCEBYACCOUNT
	@GetMapping("/{accno}/{pin}")
	public String getBalanceByaccount(@PathVariable long accno, @PathVariable Integer pin) {

		float findBalance = accser.findBalance(accno, pin);
		if(findBalance >=0 ) {
			String s=String.valueOf(findBalance);  
			return s;	
		}
		else {
			return "WRONG CREDENTIAL";
		}
	}
	

	// CHECKBALANCEBYCARDNUMBER
	@GetMapping("/card/{cardno}/{pin}")
	public String getBalanceByCard(@PathVariable long cardno, @PathVariable Integer pin) {

		float findBalanceBydebit = accser.findBalanceBydebit(cardno, pin);
		if(findBalanceBydebit>=0) {
			String s=String.valueOf(findBalanceBydebit);  
			return s;	
		}
		else {
			return "WRONG CREDENTIAL";
		}
	}

	// Change Pin
	@PutMapping("/changepin/{cardno}/{pin}/{newpin}")
	public String changePin(@PathVariable Long cardno, @PathVariable Integer pin, @PathVariable Integer newpin) {
		return accser.changePin(cardno, pin, newpin);
	}

	
}
