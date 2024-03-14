package com.digit.Bank_Application.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accdetails")
public class AccountDet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long accid;

	@Column(name = "accno", unique = true, nullable = false)
	private long accno;

	@Column(name = "pin", nullable = false)
	private int pin;

	@Column(name = "holdername", nullable = false)
	private String holdername;

	@Column(name = "balance")
	private float balance;

	@Column(name = "ifsccode", nullable = false)
	private String ifsccode;

	@Column(name = "bankname", nullable = false)
	private String bankname;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phone", nullable = false)
	private long phone;
	
	@Column(name = "Status", nullable = false)
	private String Status;

	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

	@JoinColumn(name="dcid")
	@OneToOne
	private Debit_Card dcid;
	
	@JsonBackReference
	@OneToMany(mappedBy = "acd")
	List<Loan> loan;


	public List<Loan> getLoan() {
		return loan;
	}






	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}






	public Debit_Card getDcid() {
		return dcid;
	}
	
	

	


	public void setDcid(Debit_Card dcid) {
		this.dcid = dcid;
	}

	public long getAccid() {
		return accid;
	}

	public void setAccid(long accid) {
		this.accid = accid;
	}

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	public String getHoldername() {
		return holdername;
	}

	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
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
