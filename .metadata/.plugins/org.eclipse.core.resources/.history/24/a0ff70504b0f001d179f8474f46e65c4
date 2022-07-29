package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product {
	@Id
	@SequenceGenerator(name="product_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "product_seq", strategy = GenerationType.SEQUENCE)
	private int productId;
	private String productName;
	private double productCost;
	private String productImage;
	private String productDescription;
	
	//Mappings
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	List<Transaction> transactions;
	
	//Getters and Setters
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

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Product() {
		
	}
	
	//Parameterized Constructor
	
	public Product(int productId, String productName, double productCost, String productImage,
			String productDescription, List<Transaction> transactions) {
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.productImage = productImage;
		this.productDescription = productDescription;
		this.transactions = transactions;
	}

}
