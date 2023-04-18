package com.godoro.inventorycontrol.businness;

import java.util.List;

import com.godoro.inventorycontrol.data.entity.Category;


public interface CategoryService {
		List<Category> findAll();
	    Category findById(Long categoryId);
	    Category save(Category category);
	    void deleteById(Long categoryId);
	    public List<Category> getAllCategories();
		
}
