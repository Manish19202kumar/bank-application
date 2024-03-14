package com.digit.Bank_Application.Payload;

public class Login_Req {

	long accno;
	int pin;
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
}
