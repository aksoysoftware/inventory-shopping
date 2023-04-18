package com.godoro.inventorycontrol.data.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long productId;

	    private String productName;

	    private double salesPrice;

	    @JsonBackReference
	    @ManyToOne
	    private Category category;
	    
	    
	    

		public Product() {
			super();
		}

		public Product(Long productId, String productName, double salesPrice, Category category) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.salesPrice = salesPrice;
			this.category = category;
		}

		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public double getSalesPrice() {
			return salesPrice;
		}

		public void setSalesPrice(double salesPrice) {
			this.salesPrice = salesPrice;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		
	    
	    
		
		
	
}
