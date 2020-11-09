package com.mahendra.entities;

import javax.persistence.*;

@Entity  /// Mark this CLASS as "Entity"
@Table(name="products") ///Link with Relational Table
public class Product {
	
	@Id @Column(name="productId")
	private Integer productId;
	
	@Column(name="pname",length=25)
	private String name;
	
	@Column(name="price")
	private Float price;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
