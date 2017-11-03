package com.niit.model;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



public class Cart 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int cartID;
	
	private String cartProdName;
	private int cartProdID;
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userMailID")
	private User cartUserDetails;
	
	
	
	private Double cartPrice;
	private int cartQnty;
	private String cartImg;
	
	
	public Cart(int cartID ,int cartProdID ,User cartUserDetails, Double cartPrice, int cartQnty )
	{
		this.cartID=cartID;
		this.cartProdID=cartProdID;
		this.cartUserDetails=cartUserDetails;
		this.cartPrice=cartPrice;
		this.cartQnty=cartQnty;
		
	}
}
