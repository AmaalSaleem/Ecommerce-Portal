package com.niit.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table
public class Category 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int catgId;
	
	
	
	String catgName;
	String catgDescrip;
	
	@OneToMany(targetEntity=Product.class,fetch=FetchType.EAGER,mappedBy="category")
	private Set<Product> product;
	
	
	public int getCatgId() {
		return catgId;
	}
	public void setCatgId(int catgId) {
		this.catgId = catgId;
	}
	public String getCatgName() {
		return catgName;
	}
	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}
	public String getCatgDescrip() {
		return catgDescrip;
	}
	public void setCatgDescrip(String catgDescrip) {
		this.catgDescrip = catgDescrip;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	

}
