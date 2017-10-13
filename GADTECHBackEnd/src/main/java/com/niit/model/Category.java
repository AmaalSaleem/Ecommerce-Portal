package com.niit.model;

import javax.persistence.*;

@Entity
@Table
public class Category 
{
	@Id
	int catgId;
	
	
	
	String catgName;
	String catgDescrip;
	
	
	
	
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
	

}
