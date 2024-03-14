package com.digit.Bank_Application.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "statement")
public class Statement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long stateid;
	long trano;
	long acc;
	float amount;
	String type;
	String desc;
	Date trntime;
	public long getStateid() {
		return stateid;
	}
	public void setStateid(long stateid) {
		this.stateid = stateid;
	}
	public long getTrano() {
		return trano;
	}
	public void setTrano(long trano) {
		this.trano = trano;
	}
	public long getAcc() {
		return acc;
	}
	public void setAcc(long acc) {
		this.acc = acc;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTrntime() {
		return trntime;
	}
	public void setTrntime(Date trntime) {
		this.trntime = trntime;
	}
	
	
}
