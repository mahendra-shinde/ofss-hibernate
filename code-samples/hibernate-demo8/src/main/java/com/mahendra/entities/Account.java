package com.mahendra.entities;

import javax.persistence.*;


@Entity
@Table(name="accounts")
public class Account {
	
	@Id @Column(name="acc_no")
	private Integer accNo;
	
	@Column(name="acc_type",length=20)
	private String type;
	
	@Column(name="balance")
	private Double balance;
	
	/// Many Accounts can be linked to One customer
	@ManyToOne(fetch=FetchType.LAZY)
	private Customer customer;

	public Integer getAccNo() {
		return accNo;
	}

	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
