package com.digit.Bank_Application.Payload;

public class PayAmount_Req {

	float payamount;
	
	String loanname;

	public String getLoanname() {
		return loanname;
	}

	public void setLoanname(String loanname) {
		this.loanname = loanname;
	}

	public float getPayamount() {
		return payamount;
	}

	public void setPayamount(float payamount) {
		this.payamount = payamount;
	}
	
	
}
