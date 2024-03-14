package com.digit.Bank_Application.ServiceImpl;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.digit.Bank_Application.Entity.AccountDet;
import com.digit.Bank_Application.Entity.Loan;
import com.digit.Bank_Application.Entity.Loan_Type;
import com.digit.Bank_Application.Entity.Statement;
import com.digit.Bank_Application.Entity.Transfer_Details;
import com.digit.Bank_Application.Payload.Loan_Req;
import com.digit.Bank_Application.Payload.Loan_Reqest;
import com.digit.Bank_Application.Payload.PayAmount_Req;
import com.digit.Bank_Application.Repository.Account_Repository;
import com.digit.Bank_Application.Repository.LoanType_Repository;
import com.digit.Bank_Application.Repository.Loan_Repo;
import com.digit.Bank_Application.Repository.Ministatement_Repository;
import com.digit.Bank_Application.Service.Loan_Service;

@Service
public class Loan_ServiceImpl implements Loan_Service {

	@Autowired
	private Account_Repository arepo;
	@Autowired
	private Loan_Repo lrepo;

	@Autowired
	private LoanType_Repository ltrepo;

	@Autowired
	private Ministatement_Repository mrepo;

	@Override
	public String takeLoan(@RequestBody Loan_Reqest lr, Long accno) {
		Loan_Req lreq = new Loan_Req();
		AccountDet findByAccno = arepo.findByAccno(accno);
		Loan lo = new Loan();
		Loan_Type findByLid = ltrepo.findByLoanname(lr.getLoantype());
		lo.setAccno(findByAccno.getAccno());
		lo.setLoantype(findByLid.getLoanname());
		lo.setLamount(lr.getLamount());
		float p = lr.getLamount();
		lo.setRate(findByLid.getInterest());
		float r = findByLid.getInterest();
		lo.setTerm(lr.getTerm());
		int t = lr.getTerm();
		float si = (p * t * r) / 100;
		lo.setSi(si);
//	        double emi= (principal*rate*Math.pow(1+rate,time))/(Math.pow(1+rate,time)-1);
		r = r / (12 * 100); // one month interest
		t = t * 12; // one month period
		float emi = (p * r * (float) Math.pow(1 + r, t)) / (float) (Math.pow(1 + r, t) - 1);

		float tamount = p;
		float paidamount = 0;
		lo.setPaidamount(paidamount);
		lo.setMonthlyamount(emi);
		lo.setTotalamount(tamount);
		lo.setRestamount(tamount - paidamount);
		lo.setAcd(findByAccno);
		lo.setLtypeid(findByLid);
		lrepo.save(lo);
		return "APPROVED";
	}

	@Override
	public String payLoan(PayAmount_Req pr, Long accno) {
		AccountDet findByAccno = arepo.findByAccno(accno);
		Loan loanAcc = lrepo.findByAccnoAndLoantype(accno, pr.getLoanname());
		float balance = findByAccno.getBalance();
		if (findByAccno.getStatus().equalsIgnoreCase("active")) {
			if (balance >= pr.getPayamount()) {
				if (loanAcc.getRestamount() != 0) {

					float pa = loanAcc.getPaidamount();
					float payam = pr.getPayamount();
					loanAcc.setPaidamount(pa + payam);
					float ta = loanAcc.getTotalamount();
					loanAcc.setRestamount(ta - (pa + payam));
					lrepo.save(loanAcc);

					float pbal = findByAccno.getBalance();
					findByAccno.setBalance(pbal - payam);
					arepo.save(findByAccno);
					Date date = new Date();
					Random random = new Random();

					long transactionnumber = (long) (random.nextDouble() * 9000000000L) + 1000000000L;

					Statement senderdet = new Statement();
					senderdet.setAcc(accno);
					senderdet.setAmount(pr.getPayamount());
					senderdet.setTrano(transactionnumber);
					senderdet.setTrntime(date);
					senderdet.setDesc("Loan Payment");
					senderdet.setType("Credited");
					mrepo.save(senderdet);
					return "paid";

				}
				return "ALL Loan Paid";
			}
			return "insufficient Balance";
		}
		return "ACOUNT IS DEACTIVATE";
	}

}
