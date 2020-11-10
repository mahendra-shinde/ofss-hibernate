package com.mahendra.entities;

import javax.persistence.*;
@Entity
@Table(name="city")
public class City {
	
	@Id @Column(name="ID")
	private Integer id;
	
	@Column(name="NAME",length=35)
	private String name;
	
	@Column(name="countrycode",length=3)
	private String countryCode;
	
	@Column(name="district",length=20)
	private String district;

	@Column(name="Info",length=255)
	private String info;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
