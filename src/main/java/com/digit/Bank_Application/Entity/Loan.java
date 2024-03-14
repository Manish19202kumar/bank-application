package com.digit.Bank_Application.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long lid;
	
	@Column(name = "accno",nullable = false)
	long accno;
	
	@Column(name = "loantype",nullable = false)
	String loantype;
	
	@Column(name = "lamount",nullable = false)
	float lamount;

	@Column(name = "rate",nullable = false)
	float rate;
	
	@Column(name = "term",nullable = false)
	int term;
	
	@Column(name = "si",nullable = false)
	float si;
	
	@Column(name = "monthlyamount",nullable = false)
	float monthlyamount;
	
	@Column(name = "totalamount",nullable = false)
	float totalamount;
	
	@Column(name = "restamount",nullable = false)
	float restamount;
	
	@Column(name = "paidamount",nullable = false)
	float paidamount;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "acd")
	AccountDet acd;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "ltypeid")
	Loan_Type ltypeid;

	public Loan_Type getLtypeid() {
		return ltypeid;
	}

	public void setLtypeid(Loan_Type ltypeid) {
		this.ltypeid = ltypeid;
	}

	public AccountDet getAcd() {
		return acd;
	}

	public void setAcd(AccountDet acd) {
		this.acd = acd;
	}
	
	

	public float getPaidamount() {
		return paidamount;
	}

	public void setPaidamount(float paidamount) {
		this.paidamount = paidamount;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public float getSi() {
		return si;
	}

	public void setSi(float si) {
		this.si = si;
	}

	public float getMonthlyamount() {
		return monthlyamount;
	}

	public void setMonthlyamount(float monthlyamount) {
		this.monthlyamount = monthlyamount;
	}

	public float getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}

	public float getRestamount() {
		return restamount;
	}

	public void setRestamount(float restamount) {
		this.restamount = restamount;
	}

	public long getLid() {
		return lid;
	}

	public void setLid(long lid) {
		this.lid = lid;
	}

	 

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

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
	
	
	
	
}
