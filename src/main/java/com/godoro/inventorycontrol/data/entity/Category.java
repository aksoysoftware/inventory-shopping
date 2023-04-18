package com.godoro.inventorycontrol.data.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    @Id
    private Long categoryId;
    
    @Column(name="category_name")
    private String  categoryName;

    @JsonManagedReference
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    
    
    public Category( String categoryName, List<Product> products) {
		super();
		
		this.categoryName = categoryName;
		this.products = products;
	}


	public Category() {
		super();
	}


	public Category(Long categoryId, String categoryName, List<Product> products) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.products = products;
	}

	public Category(Long categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}


	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
    
    
    
    

	
    
    
}