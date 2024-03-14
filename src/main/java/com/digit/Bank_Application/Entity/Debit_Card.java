package com.digit.Bank_Application.Entity;

import com.digit.Bank_Application.Payload.Account_Req;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name = "debitcard")
public class Debit_Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long cid;

	@Column(name = "cardno", nullable = false)
	long cardno;

	@Column(name = "cvv", nullable = false)
	int cvv;

	public Debit_Card() {
		// TODO Auto-generated constructor stub
	}

	public Debit_Card(Account_Req ar) {
		this.cardno = getCardno();
		this.cvv = getCvv();
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public long getCardno() {
		return cardno;
	}

	public void setCardno(long cardno) {
		this.cardno = cardno;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

}
