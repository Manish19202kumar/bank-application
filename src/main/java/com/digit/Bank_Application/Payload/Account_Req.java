package com.digit.Bank_Application.Payload;

import java.util.List;

import com.digit.Bank_Application.Entity.Loan;

public class Account_Req {
	long accid;

	private int pin;

	private String holdername;

	private String ifsccode;

	private String bankname;

	private String email;

	private long phone;
	
	public long getAccid() {
		return accid;
	}

	public void setAccid(long accid) {
		this.accid = accid;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getHoldername() {
		return holdername;
	}

	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

}
