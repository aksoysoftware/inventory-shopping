package com.godoro.inventorycontrol.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.inventorycontrol.businness.CategoryServiceImpl;
import com.godoro.inventorycontrol.businness.ProductServiceImpl;
import com.godoro.inventorycontrol.data.entity.Category;
import com.godoro.inventorycontrol.data.entity.Product;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }
    @GetMapping("/categories1")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.findById(categoryId);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/categories/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable("categoryId") Long categoryId,
                                                    @RequestBody Category category) {
        Category currentCategory = categoryService.findById(categoryId);
        if (currentCategory != null) {
            currentCategory.setCategoryName(category.getCategoryName());
            categoryService.save(currentCategory);
            return new ResponseEntity<>(currentCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.findById(categoryId);
        if (category != null) {
            categoryService.deleteById(categoryId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) {
        Product product = productService.findById(productId);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId,
                                                  @RequestBody Product product) {
        Product currentProduct = productService.findById(productId);
        if (currentProduct != null) {
            currentProduct.setProductName(product.getProductName());
            currentProduct.setSalesPrice(product.getSalesPrice());
            currentProduct.setCategory(product.getCategory());
            productService.save(currentProduct);
            return new ResponseEntity<>(currentProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("productId") Long productId) {
        Product product = productService.findById(productId);
        if (product != null) {
            productService.deleteById(productId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
