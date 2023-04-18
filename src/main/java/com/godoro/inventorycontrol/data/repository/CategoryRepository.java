package com.godoro.inventorycontrol.data.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godoro.inventorycontrol.data.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
