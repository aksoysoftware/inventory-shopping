package com.godoro.inventorycontrol.data.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godoro.inventorycontrol.data.entity.Category;
import com.godoro.inventorycontrol.data.entity.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

	List<Product> findByCategory(Category category);
	
}
