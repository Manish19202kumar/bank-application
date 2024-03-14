package com.digit.Bank_Application.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transferdet")
public class Transfer_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long traid;

	@Column(name = "trano", nullable = false)
	long trano;

	@Column(name = "trntime", nullable = false)
	Date trntime;

	@Column(name = "sacc", nullable = false)
	long sacc;

	@Column(name = "sifsc", nullable = false)
	String sifsc;

	@Column(name = "amont", nullable = false)
	float amount;

	@Column(name = "racc", nullable = false)
	long racc;
	@Column(name = "rifsc", nullable = false)
	String rifsc;

	@Column(name = "rbankname", nullable = false)
	String rbankname;

	@Column(name = "rname", nullable = false)
	String rname;

	@Column(name = "rtype", nullable = false)
	String rtype;
	@Column(name = "stype", nullable = false)
	String stype;

	public String getRtype() {
		return rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public Transfer_Details() {
		// TODO Auto-generated constructor stub
	}

	public long getTraid() {
		return traid;
	}

	public void setTraid(long traid) {
		this.traid = traid;
	}

	public long getTrano() {
		return trano;
	}

	public void setTrano(long trano) {
		this.trano = trano;
	}

	
	public Date getTrntime() {
		return trntime;
	}

	public void setTrntime(Date trntime) {
		this.trntime = trntime;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
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

	public long getRacc() {
		return racc;
	}

	public void setRacc(long racc) {
		this.racc = racc;
	}

	public String getRifsc() {
		return rifsc;
	}

	public void setRifsc(String rifsc) {
		this.rifsc = rifsc;
	}

	public String getRbankname() {
		return rbankname;
	}

	public void setRbankname(String rbankname) {
		this.rbankname = rbankname;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

}
