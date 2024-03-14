package com.digit.Bank_Application.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loantype")
public class Loan_Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long lid;

	@Column(name = "loanname",  nullable = false)
	String loanname;
	
	@Column(name = "loandesc",  nullable = false)
	String loandesc;
	
	@Column(name = "interest",  nullable = false)
	float interest;
	
	@OneToMany(mappedBy = "ltypeid")
	@JsonBackReference
	List<Loan> loan;
	

		public List<Loan> getLoan() {
		return loan;
	}

	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}

		public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}


	public long getLid() {
		return lid;
	}

	public void setLid(long lid) {
		this.lid = lid;
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
