package com.godoro.inventorycontrol.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godoro.inventorycontrol.data.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
