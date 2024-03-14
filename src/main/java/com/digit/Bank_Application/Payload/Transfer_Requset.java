package com.digit.Bank_Application.Payload;

import java.sql.Time;
import java.util.Date;

public class Transfer_Requset {

	long trano;
	long sacc;
	String sifsc;
	String sbankname;
	long racc;
	String rname;
	String rbankname;
	String rifsc;
	float amount;
	String type;
	Date trntime;
	public long getTrano() {
		return trano;
	}
	public void setTrano(long trano) {
		this.trano = trano;
	}
	public long getSacc() {
		return sacc;
	}
	public void setSacc(long sacc) {
		this.sacc = sacc;
	}
	public String getSifsc() {
		return sifsc;
	}
	public void setSifsc(String sifsc) {
		this.sifsc = sifsc;
	}
	public String getSbankname() {
		return sbankname;
	}
	public void setSbankname(String sbankname) {
		this.sbankname = sbankname;
	}
	public long getRacc() {
		return racc;
	}
	public void setRacc(long racc) {
		this.racc = racc;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRbankname() {
		return rbankname;
	}
	public void setRbankname(String rbankname) {
		this.rbankname = rbankname;
	}
	public String getRifsc() {
		return rifsc;
	}
	public void setRifsc(String rifsc) {
		this.rifsc = rifsc;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getTrntime() {
		return trntime;
	}
	public void setTrntime(Date trntime) {
		this.trntime = trntime;
	}

	
	
	

}
