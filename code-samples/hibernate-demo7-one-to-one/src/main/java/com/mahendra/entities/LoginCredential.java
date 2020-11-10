package com.mahendra.entities;

import javax.persistence.*;

@Entity
@Table(name="login_credentials")
public class LoginCredential {
	
	@Id 
	@Column(name="cust_id")
	private Integer custId;
	
	@Column(name="user_name",length=20)
	private String userName;
	
	@Column(name="password",length=20)
	private String password;
	
	@Column(name="enabled",length=1)
	private String enabled;

	
	//The OTHER SIDE need a property with name "credentials"
	// Refer to Property declared on line#23 of customer class
	@OneToOne(mappedBy="credentials",fetch=FetchType.LAZY)
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public LoginCredential() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
