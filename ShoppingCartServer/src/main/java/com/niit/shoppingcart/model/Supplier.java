package com.niit.shoppingcart.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Supplier")
@Component
public class Supplier {
	@Id
	private String id;
	private String name;
	private String address;
	
	
	private String createdBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	


	}

