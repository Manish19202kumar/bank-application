package com.digit.Bank_Application.Payload;

public class Loan_Req {
	
	

	String loanname;

	String loandesc;
	float interest;
	
	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public String getLoanname() {
		return loanname;
	}

	public void setLoanname(String loanname) {
		this.loanname = loanname;
	}

	public String getLoandesc() {
		return loandesc;
	}

	public void setLoandesc(String loandesc) {
		this.loandesc = loandesc;
	}

}
