package com.digit.Bank_Application.Payload;



public class Loan_Reqest {
	
	String loantype;

	float lamount;

	int term;


	


	public String getLoantype() {
		return loantype;
	}

	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}

	public float getLamount() {
		return lamount;
	}

	public void setLamount(float lamount) {
		this.lamount = lamount;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	
}
