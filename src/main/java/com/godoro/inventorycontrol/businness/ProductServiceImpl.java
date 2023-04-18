package com.godoro.inventorycontrol.businness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godoro.inventorycontrol.data.entity.Category;
import com.godoro.inventorycontrol.data.entity.Product;
import com.godoro.inventorycontrol.data.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

}
