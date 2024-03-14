package com.digit.Bank_Application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digit.Bank_Application.Entity.AccountDet;
import com.digit.Bank_Application.Entity.Statement;
import com.digit.Bank_Application.Entity.Transfer_Details;
import com.digit.Bank_Application.Payload.Transfer_Requset;
import com.digit.Bank_Application.Repository.Account_Repository;
import com.digit.Bank_Application.Repository.Debit_Repository;
import com.digit.Bank_Application.Repository.Transfer_Repository;
import com.digit.Bank_Application.Service.Account_Service;
import com.digit.Bank_Application.Service.Transfer_Service;

@RestController
@RequestMapping("/bank/transfer")
public class Transfer_Controller {

	@Autowired
	private Transfer_Repository trepo;

	@Autowired
	private Transfer_Service trnser;

	
	
	// TRANSFERMONEY
		@PutMapping("/{cardno}/{pin}/{racc}/{amount}")
		public String tranferAmount(@PathVariable Long cardno, @PathVariable Integer pin, @PathVariable Long racc,@PathVariable Float amount) {
			return trnser.transferAmount(cardno, pin, racc,amount);
		}
		
		//STATEMENT
		@GetMapping("/statement/{acc}")
		public ResponseEntity<List<Statement>> getDetailsByHoldername(@PathVariable Long acc) {
			return new ResponseEntity<List<Statement>>(trnser.getStatement(acc), HttpStatus.OK);
		}

}
