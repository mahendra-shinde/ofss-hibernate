package com.mahendra.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cust_id")
	private Integer custId;
	
	@Column(name="cust_name",length=50)
	private String name;
	
	@Column(name="phone",length=10)
	private String phone;
	
	// CascadeType.REMOVE ==> Every time a 'customer' entity is deleted, it must delete 'credentials' as well.
	// CascadeTyoe.REFRESH ==> Reload credentials when customer object is reloaded.
	@OneToOne(cascade= {CascadeType.REMOVE , CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name="cust_id")
	private LoginCredential credentials;

	
	
	
	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LoginCredential getCredentials() {
		return credentials;
	}

	public void setCredentials(LoginCredential credentials) {
		this.credentials = credentials;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
