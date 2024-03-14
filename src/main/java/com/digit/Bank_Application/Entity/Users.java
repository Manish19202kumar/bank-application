package com.digit.Bank_Application.Entity;

import com.digit.Bank_Application.Payload.Account_Req;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long uid;
	
	@Column(name = "acc",nullable = false)
	long acc;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public long getAcc() {
		return acc;
	}
	public void setAcc(long acc) {
		this.acc = acc;
	}
	public Users(Account_Req ar) {
		this.acc = getAcc();
	}
	
	

}
