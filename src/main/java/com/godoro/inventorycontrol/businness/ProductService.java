package com.godoro.inventorycontrol.businness;

import java.util.List;

import com.godoro.inventorycontrol.data.entity.Category;
import com.godoro.inventorycontrol.data.entity.Product;

public interface ProductService {
		List<Product> findAll();
	    Product findById(Long productId);
	    Product save(Product product);
	    void deleteById(Long productId);
	    List<Product> findByCategory(Category category);
}
