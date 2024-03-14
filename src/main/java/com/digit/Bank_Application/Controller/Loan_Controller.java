package com.digit.Bank_Application.Controller;

import java.util.List;

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

import com.digit.Bank_Application.Entity.Loan;
import com.digit.Bank_Application.Entity.Loan_Type;
import com.digit.Bank_Application.Payload.Loan_Req;
import com.digit.Bank_Application.Payload.Loan_Reqest;
import com.digit.Bank_Application.Payload.PayAmount_Req;
import com.digit.Bank_Application.Repository.LoanType_Repository;
import com.digit.Bank_Application.Repository.Loan_Repo;
import com.digit.Bank_Application.Service.Loan_Service;

@RestController
@RequestMapping("/bank/loan")
public class Loan_Controller {

	@Autowired
	private LoanType_Repository lrepo;
	
	@Autowired
	private Loan_Repo loanrepo;
	@Autowired
	private Loan_Service lser;

	@PostMapping
	public ResponseEntity<String> createLoan(@RequestBody Loan_Req lreq) {

		Loan_Type l = new Loan_Type();
		l.setLoandesc(lreq.getLoandesc());
		l.setLoanname(lreq.getLoanname());
		l.setInterest(lreq.getInterest());
		lrepo.save(l);
		return new ResponseEntity<String>("Created Successfully", HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<Loan_Type>> getAllLoan() {
		return new ResponseEntity<List<Loan_Type>>(lrepo.findAll(), HttpStatus.OK);
	}


	@PostMapping("/getLoan/{accno}")
	public ResponseEntity<String> getLoan(@RequestBody Loan_Reqest lreq,@PathVariable Long accno) {
		return new ResponseEntity<String>(lser.takeLoan(lreq,accno), HttpStatus.CREATED);

	}
	
	@GetMapping("/getalldata/{accno}")
	public ResponseEntity<Loan> getAllLoanDetails(@PathVariable Long accno) {
		return new ResponseEntity<Loan>(loanrepo.findByAccno(accno), HttpStatus.OK);
	}

	
	
	@PutMapping("/pay/{accno}")
	public ResponseEntity<String> payLoan(@RequestBody PayAmount_Req pr,@PathVariable Long accno){
		return new ResponseEntity<String>(lser.payLoan(pr, accno),HttpStatus.OK);
	}
	
	

}
