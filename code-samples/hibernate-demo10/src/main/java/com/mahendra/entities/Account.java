package com.mahendra.entities;

import javax.persistence.*;


@Entity
@Table(name="accounts")
public class Account {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="acc_no")
	private Integer accNo;
	
	@Column(name="cust_name",length=50)
	private String name;
	
	@Column(name="balance")
	private Double balance;

	public Integer getAccNo() {
		return accNo;
	}

	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}
