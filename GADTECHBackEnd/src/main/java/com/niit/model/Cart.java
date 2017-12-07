package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

import javassist.SerialVersionUID;

@Component
@Entity
@Table
public class Cart implements Serializable
{
	private static final long SerialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int cartID;
	
	@ManyToOne
	@JoinColumn(name="userMailID")
	private User cartUserDetails;
	
	
	
	private int cartQnty;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public User getCartUserDetails() {
		return cartUserDetails;
	}

	public void setCartUserDetails(User cartUserDetails) {
		this.cartUserDetails = cartUserDetails;
	}

	public int getCartQnty() {
		return cartQnty;
	}

	public void setCartQnty(int cartQnty) {
		this.cartQnty = cartQnty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}



	
	
}
