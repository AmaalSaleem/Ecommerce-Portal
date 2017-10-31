package com.niit.model;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;
@Entity
@Table
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int productId;
	String productName,productDesc;
	int stock,price;
	
	@ManyToOne
	@JoinColumn(name="CID")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="SID")
	private Supplier supplier;
	
	
	@Transient
	MultipartFile pimage;
	
	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductDesc() {
		return productDesc;
	}


	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public MultipartFile getPimage() {
		return pimage;
	}


	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}


	
	
	

}
