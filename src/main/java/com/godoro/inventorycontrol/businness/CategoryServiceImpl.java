package com.godoro.inventorycontrol.businness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godoro.inventorycontrol.data.entity.Category;
import com.godoro.inventorycontrol.data.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	 	@Autowired
	    private CategoryRepository categoryRepository;

	    @Override
	    public List<Category> findAll() {
	        return categoryRepository.findAll();
	    }

	    @Override
	    public Category findById(Long categoryId) {
	        return categoryRepository.findById(categoryId).orElse(null);
	    }

	    @Override
	    public Category save(Category category) {
	        return categoryRepository.save(category);
	    }

	    @Override
	    public void deleteById(Long categoryId) {
	        categoryRepository.deleteById(categoryId);
	    }

	    @Override
	    public List<Category> getAllCategories() {
	        return categoryRepository.findAll();
	    }


}
