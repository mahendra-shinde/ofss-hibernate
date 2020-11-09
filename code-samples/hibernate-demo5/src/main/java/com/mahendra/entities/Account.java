package com.mahendra.entities;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="accounts")

public class Account {
	
	@Id
	@Column(name="acc_no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer accNo;
	
	@Column(name="cust_name",length=50)
	private String name;
	
	@Column(name="date_opening")
	@Temporal(TemporalType.DATE)
	private Date dateOfOpening;
	
	private double amount;

	public Account(String name, Date dateOfOpening, double amount) {
		super();
		this.name = name;
		this.dateOfOpening = dateOfOpening;
		this.amount = amount;
	}
	

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



	public Date getDateOfOpening() {
		return dateOfOpening;
	}



	public void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
