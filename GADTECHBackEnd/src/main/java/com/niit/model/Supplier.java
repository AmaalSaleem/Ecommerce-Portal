package com.niit.model;

import javax.persistence.*;

@Entity
@Table
public class Supplier
{
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

	@Id
	int splrId;
	
	String splrName,splrAddress;
	
	
	
	

}
