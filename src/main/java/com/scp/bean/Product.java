package com.scp.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize
public class Product {
	
	@SequenceGenerator(name="prodseq", initialValue=1, allocationSize=1, sequenceName="prod_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prodseq")
	@Id
	private int productId;
	private String productName;
	private int productPrice;
	private String productCategory;
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
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	@Override
	public String toString() {
		return "\nProduct [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCategory=" + productCategory + "]";
	}
	public Product(int productId, String productName, int productPrice, String productCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	
}
