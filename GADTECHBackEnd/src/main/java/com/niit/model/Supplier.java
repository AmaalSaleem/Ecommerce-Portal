package com.niit.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Supplier
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int splrId;
	
	String splrName,splrAddress;
	
	@OneToMany(targetEntity=Product.class,fetch=FetchType.EAGER,mappedBy="supplier")
	private Set<Product> product;
	
	public int getSplrId() {
		return splrId;
	}

	public void setSplrId(int splrId) {
		this.splrId = splrId;
	}

	public String getSplrName() {
		return splrName;
	}

	public void setSplrName(String splrName) {
		this.splrName = splrName;
	}

	public String getSplrAddress() {
		return splrAddress;
	}

	public void setSplrAddress(String splrAddress) {
		this.splrAddress = splrAddress;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}


	
	
	

}
