package com.godoro.inventorycontrol.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godoro.inventorycontrol.data.entity.Cart;
import com.godoro.inventorycontrol.data.entity.CartProduct;
import com.godoro.inventorycontrol.data.entity.Product;

public interface CartProductRepository extends  JpaRepository<CartProduct, Long> {
	   List<CartProduct> findByCartAndProduct(Cart cart, Product product);
}
